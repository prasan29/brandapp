package com.brandapp.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    public MutableLiveData<String> mImageUrl = new MutableLiveData<>();

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            // Load image.
        }
    }
}
