package com.brandapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.brandapp.di.Injection;
import com.brandapp.model.TaskHelper;
import com.brandapp.util.LogUtils;
import com.brandapp.view.PictureItemAdapter;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "MainViewModel";
    private final Injection mInjection;
    private final ObserveData<String> mObserveData = new ObserveData<>();
    public MutableLiveData<String> mHeaderText = new MutableLiveData<>();
    private LifecycleOwner mLifecycleOwner;
    private Context mContext;
    private RecyclerView mListItems;

    public MainViewModel(@NonNull Application application,
                         Injection injection) {
        super(application);
        mInjection = injection;
        mHeaderText.setValue("Brand Listing screen");
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner, Context context) {
        mContext = context;
        mLifecycleOwner = lifecycleOwner;
    }

    public void loadData() {
        TaskHelper helper = new TaskHelper(mInjection, mLifecycleOwner);
        helper.helpFetchData(mObserveData);
    }

    public void setRecyclerView(RecyclerView listItems) {
        mListItems = listItems;
    }

    public class ObserveData<T> implements Observer<T> {
        @Override
        public void onChanged(T t) {
            if (t instanceof String) {
                String str = (String) t;
                LogUtils.logVerbose(TAG, str);
                mListItems.setAdapter(new PictureItemAdapter());
                Toast.makeText(mContext, "" + str, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
