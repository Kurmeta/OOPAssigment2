// FinishedViewModel.java

package com.example.assignment2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// ViewModel responsible for handling data related to the FinishedActivity.
public class FinishedViewModel extends ViewModel {

    // MutableLiveData to hold an instance of the Model class
    private final MutableLiveData<Model> modelLiveData = new MutableLiveData<>();

    // Getter method to observe changes in the Model LiveData
    public LiveData<Model> getModelLiveData() {
        return modelLiveData;
    }
}
