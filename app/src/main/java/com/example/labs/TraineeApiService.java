package com.example.labs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TraineeApiService {
    @GET("lab11")
    Call<List<Lab11Trainee>> getAllTrainees();

    @GET("lab11/{id}")
    Call<Lab11Trainee> getTrainee(@Path("id") String id);

    @POST("lab11")
    Call<Lab11Trainee> createTrainee(@Body Lab11Trainee trainee);

    @PUT("lab11/{id}")
    Call<Lab11Trainee> updateTrainee(@Path("id") String id, @Body Lab11Trainee trainee);

    @DELETE("lab11/{id}")
    Call<Void> deleteTrainee(@Path("id") String id);
}