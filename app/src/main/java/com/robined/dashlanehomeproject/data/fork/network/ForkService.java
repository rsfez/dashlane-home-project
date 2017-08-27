package com.robined.dashlanehomeproject.data.fork.network;


import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ForkService {
    @GET("/repos/{repo}/{repo}/forks")
    Observable<List<Fork>> getForkList(@Path("repo") String repo);
}
