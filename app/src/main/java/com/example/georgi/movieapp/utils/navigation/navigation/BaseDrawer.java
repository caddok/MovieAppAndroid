package com.example.georgi.movieapp.utils.navigation.navigation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.views.views.about.AboutTheApp;
import com.example.georgi.movieapp.views.views.create.CreateMovieActivity;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawer extends DaggerAppCompatActivity {

    private Drawer mDrawer;

    public void setupDrawer() {

        SecondaryDrawerItem aboutTheAppItem = new SecondaryDrawerItem()
                .withIdentifier(AboutTheApp.IDENTIFIER)
                .withName("About");

        SecondaryDrawerItem listMoviesItem = new SecondaryDrawerItem()
                .withIdentifier(MoviesList.IDENTIFIER)
                .withName("List of Movies");

        SecondaryDrawerItem createMovie = new SecondaryDrawerItem()
                .withIdentifier(CreateMovieActivity.IDENTIFIER)
                .withName("Add your movie");

        //TODO:Future plans for accounts
        /*AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(getResources().getDrawable(R.drawable.header2,null))
                .addProfiles(new ProfileDrawerItem()
                        .withName("Georgi Delchev")
                        .withEmail("g.delchev93@gmail.com")
                        .withIcon(getResources().getDrawable(R.drawable.profile2,null)))
                .withOnAccountHeaderListener((view, profile, current) -> false)
                .build();*/
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getToolbar())
                //.withSliderBackgroundColor(Color.BLACK)
                .addDrawerItems(
                        listMoviesItem,
                        createMovie,
                        aboutTheAppItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
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
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier){
        if(identifier == AboutTheApp.IDENTIFIER) {
            return new Intent(BaseDrawer.this, AboutTheApp.class);
        }else if(identifier == MoviesList.IDENTIFIER){
            return new Intent(BaseDrawer.this, MoviesList.class);
        }else if(identifier == CreateMovieActivity.IDENTIFIER){
            return new Intent(BaseDrawer.this, CreateMovieActivity.class);
        }
        return null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getToolbar();

}
