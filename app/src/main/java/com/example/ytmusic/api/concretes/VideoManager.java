package com.example.ytmusic.api.concretes;

import com.example.ytmusic.Constants;
import com.example.ytmusic.api.Config;
import com.example.ytmusic.api.abstracts.ApiService;
import com.example.ytmusic.models.BaseResponse;

import retrofit2.Call;

public class VideoManager {
    ApiService apiService = Config.retrofit.create(ApiService.class);


    public Call<BaseResponse> searchVideo(String query) {
        String part = "snippet", type = "video";
        int maxResults = 30;
        return apiService.searchVideo(part, query, type, Constants.YT_API_KEY, maxResults);
    }
}
