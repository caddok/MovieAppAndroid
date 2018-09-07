package com.example.georgi.movieapp.diconfig;


import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.validation.ValidationBase;
import com.example.georgi.movieapp.validation.ValidatorMovie;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorModule {

    @Provides
    @Singleton
    public ValidationBase<Movie> movieValidator(){
        return new ValidatorMovie();
    }
}
