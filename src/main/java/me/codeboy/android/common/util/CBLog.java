package me.codeboy.android.common.util;

import android.util.Log;

/**
 * 日志打印
 * Created by yuedong.lyd on 6/27/15.
 */
public class CBLog {
    private static boolean onOff = false;

    /**
     * 错误
     * @param title title
     * @param msg message
     */
    public static void e(String title, Object msg) {
        if (onOff) {
            Log.e("======>" + title, msg + "");
        }
    }

    /**
     * 信息
     * @param title title
     * @param msg message
     */
    public static void i(String title, Object msg) {
        if (onOff) {
            Log.e("======>" + title, msg + "");
        }
    }

    /**
     * 设置日志开关
     * @param onOff 开关
     */
    public static void setOnOff(boolean onOff){
        CBLog.onOff = onOff;
    }
}