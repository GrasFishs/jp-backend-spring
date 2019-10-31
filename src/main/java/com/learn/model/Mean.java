package com.learn.model;

public class Mean {

    private long id;

    private String mean;

    private Speech speech;

    public Speech getSpeech() {
        return speech;
    }

    public void setSpeech(Speech speech) {
        this.speech = speech;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
