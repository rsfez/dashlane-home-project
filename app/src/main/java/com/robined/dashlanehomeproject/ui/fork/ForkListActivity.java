package com.robined.dashlanehomeproject.ui.fork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.robined.dashlanehomeproject.DashlaneHomeProject;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.fork.ForkModule;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkPresenter;
import com.robined.dashlanehomeproject.ui.fork.views.ForksRecyclerAdapter;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;


public class ForkListActivity extends AppCompatActivity implements ForkListView {
    @Inject ForkPresenter mForkPresenter;
    @Inject Picasso mPicasso;

    private ForksRecyclerAdapter mForksRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        ((DashlaneHomeProject) getApplicationContext()).getDashlaneHomeProjectComponent()
                .plus(new ForkModule(this)).inject(this);

        mForksRecyclerAdapter = new ForksRecyclerAdapter(mForkPresenter, mPicasso);
        setupRecyclerView();

        mForkPresenter.getForkList();
    }

    private void setupRecyclerView() {
        RecyclerView forkRecyclerView = (RecyclerView) findViewById(R.id.fork_recycler_view);
        forkRecyclerView.setAdapter(mForksRecyclerAdapter);
        forkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        forkRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        forkRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void refreshData() {
        mForksRecyclerAdapter.notifyDataSetChanged();
    }
}
