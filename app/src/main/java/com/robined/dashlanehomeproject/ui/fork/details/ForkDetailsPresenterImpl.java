package com.robined.dashlanehomeproject.ui.fork.details;

import android.os.Parcelable;
import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsPresenter;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsView;
import com.robined.dashlanehomeproject.utils.date.BaseDateFormat;
import com.robined.dashlanehomeproject.utils.date.ForkDateFormat;
import javax.inject.Inject;
import org.parceler.Parcels;


public class ForkDetailsPresenterImpl implements ForkDetailsPresenter {
    private final BaseDateFormat mForkDateFormat;
    private final ForkDetailsView mForkDetailsView;

    @Inject ForkDetailsPresenterImpl(ForkDateFormat forkDateFormat,
                                     ForkDetailsView forkDetailsView) {
        mForkDateFormat = forkDateFormat;
        mForkDetailsView = forkDetailsView;
    }

    @Override
    public void displayForkParcelable(Parcelable forkParcelable) {
        Fork fork = Parcels.unwrap(forkParcelable);

        mForkDetailsView.setOwnerName(fork.mOwner.mLogin);
        mForkDetailsView.displayPictureFromUrl(fork.mOwner.mAvatarUrl);
        mForkDetailsView.setForkFullName(fork.mFullName);
        mForkDetailsView.setCreationDate(mForkDateFormat.getReadableDate(fork.mCreatedAt));
        mForkDetailsView.setDescription(fork.mDescription);
    }
}
