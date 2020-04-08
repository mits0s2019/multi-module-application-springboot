package com.module.webService.api;

import com.module.webService.client.OkHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CoronaApi {


    public  String getResults() throws IOException {

        String url ="https://covid-19-data.p.rapidapi.com/totals?format=Json";

        ResponseEntity<String> responseEntity = OkHttp.fetch(url);

        if (responseEntity.getStatusCodeValue() == 200)
            return responseEntity.getBody();
        else
            return "";
    }
}
