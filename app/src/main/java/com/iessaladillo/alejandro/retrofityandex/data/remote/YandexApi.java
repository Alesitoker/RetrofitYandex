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
    @GET("translate?lang=es-en&key=trnsl.1.1.20190215T125747Z.6991ebda66ad433c.2f491a5083d1913016f2d4bf2c766ed3a6ab8466")
    Call<YandexTranslateResponse> translateText(@Query("text") String text);
}
