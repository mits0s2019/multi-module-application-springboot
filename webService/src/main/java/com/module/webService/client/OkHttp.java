package com.module.webService.client;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class OkHttp {

    public static ResponseEntity<String> fetch(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "1906a2b529mshdda175c220c23f1p1ea9ffjsne37101d1c044")
                .build();

        Response response = client.newCall(request).execute();

        if(response.code()==200)
            return new ResponseEntity<>(response.body().string(), HttpStatus.OK);
        else
            return new ResponseEntity<>(response.body().string(), HttpStatus.BAD_REQUEST);
    }
}
