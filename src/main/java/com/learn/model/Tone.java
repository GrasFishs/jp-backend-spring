package com.learn.model;

public class Tone {


    private long id;

    private int index;

    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tone{" +
                "id=" + id +
                ", index=" + index +
                ", type=" + type +
                '}';
    }
}
