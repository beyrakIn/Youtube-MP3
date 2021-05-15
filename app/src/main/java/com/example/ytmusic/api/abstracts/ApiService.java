package com.example.ytmusic.api.abstracts;

import com.example.ytmusic.models.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search")
    Call<BaseResponse> searchVideo(
            @Query("part") String part,
            @Query("q") String query,
            @Query("type") String type,
//            @Query("videoDuration") String videoDuration,
            @Query("key") String key,
            @Query("maxResults") int maxResults
    );
}
