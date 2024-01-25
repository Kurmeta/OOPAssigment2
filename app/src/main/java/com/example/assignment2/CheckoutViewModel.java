// CheckoutViewModel.java

package com.example.assignment2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

// ViewModel class for managing data related to the checkout process.
public class CheckoutViewModel extends AndroidViewModel {

    // MutableLiveData to hold and observe the selected addons list.
    private final MutableLiveData<List<String>> selectedAddonsLiveData = new MutableLiveData<>();

    // Constructor for the CheckoutViewModel, inheriting from AndroidViewModel.
    public CheckoutViewModel(@NonNull Application application) {
        super(application);
    }

    // Getter method to provide access to the MutableLiveData externally.
    public MutableLiveData<List<String>> getSelectedAddonsLiveData() {
        return selectedAddonsLiveData;
    }

    // Method to set the selected addons list in the ViewModel.
    // This method sets the new value for the MutableLiveData, triggering observers.
    public void setSelectedAddons(List<String> selectedAddons) {
        selectedAddonsLiveData.setValue(selectedAddons);
    }
}
