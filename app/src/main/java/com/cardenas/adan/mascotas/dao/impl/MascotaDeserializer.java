package com.cardenas.adan.mascotas.dao.impl;

import com.cardenas.adan.mascotas.constants.JSONTags;
import com.cardenas.adan.mascotas.model.Mascota;
import com.cardenas.adan.mascotas.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by adan0adn on 25/06/17.
 */

public class MascotaDeserializer implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json,MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JSONTags.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotasResponse(deserializerMascotaFromJson(mascotaResponseData));
        return  mascotaResponse;

    }

    private ArrayList<Mascota> deserializerMascotaFromJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            Mascota mascotaTemp = new Mascota();

            JsonObject mascotaResponseDataObject =mascotaResponseData.get(i).getAsJsonObject();
            JsonObject mascotaProfileImageJson = mascotaResponseDataObject.getAsJsonObject(JSONTags.USER_TAG);
            String mascotaUserProfile = mascotaProfileImageJson.get(JSONTags.USER_IMAGE).getAsString();
            JsonObject mascotaMedia = mascotaResponseDataObject.getAsJsonObject(JSONTags.IMAGE_TAG);
            JsonObject mascotaLowResMedia = mascotaMedia.getAsJsonObject(JSONTags.IMAGE_LOWRES_TAG);
            String mediaUrl = mascotaLowResMedia.get(JSONTags.IMAGE_URL).getAsString();

            mascotaTemp.setName(mediaUrl);
            mascotas.add(mascotaTemp);
        }
        return mascotas;
    }
}
