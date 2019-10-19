package com.brandapp.model;

import androidx.lifecycle.LifecycleOwner;

import com.brandapp.di.Injection;

public class TaskHelper {
    private Injection mInjection;
    private LifecycleOwner mLifecycleOwner;

    public TaskHelper(Injection injection,
                      LifecycleOwner lifecycleOwner) {
        mInjection = injection;
        mLifecycleOwner = lifecycleOwner;
    }

    public void helpFetchData(
            final ObserveData<String> observeData) {
        FetchDataTask fetchDataTask = mInjection.getFetchDataTask();
        fetchDataTask.setRequestValue(new FetchDataTask.RequestValues("Hello"));
        fetchDataTask.setCallback(
                new TaskExecutor.UseCaseCallback<FetchDataTask.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchDataTask.ResponseValue response) {
                        response.getResult().observe(mLifecycleOwner, observeData);
                    }

                    @Override
                    public void onError() {
                        // On Error.
                    }
                });

        fetchDataTask.run();
    }

    public void helpFetchIntData(ObserveData<Integer> observeData) {
        FetchDataTask fetchDataTask = mInjection.getFetchDataTask();
        fetchDataTask.setRequestValue(new FetchDataTask.RequestValues("1"));
        fetchDataTask.setCallback(
                new TaskExecutor.UseCaseCallback<FetchDataTask.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchDataTask.ResponseValue response) {
                        response.getIntResult().observe(mLifecycleOwner, observeData);
                    }

                    @Override
                    public void onError() {
                        // On Error.
                    }
                });

        fetchDataTask.run();
    }
}
