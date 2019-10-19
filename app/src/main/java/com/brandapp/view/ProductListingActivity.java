package com.brandapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.brandapp.R;
import com.brandapp.databinding.ActivityProductListingBinding;
import com.brandapp.util.ViewModelBuilder;
import com.brandapp.viewmodel.ProductListingViewModel;

public class ProductListingActivity extends AppCompatActivity {
    private ActivityProductListingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_listing);
        ProductListingViewModel viewModel = ViewModelBuilder
                .generateViewModel(this, ProductListingViewModel.class);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(viewModel);
    }
}
