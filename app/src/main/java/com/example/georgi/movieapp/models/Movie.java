package com.example.georgi.movieapp.models;

import java.io.Serializable;

public class Movie implements Serializable {

    public int id;
    public double voteSum;
    public int votes;
    public String name;
    public String genre;
    public int year;
    public double rating;
    public int duration;
    public String imgUrl;
    public String movieDescription;


    public Movie(){
        //default
    }

    public Movie(int id, double voteSum, int votes, String name, String genre, int year, int duration, String imgUrl, String movieDescription){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.imgUrl = imgUrl;
        this.movieDescription = movieDescription;
    }

    public double getVoteSum() {
        return voteSum;
    }

    public void setVoteSum(double voteSum) {
        this.voteSum = voteSum;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
