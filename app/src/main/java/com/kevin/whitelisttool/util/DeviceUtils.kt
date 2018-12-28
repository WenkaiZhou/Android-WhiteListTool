package com.kevin.whitelisttool.util

/**
 * DeviceUtils
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-19 18:55:39
 *         Major Function：<b>设备信息获取帮助类</b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
object DeviceUtils {

    /**
     * 获取厂商名称 如: Xiaomi
     */
    fun getManufacturer() = android.os.Build.MANUFACTURER

    /**
     * 获取品牌名称 如: Xiaomi
     */
    fun getBrand() = android.os.Build.BRAND

    /**
     * 获取机型 如: MIX 2
     */
    fun getModel() = android.os.Build.MODEL

    /**
     * 获取系统版本 如: 8.0.0
     */
    fun getSystemVersion() = android.os.Build.VERSION.RELEASE

    /**
     * 获取内部版本号
     */
    fun getIncrementalVersion() = android.os.Build.VERSION.INCREMENTAL

    /**
     * 获取系统版本号
     */
    fun getReleaseVersion() = android.os.Build.VERSION.RELEASE
}