package com.robined.dashlanehomeproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.robined.dashlanehomeproject.ForkInteractor.OnForkListFetchedListener;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForkListActivity extends Activity {

    private RecyclerView mForkRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        mForkRecyclerView = findViewById(R.id.fork_recycler_view);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(
                GsonConverterFactory.create()).build();
        ForkService forkService = retrofit.create(ForkService.class);
        ForkInteractor forkInteractor = new ForkInteractorImpl(forkService);
        forkInteractor.getForkList("DefinitelyTyped", new OnForkListFetchedListener() {
            @Override
            public void onForkListFetchedSuccess(List<Fork> forkList) {
                for(Fork fork : forkList) {
                    Log.i("Fork", fork.toString());
                }
            }

            @Override
            public void onForkListFetchedError() {
                Log.i("Fork", "Error");
            }
        });
    }
}
