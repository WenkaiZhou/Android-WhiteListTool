package com.kevin.whitelisttool

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.gson.Gson
import com.kevin.whitelisttool.network.HttpURLConnectionNetworkTask
import com.kevin.whitelisttool.network.NetworkTask
import com.kevin.whitelisttool.util.DeviceUtils


class MainActivity : AppCompatActivity() {

    companion object {
        const val URL =
            "https://raw.githubusercontent.com/xuehuayous/Android-WhiteListTool/master/app/src/main/assets/WHITE_LIST.md"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSettings(view: View) {
        val networkTask: NetworkTask = HttpURLConnectionNetworkTask(NetworkTask.POST)
        networkTask.execute("http://123.57.31.11/androidnet/getJoke", "id=5")
        networkTask.setResponceLintener(object : NetworkTask.ResponceLintener {
            override fun onSuccess(result: String) {

                val whiteListInfo = Gson().fromJson<WhiteListInfo>(result, WhiteListInfo::class.java)
                val brand = DeviceUtils.getBrand()
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

            override fun onError(error: String) {
                System.out.print(error)
            }
        })
    }

    private fun showTip(title: String, message: String, target: Intent) {
        AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle(title)
            .setMessage("${message}。\n\n")
            .setPositiveButton("确定") { d, w ->
                startActivitySafely(target)
            }
            .show()
    }

    private fun createIntent(intent: WhiteListInfo.IntentItem): Intent {
        val target = Intent()
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
        }
    }

}
