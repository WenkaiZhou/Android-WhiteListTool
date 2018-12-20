package com.kevin.whitelisttool.network

import android.os.AsyncTask

/**
 * NetworkTask
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-20 16:30:21
 *         Major Function：<b>NetworkTask</b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
abstract class NetworkTask(val method: String) : AsyncTask<String, Integer, String>() {

    companion object {
        const val TAG = "NetworkTask"
        const val GET = "GET"
        const val POST = "POST"
    }

    // 是否访问网络成功
    protected var isSuccess = true

    // 监听回调
    private var responceLintener: ResponceLintener? = null

    init {
        if (method != GET && method != POST) {
            throw IllegalArgumentException("Request mode can only be GET or POST!")
        }
    }

    override fun doInBackground(vararg params: String?): String {
        if (params.isEmpty()) {
            throw IllegalArgumentException("Contain at least a url param!")
        }


        val data: String
        val url = params[0]!!
        if (GET == method) {
            data = doGet(url)
        } else {
            val paramMap = HashMap<String, String>()
            // 第一个参数为访问的接口,不为body参数
            params
                .drop(1)
                .forEach { param ->
                    val value = ArrayList<String>(2)
                    param!!.split("=")
                        .take(2)
                        .forEach {
                            value.add(it)
                        }
                }
            data = doPost(url, paramMap)
        }
        return data
    }

    override fun onPostExecute(result: String?) {
        if (responceLintener != null) {
            if (isSuccess) {
                responceLintener!!.onSuccess(result!!)
            } else {
                responceLintener!!.onError(result!!)
            }
        }
    }

    /**
     * 以GET的方式访问网络
     *
     * @param url
     * @return 返回的字符串数据
     */
    abstract fun doGet(url: String): String

    /**
     * 以POST的方式访问网络
     *
     * @param url
     * @param paramMap
     * @return 返回的字符串数据
     */
    abstract fun doPost(url: String, paramMap: MutableMap<String, String>): String

    fun setResponceLintener(lintener: ResponceLintener) {
        this.responceLintener = lintener
    }

    interface ResponceLintener {
        /**
         * 成功的监听回调
         * @param result
         */
        fun onSuccess(result: String)

        /**
         * 失败的监听回调
         * @param error
         */
        fun onError(error: String)
    }
}