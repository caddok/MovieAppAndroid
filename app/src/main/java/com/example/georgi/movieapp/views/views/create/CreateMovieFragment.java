package com.example.georgi.movieapp.views.views.create;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateMovieFragment extends Fragment implements MovieCreateContracts.View{

    @BindView(R.id.loading)
    ProgressBar mProgressBar;

    @BindView(R.id.iv_oscar)
    ImageView mImageViewBackground;

    @BindView(R.id.tv_enter_name)
    TextView mTextViewEnterName;

    @BindView(R.id.tv_enter_genre)
    TextView mTextViewEnterGenre;

    @BindView(R.id.tv_enter_year)
    TextView mTextViewEnterYear;

    @BindView(R.id.tv_enter_description)
    TextView mTextViewEnterDescription;

    @BindView(R.id.tv_enter_duration)
    TextView mTextViewEnterDuration;

    @BindView(R.id.tv_image_url)
    TextView mTextViewEnterURL;

    @BindView(R.id.et_name)
    EditText mEditTextName;

    @BindView(R.id.et_genre)
    EditText mEditTextGenre;

    @BindView(R.id.et_description)
    EditText mEditTextDescription;

    @BindView(R.id.et_imageUrl)
    EditText mEditTextURL;

    @BindView(R.id.spinner_year)
    Spinner mSpinnerYear;

    @BindView(R.id.spinner_duration)
    Spinner mSpinnerDuration;

    @BindView(R.id.btn_create)
    Button mButtonCreate;

    private MovieCreateContracts.Presenter mPresenter;
    private MovieCreateContracts.Navigator mNavigator;

    @Inject
    public CreateMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create_movie, container, false);

        ButterKnife.bind(this, root);

        mTextViewEnterName.setText("Movie name: ");
        mTextViewEnterName.setTextColor(Color.WHITE);
        mTextViewEnterGenre.setText("Movie genre: ");
        mTextViewEnterGenre.setTextColor(Color.WHITE);
        mTextViewEnterDuration.setText("Duration (minutes): ");
        mTextViewEnterDuration.setTextColor(Color.WHITE);
        mTextViewEnterURL.setText("Image URL: ");
        mTextViewEnterURL.setTextColor(Color.WHITE);
        mTextViewEnterYear.setText("Premiere year: ");
        mTextViewEnterYear.setTextColor(Color.WHITE);
        mTextViewEnterDescription.setText("Movie description: ");
        mTextViewEnterDescription.setTextColor(Color.WHITE);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribeToView(this);
    }

    @Override
    public void setPresenter(MovieCreateContracts.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);

        mTextViewEnterName.setVisibility(View.GONE);
        mTextViewEnterGenre.setVisibility(View.GONE);
        mTextViewEnterYear.setVisibility(View.GONE);
        mTextViewEnterDescription.setVisibility(View.GONE);
        mTextViewEnterDuration.setVisibility(View.GONE);
        mTextViewEnterURL.setVisibility(View.GONE);

        mEditTextName.setVisibility(View.GONE);
        mEditTextGenre.setVisibility(View.GONE);
        mEditTextDescription.setVisibility(View.GONE);
        mEditTextURL.setVisibility(View.GONE);

        mButtonCreate.setVisibility(View.GONE);
        mSpinnerYear.setVisibility(View.GONE);
        mSpinnerDuration.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);

        mTextViewEnterName.setVisibility(View.VISIBLE);
        mTextViewEnterGenre.setVisibility(View.VISIBLE);
        mTextViewEnterYear.setVisibility(View.VISIBLE);
        mTextViewEnterDescription.setVisibility(View.VISIBLE);
        mTextViewEnterDuration.setVisibility(View.VISIBLE);
        mTextViewEnterURL.setVisibility(View.VISIBLE);

        mEditTextName.setVisibility(View.VISIBLE);
        mEditTextGenre.setVisibility(View.VISIBLE);
        mEditTextDescription.setVisibility(View.VISIBLE);
        mEditTextURL.setVisibility(View.VISIBLE);

        mButtonCreate.setVisibility(View.VISIBLE);
        mSpinnerYear.setVisibility(View.VISIBLE);
        mSpinnerDuration.setVisibility(View.VISIBLE);
    }


    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void navigateToListActivity() {
        showCreate();
        mNavigator.navigateToListActivity();
    }

    @Override
    public void openDialog(Movie movie) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(
                getContext());

        dialog.setTitle("Confirm Create");

        dialog.setMessage("Are you sure you want to create this movie?");

        dialog.setIcon(R.drawable.star_icon2);

        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        mPresenter.createMovie(movie);
                    }
                });

        dialog.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),
                                "Movie creation canceled!", Toast.LENGTH_SHORT)
                                .show();
                        dialog.cancel();
                    }
                });

        dialog.show();
    }

    @Override
    public void showCreate() {
        Toast.makeText(getContext(),
                "Movie added to database!", Toast.LENGTH_SHORT)
                .show();
    }

    @OnClick(R.id.btn_create)
    public void onClick(View view){
        String name = mEditTextName.getText().toString();
        String genre = mEditTextGenre.getText().toString();
        int year = Integer.parseInt((String) mSpinnerYear.getSelectedItem());
        int duration = Integer.parseInt((String)mSpinnerDuration.getSelectedItem());
        String imgUrl = mEditTextURL.getText().toString();
        String movieDescription = mEditTextDescription.getText().toString();

        Movie createdMovie = new Movie(1,0,0, name, genre, year, duration, imgUrl, movieDescription);

        openDialog(createdMovie);
    }

    public void setNavigator(MovieCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}
