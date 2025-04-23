package com.example.spotlight.api;

import com.example.spotlight.model.SpectacleDTO;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/spectacles")
    Call<List<SpectacleDTO>> getAllSpectacles();
}