package me.codeboy.android.common.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import me.codeboy.android.common.component.CBHandler;

/**
 * 为了避免handler造成的内存泄露，将handler集成到Activity中
 * Created by yuedong.lyd on 6/8/15.
 */
public abstract class CBActivity extends Activity {
    public CBHandler.UnleakHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new CBHandler.UnleakHandler(this);
    }

    /**
     * 处理消息
     *
     * @param msg message
     */
    public abstract void processMessage(Message msg);

    /**
     * 根据id查找试图
     *
     * @param resId resource id
     * @param <T>   generics
     * @return view
     */
    private <T extends View> T findView(int resId) {
        return (T) findViewById(resId);
    }
}