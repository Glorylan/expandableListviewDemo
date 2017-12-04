package com.yellfun.www.mview;

import java.util.List;

import com.listviewdemo_expandablelistview.R;
import com.yellfun.www.bean.Exhibit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TimeAxisItemView extends RelativeLayout {
    private Context mcontext;
    private TextView tvTitle;
    private LinearLayout laContent;

    public TimeAxisItemView(Context context) {
        super(context);
        mcontext = context;
        initView();
    }

    public TimeAxisItemView(Context context, String title, List<Exhibit> content) {
        this(context);
        setTitle(title);
        addView(content);
    }

    private void initView() {
        LayoutInflater.from(mcontext).inflate(R.layout.time_item, this);
        tvTitle = (TextView) findViewById(R.id.tv_time_title);
        laContent = (LinearLayout) findViewById(R.id.la_time_content);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void addView(List<Exhibit> content) {
        for (final Exhibit cont : content) {
            TextView child = new TextView(mcontext);
            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Toast.makeText(mcontext, cont.getId() + "1.1.1三级列表", Toast.LENGTH_SHORT).show();
                }
            });
            child.setText(cont.getName());
            laContent.addView(child);
        }
    }
}
