package com.brandapp.di;

import com.brandapp.model.FetchDataTask;

/**
 * Class that implements Dependency Injection.
 */
public class Injection {
    private static Injection mInjection;
    private FetchDataTask mFetchDataTask;

    /**
     * Constructor for initializing the task instances.
     *
     * @param fetchDataTask - FetchDataTask instances.
     */
    private Injection(FetchDataTask fetchDataTask) {
        mFetchDataTask = fetchDataTask;
    }

    /**
     * Method to fetch the Injections instance after injecting all the task objects.
     *
     * @param fetchDataTask - FetchDataTask instance.
     * @return - Injection instance.
     */
    public static Injection getInstance(FetchDataTask fetchDataTask) {
        if (mInjection == null) {
            mInjection = new Injection(fetchDataTask);
        }

        return mInjection;
    }

    /**
     * Method to fetch FetchDataTask object.
     *
     * @return - FetchDataTask instance.
     */
    public FetchDataTask getFetchDataTask() {
        return mFetchDataTask;
    }
}
