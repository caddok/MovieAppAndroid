package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.http.MovieHttpRequester;
import com.example.georgi.movieapp.http.base.HttpRequester;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new MovieHttpRequester();
    }
}
