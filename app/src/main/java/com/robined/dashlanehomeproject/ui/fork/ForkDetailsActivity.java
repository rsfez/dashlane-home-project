package com.robined.dashlanehomeproject.ui.fork;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import org.parceler.Parcels;

public class ForkDetailsActivity extends Activity {
    public static final String FORK_PARCEL_KEY = "FORK_PARCEL_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_details_activity);

        Fork fork = Parcels.unwrap(getIntent().getParcelableExtra(FORK_PARCEL_KEY));

        Log.i("TPT", "TT");
    }
}
