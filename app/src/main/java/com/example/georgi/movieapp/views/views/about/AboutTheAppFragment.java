package com.example.georgi.movieapp.views.views.about;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.georgi.movieapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutTheAppFragment extends Fragment implements AboutTheAppContracts.View{

    @BindView(R.id.loading)
    ProgressBar mProgressBar;

    @BindView(R.id.iv_about)
    ImageView mImageViewAbout;

    @BindView(R.id.tv_about)
    TextView mTextViewAbout;

    @BindView(R.id.iv_warner_bros)
    ImageView mImageViewWarner;

    private AboutTheAppContracts.Presenter mPresenter;

    @Inject
    public AboutTheAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_about_the_app, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.allowSetView();
    }

    @Override
    public void setView() {
        mTextViewAbout.setText(R.string.aboutApp_info);
        mTextViewAbout.setMovementMethod(new ScrollingMovementMethod());
    }



    @Override
    public void setPresenter(AboutTheAppContracts.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
