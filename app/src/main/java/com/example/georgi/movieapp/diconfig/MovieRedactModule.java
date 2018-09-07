package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.redact.MovieRedactContracts;
import com.example.georgi.movieapp.views.views.redact.MovieRedactFragment;
import com.example.georgi.movieapp.views.views.redact.MovieRedactPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieRedactModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieRedactFragment moviesRedactFragment();

    @ActivityScoped
    @Binds
    abstract MovieRedactContracts.Presenter
    redactPresenter(MovieRedactPresenter presenter);
}
