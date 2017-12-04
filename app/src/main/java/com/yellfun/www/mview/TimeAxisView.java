package com.yellfun.www.mview;

import java.util.List;

import com.listviewdemo_expandablelistview.R;
import com.yellfun.www.bean.Exhibit;
import com.yellfun.www.bean.Room;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class TimeAxisView extends RelativeLayout {
    private Context mcontext;
    private LinearLayout la;

    public TimeAxisView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mcontext).inflate(R.layout.time_axis_view, this);
        la = (LinearLayout) findViewById(R.id.la_time_axis);
    }

    public void addView(String title, List<Exhibit> content) {
        View child = new TimeAxisItemView(mcontext, title, content);
        child.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("一级节点1.1测试", "1.1测试: 1.1测试");
            }
        });
        la.addView(child);
    }

    public void clear() {
        la.removeAllViews();
    }

    public void setData(List<Room> room) {
        clear();
        for (Room r : room) {
            addView(r.getRoomName(), r.getExhibits());
        }
    }
}
