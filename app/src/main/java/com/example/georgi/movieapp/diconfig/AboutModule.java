package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.about.AboutTheAppContracts;
import com.example.georgi.movieapp.views.views.about.AboutTheAppFragment;
import com.example.georgi.movieapp.views.views.about.AboutTheAppPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AboutModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract AboutTheAppFragment aboutTheAppFragment();

    @ActivityScoped
    @Binds
    abstract AboutTheAppContracts.Presenter createPresenter(AboutTheAppPresenter presenter);
}
