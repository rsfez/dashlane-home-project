package com.robined.dashlanehomeproject.ui.fork.list.contracts;


public interface ForkListView {
    void setLoadingState(boolean isLoading);
    void onDataReady();
    void showError();
}
