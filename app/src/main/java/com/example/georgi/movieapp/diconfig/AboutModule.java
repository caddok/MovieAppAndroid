package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.about.AboutTheAppFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AboutModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract AboutTheAppFragment aboutTheAppFragment();

    //TODO:Add presenter for the activity
    /*@ActivityScoped
    @Binds
    abstract AboutTheAppFragment aboutTheAppFragment();*/
}
