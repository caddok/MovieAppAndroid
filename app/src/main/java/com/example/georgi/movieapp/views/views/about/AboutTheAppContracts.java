package com.example.georgi.movieapp.views.views.about;

public interface AboutTheAppContracts {

    interface View{

        void setView();

        void setPresenter(Presenter presenter);
    }

    interface Presenter{

        void subscribe(View view);

        void allowSetView();
    }
}
