package com.example.georgi.movieapp.utils.navigation.navigation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;
import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsActivity;
import com.example.georgi.movieapp.views.views.about.AboutTheAppActivity;
import com.example.georgi.movieapp.views.views.create.CreateMovieActivity;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawer extends DaggerAppCompatActivity {
    private Drawer mDrawer;

    public void setupDrawer() {
        PrimaryDrawerItem listMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesList.IDENTIFIER)
                .withName("List of Movies")
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.list_icon);

        SecondaryDrawerItem createMovie = new SecondaryDrawerItem()
                .withIdentifier(CreateMovieActivity.IDENTIFIER)
                .withName("Add your movie")
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.star_icon2);

        SecondaryDrawerItem redactMovieItem = new SecondaryDrawerItem()
                .withIdentifier(MovieRedactOptionsActivity.IDENTIFIER)
                .withName("Redact a movie")
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.redact_icon);

        SecondaryDrawerItem aboutTheAppItem = new SecondaryDrawerItem()
                .withIdentifier(AboutTheAppActivity.IDENTIFIER)
                .withName("About")
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.about_icon);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getToolbar())
                .withSliderBackgroundColor(Color.BLACK)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        listMoviesItem,
                        createMovie,
                        redactMovieItem,
                        aboutTheAppItem
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    long identifier = drawerItem.getIdentifier();

                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);
                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == AboutTheAppActivity.IDENTIFIER) {
            return new Intent(BaseDrawer.this, AboutTheAppActivity.class);
        } else if (identifier == MoviesList.IDENTIFIER) {
            return new Intent(BaseDrawer.this, MoviesList.class);
        } else if (identifier == MovieRedactOptionsActivity.IDENTIFIER) {
            return new Intent(BaseDrawer.this, MovieRedactOptionsActivity.class);
        } else if (identifier == CreateMovieActivity.IDENTIFIER) {
            return new Intent(BaseDrawer.this, CreateMovieActivity.class);
        }
        return null;
    }
    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

    protected abstract long getIdentifier ();

    protected abstract Toolbar getToolbar ();
}
