package com.robined.dashlanehomeproject.ui.fork.list;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.base.BaseAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import java.util.concurrent.TimeUnit;


public class ForkListActivity extends BaseAppCompatActivity {

    private ForkListFragment mForkListFragment;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fork_list_activity);

        mCompositeDisposable = new CompositeDisposable();

        FragmentManager fragmentManager = getFragmentManager();
        mForkListFragment = (ForkListFragment) fragmentManager
                .findFragmentByTag(ForkListFragment.FORK_LIST_FRAGMENT_TAG);
        if(mForkListFragment == null) {
            mForkListFragment = new ForkListFragment();
            replaceFragment(R.id.fork_list_fragment_placeholder,
                    mForkListFragment,
                    ForkListFragment.FORK_LIST_FRAGMENT_TAG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        RxSearchView.queryTextChanges(searchView)
                .skipWhile(charSequence -> charSequence.length() == 0)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<CharSequence>() {
                    @Override
                    public void onNext(@NonNull CharSequence s) {
                        mForkListFragment.searchQuery(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {}
                });
        return true;
    }

    @Override
    protected void onDestroy() {
        mCompositeDisposable.dispose();
        super.onDestroy();
    }
}
