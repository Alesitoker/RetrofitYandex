package com.iessaladillo.alejandro.retrofityandex.data;


import com.iessaladillo.alejandro.retrofityandex.base.Resource;
import com.iessaladillo.alejandro.retrofityandex.data.entity.TranslateText;

import androidx.lifecycle.LiveData;

public class RepositoryImpl implements Repository {


    @Override
    public LiveData<Resource<TranslateText>> translate(String text, String tag) {
        return null;
    }

    @Override
    public void cancel(String tag) {

    }
}
