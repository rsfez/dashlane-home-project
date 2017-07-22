package com.robined.dashlanehomeproject.ui.fork;

import static com.robined.dashlanehomeproject.ui.fork.ForkListFragment.FORK_LIST_FRAGMENT_TAG;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.robined.dashlanehomeproject.R;


public class ForkListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        FragmentManager fragmentManager = getFragmentManager();
        ForkListFragment forkListFragment = (ForkListFragment) fragmentManager
                .findFragmentByTag(FORK_LIST_FRAGMENT_TAG);
        if(forkListFragment == null) {
            forkListFragment = new ForkListFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fork_list_fragment_placeholder, forkListFragment, FORK_LIST_FRAGMENT_TAG)
                    .commit();
        }
    }
}
