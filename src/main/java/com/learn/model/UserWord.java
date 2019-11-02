package com.learn.model;

public class UserWord extends Word {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int word) {
        this.weight = word;
    }

    @Override
    public String toString() {
        return "UserWord{" +
                super.toString() +
                "weight=" + weight +
                '}';
    }
}
