package com.robined.dashlanehomeproject.ui.fork.views;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.ui.fork.ForkDetailsActivity;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkPresenter;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkRowView;
import com.squareup.picasso.Picasso;

public class ForksRecyclerAdapter extends RecyclerView.Adapter<ForksRecyclerAdapter.ForkViewHolder> {
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

    final class ForkViewHolder extends RecyclerView.ViewHolder implements ForkRowView,
            OnClickListener {
        private final Picasso mPicasso;

        private final TextView mOwnerNameTextView;
        private final ImageView mOwnerImageView;

        ForkViewHolder(View itemView, Picasso picasso) {
            super(itemView);
            mPicasso = picasso;
            mOwnerNameTextView = itemView.findViewById(R.id.owner_name_textview);
            mOwnerImageView = itemView.findViewById(R.id.owner_avatar_imageview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ForkDetailsActivity.class);
            view.getContext().startActivity(intent);
        }

        @Override
        public void setOwnerName(String ownerName) {
            mOwnerNameTextView.setText(ownerName);
        }

        @Override
        public void displayPictureFromUrl(String avatarUrl) {
            mPicasso.load(avatarUrl).into(mOwnerImageView);
        }
    }
}
