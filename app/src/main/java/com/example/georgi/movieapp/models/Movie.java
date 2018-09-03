package com.example.georgi.movieapp.models;

public class Movie {

    private int id;
    private String name;
    private int year;
    private double rating;
    private int duration;
    private String imgUrl;
    private String movieDescription;


    public Movie(){
        //default
    }

    public Movie(int id, String name, int year, double rating, int duration, String imgUrl, String movieDescription){
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
        this.imgUrl = imgUrl;
        this.movieDescription = movieDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
