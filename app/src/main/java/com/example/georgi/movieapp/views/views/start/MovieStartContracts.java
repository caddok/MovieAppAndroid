package com.example.georgi.movieapp.views.views.start;

public interface MovieStartContracts {

    interface View{
        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();
    }

    interface Presenter{
        void subscribeToView(View view);
    }

}
