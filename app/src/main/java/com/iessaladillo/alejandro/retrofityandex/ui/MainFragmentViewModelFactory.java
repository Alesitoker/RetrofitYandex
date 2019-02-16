package com.iessaladillo.alejandro.retrofityandex.ui;

import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final YandexApiImpl yandexApiImpl;

    public MainFragmentViewModelFactory(YandexApiImpl yandexApiImpl) {
        this.yandexApiImpl = yandexApiImpl;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainFragmentViewModel(yandexApiImpl);
    }
}
