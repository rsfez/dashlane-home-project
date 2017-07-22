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

        mForkDetailsView.setOwnerName(fork.owner.login);
        mForkDetailsView.displayPictureFromUrl(fork.owner.avatar_url);
        mForkDetailsView.setForkFullName(fork.full_name);
        mForkDetailsView.setCreationDate(mForkDateFormat.getReadableDate(fork.created_at));
        mForkDetailsView.setDescription(fork.description);
    }
}
