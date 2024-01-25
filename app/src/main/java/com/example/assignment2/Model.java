// Model.java

package com.example.assignment2;

import java.util.List;

// A model class representing the data structure used in the application.
public class Model {

    // Variable to store the text for the build button
    private String buildButtonText;

    // Getter method to retrieve the text for the build button
    public String getBuildButtonText() {
        return buildButtonText;
    }

    // Setter method to set the text for the build button
    public void setBuildButtonText(String buildButtonText) {
        this.buildButtonText = buildButtonText;
    }

    // Inner class representing an order
    public static class Order {

        // Variables to store selected PC and addons for an order
        private String selectedPc;
        private List<String> selectedAddons;

        // Constructor to initialize an order with selected PC and addons
        public Order(String selectedPc, List<String> selectedAddons) {
            this.selectedPc = selectedPc;
            this.selectedAddons = selectedAddons;
        }

        // Getter method for retrieving the selected PC
        public String getSelectedPc() {
            return selectedPc;
        }

        // Getter method for retrieving the list of selected addons
        public List<String> getSelectedAddons() {
            return selectedAddons;
        }
    }
}
