package com.example.georgi.movieapp.views.views.start;

public interface MovieStartContracts {

    interface View{
        void setPresenter(Presenter presenter);

        void navigateToNext();

        void setNavigator(Navigator navigator);
    }

    interface Presenter{
        void subscribeToView(View view);

        void allowNavigation();
    }

    interface Navigator{

        void navigatoTo();
    }

}
