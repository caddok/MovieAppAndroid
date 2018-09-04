package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.about.AboutTheAppFragment;
import com.example.georgi.movieapp.views.views.start.StartActivityFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartActivityFragment aboutTheAppFragment();

    //TODO:Add presenter for the activity
    /*@ActivityScoped
    @Binds
    abstract Presenter aboutTheAppFragment();*/
}
