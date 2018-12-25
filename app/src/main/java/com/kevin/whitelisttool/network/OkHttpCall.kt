package com.kevin.whitelisttool.network

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import okio.Timeout
import java.io.IOException

/**
 * OkHttpCall
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-25 11:08:44
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */

class OkHttpCall(private val realCall: okhttp3.Call) : okhttp3.Call {

    override fun enqueue(callback: Callback) {
        realCall.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                MainThreadExecutor.instance.execute {
                    callback.onFailure(call, e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                MainThreadExecutor.instance.execute {
                    try {
                        callback.onResponse(call, response)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }

    override fun isExecuted(): Boolean {
        return realCall.isExecuted
    }

    override fun timeout(): Timeout {
        return realCall.timeout()
    }

    override fun clone(): Call {
        return realCall.clone()
    }

    override fun isCanceled(): Boolean {
        return realCall.isCanceled
    }

    override fun cancel() {
        realCall.cancel()
    }

    override fun request(): Request {
        return realCall.request()
    }

    override fun execute(): Response {
        return realCall.execute()
    }

}