package com.atelier.tennisstats.model;

public class Country {
    private String picture;
    private String code;

    public Country(String picture, String code) {
        this.picture = picture;
        this.code = code;
    }

    public Country() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
