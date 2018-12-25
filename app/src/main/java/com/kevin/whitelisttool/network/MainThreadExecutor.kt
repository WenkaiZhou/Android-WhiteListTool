package com.kevin.whitelisttool.network

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

/**
 * MainThreadExecutor
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-25 11:21:13
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
class MainThreadExecutor private constructor() : Executor {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        @JvmStatic
        val instance: MainThreadExecutor by lazy { MainThreadExecutor() }
    }

    override fun execute(command: Runnable?) {
        handler.post(command)
    }

}