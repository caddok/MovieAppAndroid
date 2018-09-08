package com.example.georgi.movieapp.views.views.movielist;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends ArrayAdapter<Movie> {


    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.tv_year)
    TextView mYearTextView;

    @BindView(R.id.image)
    ImageView mImageViewCamera;

    @BindView(R.id.tv_rating)
    TextView mRatingTextView;

    @BindView(R.id.iv_star)
    ImageView mImageViewStar;

    @Inject
    public MovieListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.movie_items, parent, false);
        }
        ButterKnife.bind(this, view);


        Movie movie = getItem(position);
        mNameTextView.setText(movie.getName());
        mNameTextView.setTextColor(Color.WHITE);
        String movieYear = "" + movie.getYear();
        mYearTextView.setText(movieYear);
        mYearTextView.setTextColor(Color.WHITE);
        String rating = String.valueOf(movie.getRating());
        rating = rating.substring(0, 3);
        mRatingTextView.setText(rating);
        mRatingTextView.setTextColor(Color.BLACK);

        return view;

    }
}
