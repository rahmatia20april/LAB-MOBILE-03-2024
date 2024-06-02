package com.example.tugas6.Service;

import com.example.tugas6.Model.User;
import com.example.tugas6.Response.UserDetailResponse;
import com.example.tugas6.Response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page);

    @GET("api/users/{id}")
    Call<UserDetailResponse> getDetailUser(@Path("id") int id);
}
