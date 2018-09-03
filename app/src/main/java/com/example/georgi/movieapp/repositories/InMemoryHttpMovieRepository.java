package com.example.georgi.movieapp.repositories;

import com.example.georgi.movieapp.http.base.HttpRequester;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.parsers.base.JsonParser;

import java.io.IOException;
import java.util.List;

public class InMemoryHttpMovieRepository implements Repository<Movie> {
    private final HttpRequester mHttpRequester;
    private final JsonParser<Movie> mJsonParser;
    private String mServerUrl;

    public InMemoryHttpMovieRepository(String serverUrl,
                          HttpRequester httpRequester,
                          JsonParser<Movie> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }
    @Override
    public List<Movie> getAll() throws IOException {
        return null;
    }

    @Override
    public Movie add(Movie item) throws IOException {
        return null;
    }

    @Override
    public Movie getById(int mSuperheroId) throws IOException {
        return null;
    }

    @Override
    public void deleteById(int id) throws IOException {

    }

    @Override
    public void update(int id, Movie item) {

    }
}
