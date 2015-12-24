package me.codeboy.android.common.util;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

/**
 * 手机震动
 * Created by yuedong.lyd on 6/27/15.
 */
public class CBVibrator {

    /**
     * 操作手机震动
     *
     * @param context context
     */
    public static void vibrate(Context context) {
        Vibrator mVibrator01 = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        mVibrator01.vibrate(new long[]{10, 50}, -1);
    }
}