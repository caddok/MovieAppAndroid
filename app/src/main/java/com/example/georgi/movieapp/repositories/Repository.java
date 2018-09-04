package com.example.georgi.movieapp.repositories;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

    List<T> getAll() throws IOException;

    T add(T item) throws IOException;

    T getById(int mSuperheroId) throws IOException;

    T deleteById(int id) throws IOException;

    void update(int id, T item) throws IOException;
}
