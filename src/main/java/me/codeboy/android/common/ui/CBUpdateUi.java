package me.codeboy.android.common.ui;

import android.os.Bundle;
import android.os.Message;

import me.codeboy.android.common.R;
import me.codeboy.android.common.app.CBActivity;

/**
 * 更新页面
 * Created by yuedong.lyd on 6/29/15.
 */
public class CBUpdateUi extends CBActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cb_update_ui);
    }

    @Override
    public void processMessage(Message msg) {

    }
}
