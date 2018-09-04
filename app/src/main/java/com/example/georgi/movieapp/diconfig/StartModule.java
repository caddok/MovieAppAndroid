package com.example.georgi.movieapp.diconfig;

<<<<<<< HEAD
import com.example.georgi.movieapp.views.views.start.MovieStartContracts;
=======
import com.example.georgi.movieapp.views.views.movielist.MovieListPresenter;
import com.example.georgi.movieapp.views.views.movielist.MoviesListContracts;
>>>>>>> 42bc10ef6a9eb6ae4c1d21fe49de203ef2ba29f6
import com.example.georgi.movieapp.views.views.start.StartActivityFragment;
import com.example.georgi.movieapp.views.views.start.StartPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartActivityFragment startActivityFragment();


    @ActivityScoped
    @Binds
<<<<<<< HEAD
    abstract MovieStartContracts.Presenter createPresenter(StartPresenter presenter);
=======
    abstract MoviesListContracts.Presenter listPresenter(MovieListPresenter presenter);
>>>>>>> 42bc10ef6a9eb6ae4c1d21fe49de203ef2ba29f6
}
