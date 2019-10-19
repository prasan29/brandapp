package com.brandapp.model;

import androidx.lifecycle.Observer;

import com.brandapp.viewmodel.MainViewModel;

public class ObserveData<T> implements Observer<T> {
    private MainViewModel.DataFetchListener mListener;

    public void setListener(MainViewModel.DataFetchListener listener) {
        mListener = listener;
    }

    @Override
    public void onChanged(T t) {
        if (t instanceof String) {
            mListener.onDataReceived();
        }
    }
}
