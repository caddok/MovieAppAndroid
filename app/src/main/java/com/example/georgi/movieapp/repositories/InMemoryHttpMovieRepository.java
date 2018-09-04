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
        String mServerUrlGet = mServerUrl + "/get";
        String moviesJson = mHttpRequester.get(mServerUrlGet);
        return mJsonParser.fromJsonArray(moviesJson);
    }

    @Override
    public Movie add(Movie item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String mServerUrlPost = mServerUrl + "/new";
        String responseBody = mHttpRequester.post(mServerUrlPost,requestBody);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public Movie getById(int movieId) throws IOException {
        String url = mServerUrl + "/" + movieId;
        String responseBody = mHttpRequester.get(url);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public Movie deleteById(int id) throws IOException {
        String mServerUrlDelete = mServerUrl + "/remove/" + id;
        String json = mHttpRequester.delete(mServerUrlDelete,id);
        return mJsonParser.fromJson(json);
    }

    @Override
    public void update(int id, Movie item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String mServerUrlPut = mServerUrl + "/update/" + id;
        String responseBody = mHttpRequester.update(mServerUrlPut, requestBody, id);
    }
}
