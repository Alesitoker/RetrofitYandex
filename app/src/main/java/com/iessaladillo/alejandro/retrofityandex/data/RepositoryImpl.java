package com.iessaladillo.alejandro.retrofityandex.data;


import com.iessaladillo.alejandro.retrofityandex.base.Resource;
import com.iessaladillo.alejandro.retrofityandex.data.entity.TranslateText;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApi;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;
import com.iessaladillo.alejandro.retrofityandex.data.remote.dto.YandexTranslateResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryImpl implements Repository {

    private final YandexApiImpl yandexApi;
    private final String KEY = "trnsl.1.1.20190215T125747Z.6991ebda66ad433c.2f491a5083d1913016f2d4bf2c766ed3a6ab8466";
    private final String LANG = "es-en";
    private MutableLiveData<Resource<TranslateText>> liveData = new MutableLiveData<>();
    public static RepositoryImpl instance;

    public static RepositoryImpl getInstance(YandexApiImpl yandexApi) {
        if (instance == null) {
            instance = new RepositoryImpl(yandexApi);
        }
        return instance;
    }

    private RepositoryImpl(YandexApiImpl yandexApi) {
        this.yandexApi = yandexApi;
    }

    @Override
    public LiveData<Resource<TranslateText>> translate(String text, String tag) {
        Call<YandexTranslateResponse> call = yandexApi.getYANDEXAPI().translateText(KEY, text, LANG);
        call.enqueue(new Callback<YandexTranslateResponse>() {
            @Override
            public void onResponse(Call<YandexTranslateResponse> call, Response<YandexTranslateResponse> response) {
                if (response.body() != null && response.isSuccessful()) {
                    liveData.postValue(Resource.success(new TranslateText(response.body().getText())));
                } else {
                    liveData.postValue(Resource.error(new Exception(response.message())));
                }
            }

            @Override
            public void onFailure(Call<YandexTranslateResponse> call, Throwable t) {
                liveData.postValue(Resource.error(new Exception(t)));
            }
        });
        return liveData;
    }

    @Override
    public void cancel(String tag) {

    }
}
