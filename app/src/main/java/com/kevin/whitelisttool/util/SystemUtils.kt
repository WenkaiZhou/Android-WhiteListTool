package com.kevin.whitelisttool.util

import android.annotation.SuppressLint
import android.os.Build

/**
 * SystemUtils
 *
 * @author zhouwenkai@baidu.com, Created on 2018-12-27 16:33:23
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
object SystemUtils {


    fun isMIUI(): Boolean {
        var version: Int = -1
        try {
            val versionName = getProperty("ro.miui.ui.version.name")
            version = if (versionName.isNullOrEmpty()) {
                0
            } else {
                versionName.toInt()
            }
        } catch (e: Exception) {
        }

        if (version != -1 &&
            (Build.FINGERPRINT.toLowerCase().contains("xiaomi")
                    || Build.FINGERPRINT.toLowerCase().contains("miui"))
        ) {
            return true
        }
        return false
    }

    @SuppressLint("PrivateApi")
    fun getProperty(propertyName: String): String? {
        var result: String? = null
        try {
            val properties = Class.forName("android.os.SystemProperties")
            val property = properties.getMethod("get", String::class.java).invoke(properties, propertyName)
            if (property != null && property is String) {
                result = property
            }
        } catch (e: Exception) {
        }
        return result
    }

}