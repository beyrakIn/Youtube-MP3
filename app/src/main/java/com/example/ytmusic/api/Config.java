package com.example.ytmusic.api;

import com.example.ytmusic.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.YT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
