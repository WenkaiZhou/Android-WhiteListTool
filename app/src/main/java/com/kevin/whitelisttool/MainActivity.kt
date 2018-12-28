package com.kevin.whitelisttool

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.kevin.whitelisttool.network.OkHttpCall
import com.kevin.whitelisttool.util.DeviceUtils
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

    private lateinit var loading: ProgressBar

    companion object {
        const val URL =
            "https://raw.githubusercontent.com/xuehuayous/Android-WhiteListTool/master/WHITE_LIST.md"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loading = findViewById(R.id.loading)
        val deviceInfoTextView = findViewById<TextView>(R.id.tv_device_info)
        val deviceInfo =
            "${DeviceUtils.getModel()} ${DeviceUtils.getIncrementalVersion()}(${DeviceUtils.getReleaseVersion()})"
        Log.e("TAG", "deviceInfo: $deviceInfo")
        deviceInfoTextView.text = deviceInfo
    }

    fun openSettings(view: View) {
        loading.visibility = View.VISIBLE
        view.isEnabled = false

        val request = Request.Builder()
            .url(URL)
            .get()
            .build()
        val call = client.newCall(request)
        val okHttpCall = OkHttpCall(call)
        okHttpCall.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                loading.visibility = View.GONE
                view.isEnabled = true
                Log.e("TAG", "error: ${e.message}")
                findViewById<TextView>(R.id.tv_info).text = e.message
                Toast.makeText(applicationContext, "获取数据超时，请重试！", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call, response: Response) {
                loading.visibility = View.GONE
                view.isEnabled = true
                val result = response.body()!!.string()
                    .replace("{package}", packageName)
                    .replace("{label}", getAppName(this@MainActivity))

                Log.d("TAG", "responseStr: $result")
                findViewById<TextView>(R.id.tv_info).text = result

                val whiteListInfo = Gson().fromJson<WhiteListInfo>(result, WhiteListInfo::class.java)
                Log.d("TAG", "size: ${whiteListInfo.items?.size}")
                val brand = DeviceUtils.getBrand()
                Log.d("TAG", "brand: $brand")
                whiteListInfo.items?.forEach { whiteList ->
                    if (brand.toLowerCase() == whiteList.device?.brand?.toLowerCase()) {
                        whiteList.intents?.forEach { intent ->
                            val target = createIntent(intent)
                            if (doesActivityExists(target)) {
                                showTip(intent.title, intent.message, target)
                            }
                        }
                    }
                }

            }

        })
    }

    private fun showTip(title: String, message: String, target: Intent) {
        AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle(title)
            .setMessage("$message \n\n")
            .setPositiveButton("确定") { d, w ->
                startActivitySafely(target)
            }
            .show()
    }

    private fun createIntent(intent: WhiteListInfo.IntentItem): Intent {
        val target = Intent()
        target.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (intent.action.isNotEmpty()) {
            target.action = intent.action
        }
        if (intent.component != null) {
            target.component = ComponentName(intent.component!!.pkg, intent.component!!.cls)
        }
        if (intent.extras != null) {
            intent.extras!!.forEach { extra ->
                target.putExtra(extra.key, extra.value)
            }
        }
        return target
    }

    /**
     * 判断本机上是否有能处理当前Intent的Activity
     */
    private fun doesActivityExists(intent: Intent): Boolean {
        val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return list != null && list.size > 0
    }

    /**
     * 安全地启动一个Activity
     */
    private fun startActivitySafely(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            findViewById<TextView>(R.id.tv_info).text = e.message
        }
    }

    /**
     * 获取App的名称
     *
     * @param context 上下文
     * @return 名称
     */
    fun getAppName(context: Context): String {
        val pm = context.packageManager
        try {
            val packageInfo = pm.getPackageInfo(context.packageName, 0)
            val applicationInfo = packageInfo.applicationInfo
            val labelRes = applicationInfo.labelRes
            return context.resources.getString(labelRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

}
