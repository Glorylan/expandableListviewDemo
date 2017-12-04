package com.yellfun.www.bean;

import java.util.List;

public class VisitLine {
    private String lineName;
    private List<Room> room;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

}
