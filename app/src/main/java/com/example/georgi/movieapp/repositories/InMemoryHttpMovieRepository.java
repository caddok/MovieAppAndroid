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
        String moviesJson = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(moviesJson);
    }

    @Override
    public Movie add(Movie item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.post(mServerUrl,requestBody);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public Movie getById(int movieId) throws IOException {
        String url = mServerUrl + "/" + movieId;
        String responseBody = mHttpRequester.get(url);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public void deleteById(int id) throws IOException {
        List<Movie> allMovies = getAll();
        allMovies.remove(id);
    }

    @Override
    public void update(int id, Movie item) throws IOException {
        List<Movie> allMovies = getAll();
        allMovies.set(id,item);
    }
}
