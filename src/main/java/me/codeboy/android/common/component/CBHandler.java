package me.codeboy.android.common.component;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import me.codeboy.android.common.app.CBActivity;

/**
 * Created by yuedong.lyd on 6/7/15.
 * <p>
 * 构建防止内存泄露的handler
 * </p>
 */
public class CBHandler {
    /**
     * 防止handler对activity有隐式引用，匿名内部类不会对外部类有引用
     */
    public static class UnleakHandler extends Handler {
        private final WeakReference<CBActivity> mActivity;

        public UnleakHandler(CBActivity activity) {
            this.mActivity = new WeakReference<CBActivity>(activity);
        }

        @Override
        public void dispatchMessage(Message msg) {
            Activity activity = mActivity.get();
            if (activity != null && !activity.isFinishing()) {
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed()) {
                        return;
                    }
                }
                super.dispatchMessage(msg);
            }
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mActivity.get() == null) {
                return;
            }
            mActivity.get().processMessage(msg);
        }
    }
}