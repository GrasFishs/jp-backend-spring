package com.learn.model;

import java.util.List;

public class Notation {
    private long id;

    private String text;

    private List<Tone> tones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tone> getTones() {
        return tones;
    }

    public void setTones(List<Tone> tones) {
        this.tones = tones;
    }
}
