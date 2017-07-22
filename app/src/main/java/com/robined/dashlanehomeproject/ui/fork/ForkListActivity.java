package com.robined.dashlanehomeproject.ui.fork;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractorImpl;
import com.robined.dashlanehomeproject.data.fork.network.ForkService;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkPresenter;
import com.robined.dashlanehomeproject.ui.fork.views.ForksRecyclerAdapter;
import com.squareup.picasso.Picasso;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForkListActivity extends Activity implements ForkListView {

    ForkPresenter mForkPresenter;
    Picasso mPicasso;
    private ForksRecyclerAdapter mForksRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        RecyclerView forkRecyclerView = findViewById(R.id.fork_recycler_view);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(
                GsonConverterFactory.create()).build();
        ForkService forkService = retrofit.create(ForkService.class);
        ForkInteractor forkInteractor = new ForkInteractorImpl(forkService);

        mPicasso = new Picasso.Builder(this).build();
        mForkPresenter = new ForkPresenterImpl(forkInteractor, this);

        mForksRecyclerAdapter = new ForksRecyclerAdapter(mForkPresenter, mPicasso);
        forkRecyclerView.setAdapter(mForksRecyclerAdapter);
        forkRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mForkPresenter.getForkList();
    }

    @Override
    public void refreshData() {
        mForksRecyclerAdapter.notifyDataSetChanged();
    }
}
