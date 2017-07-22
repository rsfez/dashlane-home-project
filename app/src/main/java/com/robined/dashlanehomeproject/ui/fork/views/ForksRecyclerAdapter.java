package com.robined.dashlanehomeproject.ui.fork.views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkPresenter;
import com.robined.dashlanehomeproject.R;
import com.squareup.picasso.Picasso;

public class ForksRecyclerAdapter extends RecyclerView.Adapter<ForkViewHolder> {
    private final ForkPresenter mForkPresenter;
    private final Picasso mPicasso;

    public ForksRecyclerAdapter(ForkPresenter forkPresenter, Picasso picasso) {
        mForkPresenter = forkPresenter;
        mPicasso = picasso;
    }

    @Override
    public ForkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fork_cell, parent, false);
        return new ForkViewHolder(cellView, mPicasso);
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
