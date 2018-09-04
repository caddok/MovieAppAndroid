package com.example.georgi.movieapp.http;

import com.example.georgi.movieapp.http.base.HttpRequester;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MovieHttpRequester implements HttpRequester {

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        String body = null;
        response = client.newCall(request).execute();
            body = response.body().string();

        return body;
    }

    @Override
    public String post(String url, String bodyString) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString
        );

        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }

    @Override
    public String delete(String url, int id) throws IOException {
        Request request = new Request.Builder()
                .delete()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();

        return responseBody;
    }

    @Override
    public String update(String url, String body, int id) throws IOException {
        RequestBody bodyString = RequestBody.create(
                MediaType.parse("application/json"),
                body
        );

        Request request = new Request.Builder()
                .put(bodyString)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }
}
