package com.robined.dashlanehomeproject.data.fork.interactor;


import android.support.annotation.NonNull;
import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.network.ForkService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForkInteractorImpl implements ForkInteractor, Callback<List<Fork>> {
    private final ForkService mForkService;
    private OnForkListFetchedListener mListener;

    public ForkInteractorImpl(ForkService forkService) {
        mForkService = forkService;
    }

    @Override
    public void getForkList(String repo, OnForkListFetchedListener listener) {
        mListener = listener;
        mForkService.getForkList(repo).enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<List<Fork>> call, @NonNull Response<List<Fork>> response) {
        List<Fork> forkList = response.body();
        if(response.isSuccessful() && forkList != null) {
            mListener.onForkListFetchedSuccess(forkList);
        } else {
            mListener.onForkListFetchedError();
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<Fork>> call, @NonNull Throwable t) {
        mListener.onForkListFetchedError();
    }
}
