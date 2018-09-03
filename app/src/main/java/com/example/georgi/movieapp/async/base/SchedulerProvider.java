package com.example.georgi.movieapp.async.base;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler background();
    Scheduler ui();
}
