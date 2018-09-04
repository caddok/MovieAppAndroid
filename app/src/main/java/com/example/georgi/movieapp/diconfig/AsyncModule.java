package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.async.AsyncSchedulerProvider;
import com.example.georgi.movieapp.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {

    @Provides
    @Singleton
    public SchedulerProvider getScheduler(){
        return AsyncSchedulerProvider.getSchedulerProvider();
    }
}
