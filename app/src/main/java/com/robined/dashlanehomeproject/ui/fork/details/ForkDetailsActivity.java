package com.robined.dashlanehomeproject.ui.fork.details;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.robined.dashlanehomeproject.R;

public class ForkDetailsActivity extends Activity {
    public static final String FORK_PARCEL_KEY = "FORK_PARCEL_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_details_activity);
    }
}
