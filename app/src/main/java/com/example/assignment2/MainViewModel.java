package com.example.assignment2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends ViewModel {
    private MainModel mainModel = new MainModel();

    public LiveData<MainModel> getMainModel() {
        MutableLiveData<MainModel> liveData = new MutableLiveData<>();
        liveData.setValue(mainModel);
        return liveData;
    }

    public void updateBuildButtonText(String newText) {
        mainModel.setBuildButtonText(newText);
    }
}
