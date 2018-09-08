package com.example.georgi.movieapp.views.views.redactoptions;


public interface MovieRedactOptionsContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();

        void navigateToNext(String intention);

        void setNavigator(Navigator navigator);

    }

    interface Presenter{

        void subscribe(View view);

        void allowNavigation(String intention);

    }

    interface Navigator{

        void navigateTo(String intention);
    }
}
