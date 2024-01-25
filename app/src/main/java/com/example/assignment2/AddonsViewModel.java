package com.example.assignment2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

// ViewModel class for managing the selected addons data in a lifecycle-aware manner.
public class AddonsViewModel extends ViewModel {

    // MutableLiveData to hold and observe the selected addons list.
    private final MutableLiveData<List<String>> selectedAddonsLiveData = new MutableLiveData<>();

    // Getter method to provide access to the MutableLiveData externally.
    public MutableLiveData<List<String>> getSelectedAddonsLiveData() {
        return selectedAddonsLiveData;
    }

    // Method to update the selected addons list in the ViewModel.
    // This method sets the new value for the MutableLiveData, triggering observers.
    public void updateSelectedAddons(List<String> addons) {
        selectedAddonsLiveData.setValue(addons);
    }
}
