package com.atelier.tennisstats.model;

public class Data {
    private int rank;
    private int points;
    private int weight;
    private int height;
    private int age;
    private int[] last;

    public Data(int rank, int points, int weight, int height, int age, int[] last) {
        this.rank = rank;
        this.points = points;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.last = last;
    }

    public Data() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getLast() {
        return last;
    }

    public void setLast(int[] last) {
        this.last = last;
    }
}
