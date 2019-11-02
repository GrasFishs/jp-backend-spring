package com.learn.model;

import java.util.List;

public class User {

    private long id;

    private String openId;

    private String nickname;

    private String avatarUrl;

    private short gender;

    private String country;

    private String province;

    private String city;

    private List<Book> books;

    private List<UserWord> userWords;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", books=" + books +
                ", userWords=" + userWords +
                '}';
    }
}
