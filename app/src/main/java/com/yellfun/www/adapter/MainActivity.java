package com.yellfun.www.adapter;

import java.util.ArrayList;
import java.util.List;

import com.listviewdemo_expandablelistview.R;
import com.yellfun.www.bean.Exhibit;
import com.yellfun.www.bean.Room;
import com.yellfun.www.bean.VisitLine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
    private ExpandableListView listView;
    private List<VisitLine> lines;
    private ExAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.expandableListView);
        listView.setGroupIndicator(null);
        /**
         * 初始化数据
         */
        initData();
        adapter = new ExAdapter(this, lines);
        listView.setAdapter(adapter);
        //遍历所有group,将所有项设置成默认展开
        int groupCount = listView.getCount();
        for (int i = 0; i < groupCount; i++) {
            listView.expandGroup(i);
        }
    }

    private void initData() {
        //首项
        lines = new ArrayList<VisitLine>();
        VisitLine vl = new VisitLine();
        for (int i = 0; i < 5; i++) {
            vl.setLineName("1.项目建议书（备案）");
            lines.add(vl);
        }
        //子项
        List<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < 5; i++) {
            addInfo(rooms, "1.1业主备件", new String[]{"1.1.1 科比", "1.1.2 麦迪"});
        }
        vl.setRoom(rooms);
    }

    /**
     * 添加数据信息
     *
     * @param g
     * @param c
     */
    private void addInfo(List<Room> rooms, String g, String[] c) {
        Room room = new Room();
        room.setRoomName(g);
        List<Exhibit> es = new ArrayList<Exhibit>();
        for (int i = 0; i < c.length; i++) {
            Exhibit e = new Exhibit();
            e.setId(i);
            e.setName(c[i]);
            es.add(e);
        }
        room.setExhibits(es);
        rooms.add(room);
    }

}
