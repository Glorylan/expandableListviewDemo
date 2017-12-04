package com.yellfun.www.adapter;

import java.util.List;

import com.listviewdemo_expandablelistview.R;
import com.yellfun.www.bean.Room;
import com.yellfun.www.bean.VisitLine;
import com.yellfun.www.mview.TimeAxisView;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * expandableListView适配器
 */
public class ExAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<VisitLine> data;

    public ExAdapter(Context context, List<VisitLine> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition).getLineName();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getRoom();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 显示：group
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(getGroup(groupPosition).toString());
        holder.textView.setTextSize(15);
        holder.textView.setPadding(36, 10, 0, 10);
        return convertView;
    }

    /**
     * 显示：child
     */
    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        @SuppressWarnings("unchecked")
        List<Room> child = (List<Room>) getChild(groupPosition, childPosition);
        TimeAxisView view;
        if (convertView == null) {
            view = new TimeAxisView(context, null);
        } else {
            view = (TimeAxisView) convertView;
        }
        view.setData(child);
        return view;
    }

    class ViewHolder {
        TextView textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
