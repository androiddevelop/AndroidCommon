package me.codeboy.android.common.component;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import me.codeboy.android.common.R;

/**
 * listview修饰高度
 * @author yuedong.lyd
 */
public class CBListViewDecorate {
    /**
     * 无数据listview
     *
     * @param context
     * @param listview
     */
    public static void noDataListview(Context context, ListView listview) {
        noDataListview(context, listview, context.getResources().getString(R.string.cb_no_data));
    }

    /**
     * 自定义显示listview
     *
     * @param context
     * @param listview
     */
    public static void noDataListview(Context context, ListView listview, int stringId) {
        noDataListview(context, listview, context.getResources().getString(stringId));
    }

    /**
     * 自定义显示listview
     *
     * @param context
     * @param listview
     */
    public static void noDataListview(Context context, ListView listview, String str) {
        TextView emptyView = new TextView(context);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        emptyView.setLayoutParams(lp);
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setText(str);

        emptyView.setVisibility(View.GONE);
        ((ViewGroup) listview.getParent()).addView(emptyView);

        listview.setEmptyView(emptyView);
    }

    /**
     * 设置listview高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}