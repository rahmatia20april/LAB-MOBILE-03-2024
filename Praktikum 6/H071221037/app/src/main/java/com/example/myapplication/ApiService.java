package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page);
    @GET("api/users/{id}")
    Call<SingleUserResponse> getUsersById(@Path("id") int userId);
}
