package com.example.georgi.movieapp.services;

import com.example.georgi.movieapp.models.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieService  {

    List<Movie> getAllMovies() throws IOException;

    Movie getDetailsById(int id) throws IOException;

    List<Movie> getFilteredMovies(String pattern) throws IOException;

    Movie addMovie(Movie movie) throws IOException;

    Movie deleteMovie(int id) throws IOException;

    Movie update(Movie movie, int id) throws IOException;
}
