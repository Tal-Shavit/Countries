package com.talshavit.mylibrary;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CapitalsRepository {

    private static final String BASE_URL = "http://10.0.2.2:8088";
    private CapitalsApiService apiService;

    public CapitalsRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(CapitalsApiService.class);
    }

    public void getCapital(String country, Callback<CapitalResponse> callback) {
        Call<CapitalResponse> call = apiService.getCapital(country);
        call.enqueue(callback);
    }
}