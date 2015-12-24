package me.codeboy.android.common.component;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 跑马灯TextView
 *
 * @author yuedong.lyd
 */
public class CBMarqueeTextView extends TextView {

    public CBMarqueeTextView(Context context) {
        super(context);
    }

    public CBMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CBMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }
}