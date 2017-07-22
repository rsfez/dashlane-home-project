package com.robined.dashlanehomeproject;


import com.robined.dashlanehomeproject.models.Fork;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ForkService {
    @GET("/repos/{repo}/{repo}/forks")
    Call<List<Fork>> getForkList(@Path("repo") String repo);
}
