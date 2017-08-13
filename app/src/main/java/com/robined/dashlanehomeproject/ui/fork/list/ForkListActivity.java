package com.robined.dashlanehomeproject.ui.fork.list;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.base.BaseAppCompatActivity;


public class ForkListActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        FragmentManager fragmentManager = getFragmentManager();
        ForkListFragment forkListFragment = (ForkListFragment) fragmentManager
                .findFragmentByTag(ForkListFragment.FORK_LIST_FRAGMENT_TAG);
        if(forkListFragment == null) {
            replaceFragment(R.id.fork_list_fragment_placeholder,
                    new ForkListFragment(),
                    ForkListFragment.FORK_LIST_FRAGMENT_TAG);
        }
    }
}
