package com.robined.dashlanehomeproject.ui.fork.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.base.BaseAppCompatActivity;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsPresenter;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsView;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class ForkDetailsActivity extends BaseAppCompatActivity implements ForkDetailsView {
    public static final String FORK_PARCEL_KEY = "FORK_PARCEL_KEY";

    @Inject Picasso mPicasso;
    @Inject ForkDetailsPresenter mDetailsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_details_activity);
        mDetailsPresenter.displayForkParcelable(getIntent().getParcelableExtra(FORK_PARCEL_KEY));
    }

    @Override
    public void setOwnerName(String ownerName) {
        ((TextView) findViewById(R.id.owner_name_textview)).setText(ownerName);
    }

    @Override
    public void displayPictureFromUrl(String avatarUrl) {
        mPicasso.load(avatarUrl).into((ImageView) findViewById(R.id.owner_avatar_imageview));
    }

    @Override
    public void setForkFullName(String forkFullName) {
        ((TextView) findViewById(R.id.full_name_textview)).setText(forkFullName);
    }

    @Override
    public void setCreationDate(String readableCreationDate) {
        ((TextView) findViewById(R.id.created_at_textview)).setText(readableCreationDate);
    }

    @Override
    public void setDescription(String description) {
        ((TextView) findViewById(R.id.description_textview)).setText(description);

    }
}
