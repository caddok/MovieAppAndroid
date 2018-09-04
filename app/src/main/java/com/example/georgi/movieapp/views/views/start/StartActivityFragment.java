package com.example.georgi.movieapp.views.views.start;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;
import com.github.clans.fab.FloatingActionButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StartActivityFragment extends Fragment implements MovieStartContracts.View{


    @BindView(R.id.iv_start_curtains)
    ImageView mImageViewStart;

    @BindView(R.id.btn_start)
    FloatingActionButton mStartButton;


    private MovieStartContracts.Presenter mPresenter;



    @Inject
    public StartActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_start_activity, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribeToView(this);
    }

    @Override
    public void setPresenter(MovieStartContracts.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        mStartButton.setVisibility(View.GONE);
        //TODO
    }

    @Override
    public void hideLoading() {
        mStartButton.setVisibility(View.VISIBLE);
        //TODO
    }

    @Override
    public void navigateToNext() {
        Intent intent = new Intent(getContext(), MoviesList.class);

        startActivity(intent);
    }

    @OnClick(R.id.btn_start)
    public void onClick(){
        mPresenter.allowNavigation();
    }
}
