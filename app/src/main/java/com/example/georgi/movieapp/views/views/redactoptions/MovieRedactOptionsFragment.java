package com.example.georgi.movieapp.views.views.redactoptions;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieRedactOptionsFragment extends Fragment implements MovieRedactOptionsContracts.View {
    @BindView(R.id.tv_redact)
    TextView mRedactTextView;

    @BindView(R.id.btn_redact)
    Button mRedactButton;

    @BindView(R.id.tv_or)
    TextView mOrTextView;

    @BindView(R.id.tv_delete)
    TextView mDeleteTextView;

    @BindView(R.id.btn_delete)
    Button mDeleteButton;

    @BindView(R.id.pb_loading)
    ProgressBar mLoadingProgressBar;


    private MovieRedactOptionsContracts.Presenter presenter;
    private static final String SHOW_ERROR = "Error: ";
    public static final String INTENT_TO_REDACT = "redact";
    private static final String INTENT_TO_DELETE = "delete";

    @Inject
    public MovieRedactOptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_redact_options, container, false);
        ButterKnife.bind(this,view);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe(this);
    }

    @Override
    public void setPresenter(MovieRedactOptionsContracts.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showLoading() {
        mLoadingProgressBar.setVisibility(View.VISIBLE);
        mRedactTextView.setVisibility(View.GONE);
        mOrTextView.setVisibility(View.GONE);
        mDeleteTextView.setVisibility(View.GONE);
        mDeleteButton.setVisibility(View.GONE);
        mRedactButton.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mLoadingProgressBar.setVisibility(View.GONE);
        mRedactTextView.setVisibility(View.VISIBLE);
        mOrTextView.setVisibility(View.VISIBLE);
        mDeleteTextView.setVisibility(View.VISIBLE);
        mDeleteButton.setVisibility(View.VISIBLE);
        mRedactButton.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.btn_redact,
            R.id.btn_delete})
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_redact:
                intent = new Intent(getContext(), MoviesList.class);
                intent.putExtra("Purpose",INTENT_TO_REDACT);
                startActivity(intent);
                break;
            case R.id.btn_delete:
                intent = new Intent(getContext(), MoviesList.class);
                intent.putExtra("Purpose",INTENT_TO_DELETE);
                startActivity(intent);
                break;

        }
    }

}
