package com.talshavit.mylibrary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CapitalsApiService {
    @GET("/{country}")
    Call<CapitalResponse> getCapital(@Path("country") String country);

    @POST("/add_multiple")
    Call<AddCapitalsResponse> addMultipleCapitals(@Body AddCapitalsRequest capitalsRequest);
}
