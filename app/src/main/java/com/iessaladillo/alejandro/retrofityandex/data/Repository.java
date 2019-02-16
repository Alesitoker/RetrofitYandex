package com.iessaladillo.alejandro.retrofityandex.data;

import com.iessaladillo.alejandro.retrofityandex.base.Resource;
import com.iessaladillo.alejandro.retrofityandex.data.entity.TranslateText;

import androidx.lifecycle.LiveData;

public interface Repository {

    LiveData<Resource<TranslateText>> translate(String text, String tag);

    void cancel(String tag);
}
