package com.bootcampmck.service;

import com.bootcampmck.model.Addresses;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class ViaCepService {

    public Addresses getAddresses(String cep) throws ClientProtocolException, IOException {

        Addresses addresses = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if(entity != null){
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();
                addresses = gson.fromJson(result, Addresses.class);
            }

        }

        return addresses;
    }
}
