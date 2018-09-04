package com.example.georgi.movieapp.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.views.views.movielist.MovieListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {


    @Provides
    public ArrayAdapter<Movie> getAdapter(Context context){
        return new MovieListAdapter(context);
    }
}
