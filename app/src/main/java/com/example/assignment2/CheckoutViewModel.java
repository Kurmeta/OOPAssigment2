package com.example.assignment2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class CheckoutViewModel extends AndroidViewModel {

    private final MutableLiveData<List<String>> selectedAddonsLiveData = new MutableLiveData<>();

    public CheckoutViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<String>> getSelectedAddonsLiveData() {
        return selectedAddonsLiveData;
    }

    public void setSelectedAddons(List<String> selectedAddons) {
        selectedAddonsLiveData.setValue(selectedAddons);
    }

    public void addOrder(String selectedPc, List<String> selectedAddons) {
        // Handle adding the order, e.g., store it in a database
    }
}
