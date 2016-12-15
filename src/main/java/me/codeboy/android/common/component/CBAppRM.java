package me.codeboy.android.common.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源管理器
 *
 * @author yuedong.lyd
 */
public class CBAppRM {
    private static Context context = null;
    private static Resources resources = null;
    private static DisplayMetrics displayMetrics = null;
    private static SharedPreferences sp = null;

    /**
     * 初始化
     */
    public static void init() {
        init("data");
    }

    /**
     * 初始化
     *
     * @param sharedPreferencesName sp文件名字
     */
    public static void init(String sharedPreferencesName) {
        if (context == null) {
            context = CBApplication.getInstance().getApplicationContext();
            resources = context.getResources();
            displayMetrics = resources.getDisplayMetrics();
            sp = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        }
    }

    public static String getString(int id) {
        return resources.getString(id);
    }

    /**
     * 获取raw文件夹输入流
     *
     * @param id
     * @return 输入流
     */
    public static InputStream getInputStream(int id) {
        return resources.openRawResource(id);
    }

    /**
     * 获取assets文件输入流
     *
     * @param name 资源名字
     * @return 输入流
     * @throws IOException
     */
    public static InputStream getInputStream(String name) throws IOException {
        return context.getAssets().open(name);
    }

    /**
     * 设置键值对
     *
     * @param key 键
     * @param value 值
     */
    public static void setString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    /**
     * 获取对应的值
     *
     * @param key 键
     * @param defaultStr 默认值
     * @return 字符串
     */
    public static String getString(String key, String defaultStr) {
        return sp.getString(key, defaultStr);
    }

    /**
     * 获取对应的值
     *
     * @param key 键
     * @return 字符串
     */
    public static String getString(String key) {
        return sp.getString(key, null);
    }

    /**
     * 设置键值对
     *
     * @param key 键
     * @param value 值
     */
    public static void setInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 获取对应的值
     *
     * @param key 键
     * @return 值
     */
    public static int getInt(String key) {
        return sp.getInt(key, 0);
    }

    /**
     * 设置键值对
     *
     * @param key 键
     * @param value 值
     */
    public static void setBoolean(String key, Boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取对应的值
     *
     * @param key 键
     * @return 值
     */
    public static Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    /**
     * 清除键值
     *
     * @param key 键
     */
    public static void clear(String key) {
        sp.edit().remove(key).commit();
    }


    /**
     * 提示信息
     *
     * @param message 信息
     */
    public static void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 提示信息
     *
     * @param messageId 消息id
     */
    public static void showToast(int messageId) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 提示信息
     *
     * @param message 消息
     */
    public static void showLongToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 提示信息
     *
     * @param messageId 消息id
     */
    public static void showLongToast(int messageId) {
        Toast.makeText(context, messageId, Toast.LENGTH_LONG).show();
    }

    /**
     * 获取app内图片
     *
     * @param picId 图片的id
     * @return 图片bitmap
     */
    public static Bitmap getPic(int picId) {
        Bitmap bmp;
        bmp = BitmapFactory.decodeResource(resources, picId);
        return bmp;
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px(像素)
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        return (int) (dpValue * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        return (int) (pxValue / context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
}