package com.brandapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.brandapp.di.Injection;
import com.brandapp.model.ObserveData;
import com.brandapp.model.TaskHelper;
import com.brandapp.view.PictureItemAdapter;

public class MainViewModel extends AndroidViewModel {
    private final Injection mInjection;
    private final ObserveData<String> mObserveData = new ObserveData<>();
    public MutableLiveData<String> mHeaderText = new MutableLiveData<>();
    private LifecycleOwner mLifecycleOwner;
    private RecyclerView mListItems;

    public MainViewModel(@NonNull Application application, Injection injection) {
        super(application);
        mInjection = injection;
        mHeaderText.setValue("Brand Listing screen");
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        mLifecycleOwner = lifecycleOwner;
    }

    public void loadData() {
        TaskHelper helper = new TaskHelper(mInjection, mLifecycleOwner);
        mObserveData.setListener(() -> mListItems.setAdapter(new PictureItemAdapter()));
        helper.helpFetchData(mObserveData);
    }

    public void setRecyclerView(RecyclerView listItems) {
        mListItems = listItems;
    }

    public interface DataFetchListener {
        void onDataReceived();
    }
}
