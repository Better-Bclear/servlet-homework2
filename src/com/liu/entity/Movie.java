package com.liu.entity;

import java.util.Date;

public class Movie {
    //电影id
    private Integer movie_id;
    //电影中文名
    private String movie_cn_name;
    //电影粤语名
    private String movie_fg_name;
    //电影演员
    private String movie_actor;
    //电影作者
    private String movie_director;
    //电影简介
    private String movie_detail;
    //电影时长
    private String movie_duration;
    //电影类型
    private String movie_type;
    //电影评分
    private Double movie_score;

    private Double movie_box_office;
    //电影评论数
    private Integer movie_comment_count;
    //电影上映时间
    private Date movie_release_date;
    //电影封面
    private String movie_picture;
    //电影上映地点
    private String movie_country;
    //电影是否上映
    private Integer movie_state;

    public Movie() {
    }

    public Movie(Integer movie_id, String movie_cn_name, String movie_fg_name, String movie_actor, String movie_director, String movie_detail, String movie_duration, String movie_type, Double movie_score, Double movie_box_office, Integer movie_comment_count, Date movie_release_date, String movie_picture, String movie_country, Integer movie_state) {
        this.movie_id = movie_id;
        this.movie_cn_name = movie_cn_name;
        this.movie_fg_name = movie_fg_name;
        this.movie_actor = movie_actor;
        this.movie_director = movie_director;
        this.movie_detail = movie_detail;
        this.movie_duration = movie_duration;
        this.movie_type = movie_type;
        this.movie_score = movie_score;
        this.movie_box_office = movie_box_office;
        this.movie_comment_count = movie_comment_count;
        this.movie_release_date = movie_release_date;
        this.movie_picture = movie_picture;
        this.movie_country = movie_country;
        this.movie_state = movie_state;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_cn_name() {
        return movie_cn_name;
    }

    public void setMovie_cn_name(String movie_cn_name) {
        this.movie_cn_name = movie_cn_name;
    }

    public String getMovie_fg_name() {
        return movie_fg_name;
    }

    public void setMovie_fg_name(String movie_fg_name) {
        this.movie_fg_name = movie_fg_name;
    }

    public String getMovie_actor() {
        return movie_actor;
    }

    public void setMovie_actor(String movie_actor) {
        this.movie_actor = movie_actor;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_detail() {
        return movie_detail;
    }

    public void setMovie_detail(String movie_detail) {
        this.movie_detail = movie_detail;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(String movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public Double getMovie_score() {
        return movie_score;
    }

    public void setMovie_score(Double movie_score) {
        this.movie_score = movie_score;
    }

    public Double getMovie_box_office() {
        return movie_box_office;
    }

    public void setMovie_box_office(Double movie_box_office) {
        this.movie_box_office = movie_box_office;
    }

    public Integer getMovie_comment_count() {
        return movie_comment_count;
    }

    public void setMovie_comment_count(Integer movie_comment_count) {
        this.movie_comment_count = movie_comment_count;
    }

    public Date getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(Date movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    public String getMovie_picture() {
        return movie_picture;
    }

    public void setMovie_picture(String movie_picture) {
        this.movie_picture = movie_picture;
    }

    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    public Integer getMovie_state() {
        return movie_state;
    }

    public void setMovie_state(Integer movie_state) {
        this.movie_state = movie_state;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_cn_name='" + movie_cn_name + '\'' +
                ", movie_fg_name='" + movie_fg_name + '\'' +
                ", movie_actor='" + movie_actor + '\'' +
                ", movie_director='" + movie_director + '\'' +
                ", movie_detail='" + movie_detail + '\'' +
                ", movie_duration='" + movie_duration + '\'' +
                ", movie_type='" + movie_type + '\'' +
                ", movie_score=" + movie_score +
                ", movie_box_office=" + movie_box_office +
                ", movie_comment_count=" + movie_comment_count +
                ", movie_release_date=" + movie_release_date +
                ", movie_picture='" + movie_picture + '\'' +
                ", movie_country='" + movie_country + '\'' +
                ", movie_state=" + movie_state +
                '}';
    }
}
