package com.example.labs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://6287218e7864d2883e7efbd1.mockapi.io/";
    private static RetrofitClient instance;
    private final Retrofit retrofit;
    private final TraineeApiService apiService;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(TraineeApiService.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public TraineeApiService getApiService() {
        return apiService;
    }
}