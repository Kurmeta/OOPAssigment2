package com.example.assignment2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AddonsViewModel extends ViewModel {

    private final MutableLiveData<List<String>> selectedAddonsLiveData = new MutableLiveData<>();

    public MutableLiveData<List<String>> getSelectedAddonsLiveData() {
        return selectedAddonsLiveData;
    }

    public void updateSelectedAddons(List<String> addons) {
        selectedAddonsLiveData.setValue(addons);
    }
}
