package me.codeboy.android.common.component;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import java.lang.Thread.UncaughtExceptionHandler;

import me.codeboy.android.common.R;
import me.codeboy.android.common.util.CBLog;

/**
 * 全局异常
 * 
 * @author yuedong.lyd
 * 
 */

public class CBExceptionHandler implements UncaughtExceptionHandler {

	private static CBExceptionHandler crashHandler = null;
	private Context context;

	private CBExceptionHandler() {
	}

	/**
	 * 单例模式获取异常句柄
	 * 
	 * @return
	 */
	public static CBExceptionHandler getInstance() {
		if (crashHandler == null)
			crashHandler = new CBExceptionHandler();
		return crashHandler;
	}

	/**
	 * 设置系统默认UncaughtExceptionHandler
	 */
	public void init(Context context) {
		this.context = context;
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	// 错误时打印日志
	@Override
	public synchronized void uncaughtException(Thread thread, Throwable ex) {
		CBLog.e("exception", ex.getLocalizedMessage());
		new Thread() {
			@Override
			public void run() {
				// Toast 显示需要出现在一个线程的消息队列中
				Looper.prepare();
				Toast.makeText(context, R.string.cb_app_error,
						Toast.LENGTH_LONG).show();
				Looper.loop();
			}
		}.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			CBLog.e("ERROR", e.getMessage());
		}
		CBApplication.getInstance().appExit();
	}
}