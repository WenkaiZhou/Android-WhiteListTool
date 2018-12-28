package com.kevin.whitelisttool.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * LocalFileUtils
 *
 * @author zwenkai@foxmail.com, Created on 2015-5-9 13:11:48
 *         Major Function：<b>读取本地包内文件</b>
 *         <p/>
 *         注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * @author mender，Modified Date Modify Content:
 */

public class LocalFileUtils {

    /**
     * 获取Asset下文本内容
     * @param context
     * @param fileName
     * @return
     */
    public final static String getStringFormAsset(Context context, String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = br.readLine()) != null) {
                buffer.append(line).append('\n');
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description 从Assets中读取图片
     *
     * @param context
     * @param fileName
     * @return 图片
     * @date 2015-6-11 15:00:55
     */
    public static Bitmap getImageFromAssetsFile(Context context, String fileName) {
        Bitmap image = null;
        AssetManager am = context.getAssets();
        InputStream is = null;
        try {
            is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return image;
        } finally {
            if(is != null) {
                try {
                    is.close();
                    is = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取Raw下文本内容
     * @param context
     * @param rawId
     * @return
     */
    public final static String getStringFormRaw(Context context, int rawId) {
        ByteArrayOutputStream baos = null;
        InputStream is = context.getResources().openRawResource(rawId);
        try {
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            return baos.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                    baos = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
