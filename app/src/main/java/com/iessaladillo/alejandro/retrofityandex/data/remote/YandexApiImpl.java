package com.iessaladillo.alejandro.retrofityandex.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YandexApiImpl {

    private static YandexApiImpl instance;
    private final YandexApi YANDEXAPI;

    private YandexApiImpl(YandexApi yandexApi) {
        YANDEXAPI = yandexApi;
    }

    public static YandexApiImpl getInstance() {
        if (instance == null) {
            instance = new YandexApiImpl(buildInstance());
        }
        return instance;
    }

    private static YandexApi buildInstance() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://translate.yandex.net/api/v1.5/tr.json/").
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(YandexApi.class);
    }

    public YandexApi getYANDEXAPI() {
        return YANDEXAPI;
    }
}
