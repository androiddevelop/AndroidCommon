package me.codeboy.android.common.component;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

import me.codeboy.android.common.R;

/**
 * 自定义进度对话框
 *
 * @author yuedong.lyd
 */
public class CBProgressDialog extends Dialog {
    private AnimationDrawable animationDrawable;

    public CBProgressDialog(Context context) {
        super(context, R.style.CBProgressDialog);
        this.setContentView(R.layout.cb_progress_dialog);
    }

    public CBProgressDialog(Context context, int theme) {
        super(context, theme);
        this.setContentView(R.layout.cb_progress_dialog);
    }


    @Override
    public void cancel() {
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        super.cancel();
    }

    @Override
    public void show() {
        if (!isShowing()) {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        if (isShowing()) {
            super.dismiss();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView iv = (ImageView) findViewById(R.id.cb_progress_iv);
        animationDrawable = (AnimationDrawable) iv.getBackground();
        animationDrawable.start();
    }
}