package com.example.georgi.movieapp.diconfig;

import android.app.Application;

import com.example.georgi.movieapp.MovieApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ValidatorModule.class,
        AdapterModule.class,
        AsyncModule.class,
        ServiceModule.class,
        HttpModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        ParsersModule.class,
        RepositoriesModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MovieApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
