package com.learn.model;

import java.util.List;

public class Word {

    private int id;

    private String text;

    private Notation notation;

    private List<Mean> means;

    private List<Sentence> sentences;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Notation getNotation() {
        return notation;
    }

    public void setNotation(Notation notation) {
        this.notation = notation;
    }

    public List<Mean> getMeans() {
        return means;
    }

    public void setMeans(List<Mean> means) {
        this.means = means;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
