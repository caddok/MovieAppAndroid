package com.example.georgi.movieapp.views.views.start;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.georgi.movieapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartActivityFragment extends Fragment {


    public StartActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_activity, container, false);
    }

}
