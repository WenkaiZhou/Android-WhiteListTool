package com.kevin.whitelisttool.network

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 * HttpURLConnectionNetworkTask
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-20 17:01:50
 *         Major Function：<b>以HttpURLConnection访问网络AsyncTask,
 *         访问网络在子线程进行并返回主线程通知访问的结果</b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
class HttpURLConnectionNetworkTask(method: String) : NetworkTask(method) {

    override fun doGet(httpUrl: String): String {
        var result: String
        try {
            val url = URL(httpUrl)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.readTimeout = 5000
            urlConnection.connectTimeout = 5000
            urlConnection.setRequestProperty("Charset", "UTF-8")
            if (urlConnection.responseCode == 200) {
                val inputStream = urlConnection.inputStream
                result = readFromStream(inputStream)
            } else {
                isSuccess = false
                result = "网络响应状态码不为200!"
            }
        } catch (e: IOException) {
            isSuccess = false
            result = "网络访问错误:${e.message}"
        }
        return result
    }

    override fun doPost(httpUrl: String, paramMap: MutableMap<String, String>): String {
        var result: String
        try {
            val url = URL(httpUrl)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "POST"
            urlConnection.readTimeout = 5000
            urlConnection.connectTimeout = 5000
            // 配置连接的Content-type
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            urlConnection.doOutput = true    // 发送POST请求必须设置允许输出
            urlConnection.doInput = true     // 发送POST请求必须设置允许输入

            var data = ""
            var firstParam = true
            paramMap.forEach { param ->
                if (firstParam) {
                    data += param.key + "=" + URLEncoder.encode(param.value, "UTF-8")
                    firstParam = false
                } else {
                    data += "&" + param.key + "=" + URLEncoder.encode(param.value, "UTF-8")
                }
            }

            urlConnection.connect()

            val os = urlConnection.outputStream
            os.write(data.toByteArray())
            os.flush()


            if (urlConnection.responseCode == 200) {
                val inputStream = urlConnection.inputStream
                result = readFromStream(inputStream)
            } else {
                isSuccess = false
                result = "网络响应状态码不为200!"
            }
        } catch (e: IOException) {
            isSuccess = false
            result = "网络访问错误:${e.message}"
        }

        return result
    }


    /**
     * 输入流获取字符串
     *
     * @param inputStream 输入流
     * @return String 返回的字符串
     * @throws IOException
     */
    private fun readFromStream(inputStream: InputStream): String {
        val baos = ByteArrayOutputStream()
        val buffer = ByteArray(1024)
        var len = 0

        while (inputStream.read(buffer).apply { len == this } > 0) {
            baos.write(buffer, 0, len)

        }

        inputStream.close()
        val result = baos.toString()
        baos.close()
        return result
    }
}