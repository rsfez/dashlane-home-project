package com.robined.dashlanehomeproject.ui.fork.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.base.BaseFragment;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListView;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;


public class ForkListFragment extends BaseFragment implements ForkListView, OnRefreshListener {
    public static final String FORK_LIST_FRAGMENT_TAG = "FORK_LIST_FRAGMENT_TAG";

    @Inject ForkListPresenter mForkListPresenter;
    @Inject Picasso mPicasso;

    private ForksRecyclerAdapter mForksRecyclerAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mForkRecyclerView;

    private boolean mGetForkListCalled = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(mForksRecyclerAdapter == null) {
            mForksRecyclerAdapter = new ForksRecyclerAdapter(mForkListPresenter, mPicasso);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fork_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setupRefreshLayout(view);
        setupRecyclerView(view);

        if(!mGetForkListCalled) {
            mForkListPresenter.getForkList();
            mGetForkListCalled = true;
        }
    }

    @Override
    public void onRefresh() {
        mForkListPresenter.getForkList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mForkRecyclerView.setAdapter(null);
    }

    @Override
    public void setLoadingState(boolean isLoading) {
        mSwipeRefreshLayout.setRefreshing(isLoading);
    }

    @Override
    public void onDataReady() {
        mForksRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Activity activity = getActivity();
        Toast.makeText(activity, activity.getText(R.string.could_not_fetch_forks_error),
                Toast.LENGTH_SHORT).show();
    }

    private void setupRefreshLayout(View view) {
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void setupRecyclerView(View view) {
        mForkRecyclerView = view.findViewById(R.id.fork_recycler_view);
        mForkRecyclerView.setAdapter(mForksRecyclerAdapter);
        mForkRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mForkRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mForkRecyclerView.addItemDecoration(itemDecoration);
    }
}
