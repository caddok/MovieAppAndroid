package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.start.StartActivityFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartActivityFragment aboutTheAppFragment();


//    @ActivityScoped
//    @Binds
//    abstract SuperheroesCreateContracts.Presenter createPresenter(SuperheroesCreatePresenter presenter);
}
