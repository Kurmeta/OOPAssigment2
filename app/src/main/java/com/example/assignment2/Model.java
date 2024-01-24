// Model.java
package com.example.assignment2;

import java.util.List;

public class Model {
    private String buildButtonText;

    public String getBuildButtonText() {
        return buildButtonText;
    }

    public void setBuildButtonText(String buildButtonText) {
        this.buildButtonText = buildButtonText;
    }

    public static class Order {
        private String selectedPc;
        private List<String> selectedAddons;

        // Constructor with arguments
        public Order(String selectedPc, List<String> selectedAddons) {
            this.selectedPc = selectedPc;
            this.selectedAddons = selectedAddons;
        }

        // Getter method for selectedPc
        public String getSelectedPc() {
            return selectedPc;
        }

        // Getter method for selectedAddons
        public List<String> getSelectedAddons() {
            return selectedAddons;
        }
}}
