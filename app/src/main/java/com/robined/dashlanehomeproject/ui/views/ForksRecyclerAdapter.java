package com.robined.dashlanehomeproject.ui.views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.robined.dashlanehomeproject.ForkPresenter;
import com.robined.dashlanehomeproject.R;

public class ForksRecyclerAdapter extends RecyclerView.Adapter<ForkViewHolder> {
    private final ForkPresenter mForkPresenter;

    public ForksRecyclerAdapter(ForkPresenter forkPresenter) {
        mForkPresenter = forkPresenter;
    }

    @Override
    public ForkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fork_cell, parent, false);
        return new ForkViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(ForkViewHolder holder, int position) {
        mForkPresenter.onBindForkViewHolderAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return mForkPresenter.getForkCount();
    }
}
