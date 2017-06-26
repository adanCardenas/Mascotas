package com.cardenas.adan.mascotas.dao.impl;

import com.cardenas.adan.mascotas.constants.RESTConstants;
import com.cardenas.adan.mascotas.dao.RestEndpoint;
import com.cardenas.adan.mascotas.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adan0adn on 25/06/17.
 */

public class RestAdapapter {

    public RestEndpoint establishRestInstagramApiCon(Gson gson){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(RESTConstants.URL_USER_MEDIA).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        return retrofit.create(RestEndpoint.class);
    }

    public Gson buildDeserilizerGsonRecentMedia(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializer());
        return gsonBuilder.create();
    }
}
