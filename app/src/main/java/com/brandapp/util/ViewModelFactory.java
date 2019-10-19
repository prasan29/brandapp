package com.brandapp.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.brandapp.di.Injection;
import com.brandapp.model.FetchDataTask;
import com.brandapp.viewmodel.MainViewModel;
import com.brandapp.viewmodel.ProductListingViewModel;

/**
 * Factory class that provides SingleTon instance of the ViewModel.
 */
public final class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory mInstance;

    private final Application mApplication;
    private final Injection mInjection;

    private ViewModelFactory(Application application,
                             Injection instance) {
        mApplication = application;
        mInjection = instance;
    }

    static ViewModelFactory getInstance(Application application) {

        if (mInstance == null) {
            synchronized (ViewModelFactory.class) {
                if (mInstance == null) {
                    mInstance = new ViewModelFactory(application,
                            Injection.getInstance(new FetchDataTask()));
                }
            }
        }
        return mInstance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(mApplication, mInjection);
        } else if (modelClass.isAssignableFrom(ProductListingViewModel.class)) {
            //noinspection unchecked
            return (T) new ProductListingViewModel(mApplication, mInjection);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }
    }
}
