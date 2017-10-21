package com.inducesmile.androidmultiquiz;



public class Api {
    private static final String ROOT_URL = "http://10.132.80.99/test/v1/Api.php?apicall=";

    public static final String URL_CREATE_HERO = ROOT_URL + "createuser";
    public static final String URL_READ_HEROES = ROOT_URL + "getusers";
    public static final String URL_UPDATE_HERO = ROOT_URL + "updateuser";
    public static final String URL_DELETE_HERO = ROOT_URL + "deleteuser&id=";
}
