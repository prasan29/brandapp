package com.brandapp.util;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/**
 * ViewModelUtils that provides view model instances.
 */
public final class ViewModelBuilder {

    /**
     * Private constructor for SingleTon ViewModelUtils.
     */
    private ViewModelBuilder() {
    }

    /**
     * Method to generate the ViewModel instance.
     *
     * @param activity   - Activity instance for maintaining the ViewModel scope.
     * @param modelClass - ViewModel class to be instantiated.
     * @param <T>        - Generic ViewModel parameter.
     * @return - Corresponding ViewModel instance.
     */
    public static <T extends ViewModel> T generateViewModel(FragmentActivity activity,
                                                            Class<T> modelClass) {
        return ViewModelProviders.of(activity, ViewModelFactory
                .getInstance(activity.getApplication())).get(modelClass);
    }
}
