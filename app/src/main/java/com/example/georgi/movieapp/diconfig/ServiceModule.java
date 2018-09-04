package com.example.georgi.movieapp.diconfig;


import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.repositories.Repository;
import com.example.georgi.movieapp.services.HttpMovieService;
import com.example.georgi.movieapp.services.MovieService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    public MovieService getService(Repository<Movie> repo){
        return new HttpMovieService(repo);
    }
}
