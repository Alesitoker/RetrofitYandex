package com.iessaladillo.alejandro.retrofityandex.data.remote;

import com.iessaladillo.alejandro.retrofityandex.data.remote.dto.YandexTranslateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface YandexApi {
    @Headers({
            "Content-Length: 17",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("translate")
    Call<YandexTranslateResponse> translateText(@Query("key") String key, @Query("text") String text, @Query("lang") String lang);
}
