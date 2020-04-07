package com.module.webService.api;

import com.module.webService.client.OkHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Weather {

    public static String getWeatherOfCity(String city) throws IOException {

        String url = "https://community-open-weather-map." +
                "p.rapidapi.com/find?cnt=1&type=link%252C%20accurate&units=imperial%252C%20metric&q=" + city;

        ResponseEntity<String> responseEntity = OkHttp.fetch(url);

        if (responseEntity.getStatusCodeValue() == 200)
            return responseEntity.getBody();
        else
            return "";
    }
}
