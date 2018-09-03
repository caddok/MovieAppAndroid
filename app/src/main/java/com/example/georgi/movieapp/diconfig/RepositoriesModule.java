package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.utils.navigation.Constants;
import com.example.georgi.movieapp.http.base.HttpRequester;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.parsers.base.JsonParser;
import com.example.georgi.movieapp.repositories.InMemoryHttpMovieRepository;
import com.example.georgi.movieapp.repositories.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    public Repository<Movie> movieRepository(HttpRequester requester, JsonParser parser) {
        String url = Constants.BASE_SERVER_URL + "/movies";
        return new InMemoryHttpMovieRepository(url,requester,parser);
    }
}
