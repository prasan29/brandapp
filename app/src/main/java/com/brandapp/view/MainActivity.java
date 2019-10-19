package com.brandapp.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;

import com.brandapp.R;
import com.brandapp.databinding.ActivityMainBinding;
import com.brandapp.util.ViewModelBuilder;
import com.brandapp.viewmodel.MainViewModel;

public class MainActivity extends FragmentActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelBuilder.generateViewModel(this, MainViewModel.class);
        mBinding.setLifecycleOwner(this);
        mainViewModel.setLifecycleOwner(this, this);
        mainViewModel.setRecyclerView(mBinding.recyclerView);
        mBinding.setViewModel(mainViewModel);

        mainViewModel.loadData();
    }
}
