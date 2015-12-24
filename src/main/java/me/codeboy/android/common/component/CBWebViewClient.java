package me.codeboy.android.common.component;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 重写WebViewClient，实现自身打开链接
 * @author yuedong.lyd
 *
 */
public class CBWebViewClient extends WebViewClient{
	@Override 
	public boolean shouldOverrideUrlLoading(WebView view, String url) { 
		view.loadUrl(url); 
		return false; 
	} 
}
