package com.robined.dashlanehomeproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.robined.dashlanehomeproject.ui.views.ForkListView;
import com.robined.dashlanehomeproject.ui.views.ForksRecyclerAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForkListActivity extends Activity implements ForkListView {

    private RecyclerView mForkRecyclerView;
    ForkPresenter mForkPresenter;
    private ForksRecyclerAdapter mForksRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        mForkRecyclerView = findViewById(R.id.fork_recycler_view);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(
                GsonConverterFactory.create()).build();
        ForkService forkService = retrofit.create(ForkService.class);
        ForkInteractor forkInteractor = new ForkInteractorImpl(forkService);

        mForkPresenter = new ForkPresenterImpl(forkInteractor, this);

        mForksRecyclerAdapter = new ForksRecyclerAdapter(mForkPresenter);
        mForkRecyclerView.setAdapter(mForksRecyclerAdapter);
        mForkRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mForkPresenter.getForkList();
    }

    @Override
    public void refreshData() {
        mForksRecyclerAdapter.notifyDataSetChanged();
    }
}
