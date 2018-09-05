package com.example.georgi.movieapp.services;

import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.repositories.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpMovieService implements MovieService {
    private final Repository<Movie> mMovieRepository;

    public HttpMovieService(Repository<Movie> movieRepository){
        this.mMovieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() throws IOException {
        return this.mMovieRepository.getAll();
    }

    @Override
    public Movie getDetailsById(int id) throws IOException {
        return this.mMovieRepository.getById(id);
    }

    @Override
    public List<Movie> getFilteredMovies(String pattern) throws IOException {
        String patternToLower = pattern.toLowerCase();

        return getAllMovies().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(patternToLower)
                || movie.getGenre().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Movie addMovie(Movie movie) throws IOException {
        this.mMovieRepository.add(movie);

        return movie;
    }

    @Override
    public Movie deleteMovie(int id) throws IOException {
        this.mMovieRepository.deleteById(id);

        return this.mMovieRepository.getById(id);
    }

    @Override
    public Movie update(Movie movie, int id) throws IOException {
        this.mMovieRepository.update(id, movie);

        return movie;
    }
}
