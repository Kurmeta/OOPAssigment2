// BuildViewModel.java

package com.example.assignment2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// ViewModel class responsible for managing data related to the build process.
public class BuildViewModel extends ViewModel {

    // MutableLiveData to hold and observe the current Model for the build.
    private final MutableLiveData<Model> modelLiveData = new MutableLiveData<>();

    // Getter method to provide external access to the LiveData holding the current Model.
    public LiveData<Model> getModelLiveData() {
        return modelLiveData;
    }
}
