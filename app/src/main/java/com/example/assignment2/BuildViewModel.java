// BuildViewModel.java
package com.example.assignment2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuildViewModel extends ViewModel {

    private final MutableLiveData<Model> modelLiveData = new MutableLiveData<>();

    public LiveData<Model> getModelLiveData() {
        return modelLiveData;
    }
}
