package com.example.georgi.movieapp.http.base;

import java.io.IOException;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

    String delete(String url, int id) throws IOException;

    String update(String url, String body, int id) throws IOException;
}
