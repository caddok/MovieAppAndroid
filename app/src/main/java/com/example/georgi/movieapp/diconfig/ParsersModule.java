package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.parsers.GsonJsonParser;
import com.example.georgi.movieapp.parsers.base.JsonParser;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {

    @Provides
    public JsonParser<Movie> movieJsonParser() {
        return new GsonJsonParser<Movie>(Movie.class,Movie[].class);
    }
}
