package com.brandapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.brandapp.di.Injection;

public class ProductListingViewModel extends AndroidViewModel {
    private final Injection mInjection;
    public MutableLiveData<String> mProduct = new MutableLiveData<>();
    public MutableLiveData<String> mImageUrl = new MutableLiveData<>();
    private Context mContext;
    private LifecycleOwner mLifecycleOwner;

    public ProductListingViewModel(@NonNull Application application, Injection injection) {
        super(application);
        mInjection = injection;
        mProduct.setValue("Product 1");
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            // Load image.
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner, Context context) {
        mContext = context;
        mLifecycleOwner = lifecycleOwner;
    }
}
