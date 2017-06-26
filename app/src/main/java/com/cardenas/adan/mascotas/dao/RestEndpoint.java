package com.cardenas.adan.mascotas.dao;

import com.cardenas.adan.mascotas.constants.RESTConstants;
import com.cardenas.adan.mascotas.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adan0adn on 25/06/17.
 */

public interface RestEndpoint {

    @GET(RESTConstants.URL_USER_MEDIA)
    Call<MascotaResponse> getRecentMedia();
}
