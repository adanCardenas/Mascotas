package com.cardenas.adan.mascotas.constants;

/**
 * Created by adan0adn on 25/06/17.
 */

public class RESTConstants {
    public static final String URL_VERSION="v1/";
    public static final String URL_ROOT="https://api.instagram.com/"+URL_VERSION;
    public static final String URL_TOKEN="104942454.c0f8531.f0ed46a9c9804fe4974acc97abcd488a";
    public static final String URL_ACCESS_TOKEN="?access_token="+URL_TOKEN;
    public static final String URL_USER_MEDIA=URL_ROOT+"users/self/media/recent/"+URL_ACCESS_TOKEN;
}
