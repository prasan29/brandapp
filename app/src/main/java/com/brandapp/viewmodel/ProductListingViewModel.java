package com.brandapp.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;

import com.brandapp.di.Injection;

public class ProductListingViewModel extends AndroidViewModel {
    private final Injection mInjection;
    private Context mContext;
    private LifecycleOwner mLifecycleOwner;

    public ProductListingViewModel(@NonNull Application application, Injection injection) {
        super(application);
        mInjection = injection;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner, Context context) {
        mContext = context;
        mLifecycleOwner = lifecycleOwner;
    }
}
