package com.robined.dashlanehomeproject.ui.fork;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.robined.dashlanehomeproject.DashlaneHomeProject;
import com.robined.dashlanehomeproject.R;
import com.robined.dashlanehomeproject.injection.fork.ForkModule;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.views.ForksRecyclerAdapter;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;


public class ForkListFragment extends Fragment implements ForkListView {
    public static final String FORK_LIST_FRAGMENT_TAG = "FORK_LIST_FRAGMENT_TAG";

    @Inject ForkListPresenter mForkListPresenter;
    @Inject Picasso mPicasso;

    private ForksRecyclerAdapter mForksRecyclerAdapter;
    private RecyclerView mForkRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DashlaneHomeProject) getActivity().getApplicationContext())
                .getDashlaneHomeProjectComponent()
                .plus(new ForkModule(this)).inject(this);
        setRetainInstance(true);
        mForksRecyclerAdapter = new ForksRecyclerAdapter(mForkListPresenter, mPicasso);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fork_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setupRecyclerView(view);

        mForkListPresenter.getForkList();
    }

    @Override
    public void refreshData() {
        mForksRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mForkRecyclerView.setAdapter(null);
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
