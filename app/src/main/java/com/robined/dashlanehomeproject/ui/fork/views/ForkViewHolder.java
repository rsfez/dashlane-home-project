package com.robined.dashlanehomeproject.ui.fork.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkRowView;
import com.squareup.picasso.Picasso;


public class ForkViewHolder extends RecyclerView.ViewHolder implements ForkRowView {
    private final Picasso mPicasso;

    private final TextView mOwnerNameTextView;
    private final ImageView mOwnerImageView;

    public ForkViewHolder(View itemView, Picasso picasso) {
        super(itemView);
        mPicasso = picasso;
        mOwnerNameTextView = itemView.findViewById(R.id.owner_name_textview);
        mOwnerImageView = itemView.findViewById(R.id.owner_avatar_imageview);
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
