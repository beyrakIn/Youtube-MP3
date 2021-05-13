package com.example.ytmusic.ui.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ytmusic.api.concretes.VideoManager;
import com.example.ytmusic.models.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<BaseResponse> baseResponse;
    private String query;

    public MutableLiveData<BaseResponse> getBaseResponse() {
        if (baseResponse == null) {
            baseResponse = new MutableLiveData<>();
        }

        new VideoManager().searchVideo(query).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()){
                    baseResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });

        return baseResponse;
    }

    public void setBaseResponse(MutableLiveData<BaseResponse> baseResponse) {
        this.baseResponse = baseResponse;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}