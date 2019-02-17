package com.iessaladillo.alejandro.retrofityandex.di;

import com.iessaladillo.alejandro.retrofityandex.data.Repository;
import com.iessaladillo.alejandro.retrofityandex.data.RepositoryImpl;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;
import com.iessaladillo.alejandro.retrofityandex.ui.MainFragmentViewModelFactory;

public class Injector {

    private Injector(){}

    public static MainFragmentViewModelFactory provideMainFragmentViewModelFactory() {
        return new MainFragmentViewModelFactory(getRepository());
    }

    private static Repository getRepository() {
        return RepositoryImpl.getInstance(getYandexApi());
    }

    private static YandexApiImpl getYandexApi() {
        return YandexApiImpl.getInstance();
    }
}
