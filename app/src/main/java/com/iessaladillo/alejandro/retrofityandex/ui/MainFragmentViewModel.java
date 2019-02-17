package com.iessaladillo.alejandro.retrofityandex.ui;

import com.iessaladillo.alejandro.retrofityandex.base.Event;
import com.iessaladillo.alejandro.retrofityandex.base.Resource;
import com.iessaladillo.alejandro.retrofityandex.data.Repository;
import com.iessaladillo.alejandro.retrofityandex.data.entity.TranslateText;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MainFragmentViewModel extends ViewModel {

    private static final String TRANSLATE_TAG = MainFragmentViewModel.class.getSimpleName();

    private final MutableLiveData<String> translateTrigger = new MutableLiveData<>();
    private final LiveData<Resource<TranslateText>> translateText;
    private final MediatorLiveData<Event<String>> message = new MediatorLiveData<>();
    private final MediatorLiveData<String> translatedText = new MediatorLiveData<>();
    private Repository repository;

    public MainFragmentViewModel(Repository repository) {
        this.repository = repository;

        translateText = Transformations.switchMap(translateTrigger, translate -> {
            repository.cancel(TRANSLATE_TAG);
            return repository.translate(translateTrigger.getValue(), TRANSLATE_TAG);
        });

        message.addSource(translateText, resource -> {
            if (resource.hasError()) {
                message.setValue(new Event<>(resource.getException().getMessage()));
            }
        });

        translatedText.addSource(translateText, resource -> {
            if (resource.hasSuccess()) {
                translatedText.setValue(resource.getData().getText().get(0));
            }
        });

    }

    public void translate(String text) {
        translateTrigger.setValue(text);
    }

    public MediatorLiveData<Event<String>> getMessage() {
        return message;
    }

    public MediatorLiveData<String> getTranslatedText() {
        return translatedText;
    }
}
