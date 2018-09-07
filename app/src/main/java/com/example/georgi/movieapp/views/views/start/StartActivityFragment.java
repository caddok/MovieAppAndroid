package com.example.georgi.movieapp.views.views.start;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.georgi.movieapp.R;
import com.github.clans.fab.FloatingActionButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StartActivityFragment extends Fragment implements MovieStartContracts.View{


    @BindView(R.id.iv_start_curtains)
    ImageView mImageViewStart;

    @BindView(R.id.fab)
    FloatingActionButton mStartButton;


    private MovieStartContracts.Presenter mPresenter;
    private MovieStartContracts.Navigator mNavigator;



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
    public void navigateToNext() {
        this.mNavigator.navigateTo();
    }

    @Override
    public void setNavigator(MovieStartContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @OnClick(R.id.fab)
    public void onClick(){
        this.mPresenter.allowNavigation();
    }
}
