package com.iessaladillo.alejandro.retrofityandex.ui;

import com.iessaladillo.alejandro.retrofityandex.data.Repository;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final Repository repository;

    public MainFragmentViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainFragmentViewModel(repository);
    }
}
