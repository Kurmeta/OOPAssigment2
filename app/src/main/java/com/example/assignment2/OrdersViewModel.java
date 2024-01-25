// OrdersViewModel.java

package com.example.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ViewModel class to manage orders data
public class OrdersViewModel extends ViewModel {

    // Key for storing orders in SharedPreferences
    private static final String ORDERS_KEY = "orders";

    // Method to add a new order to the saved orders
    public static void addOrder(Context context, String order) {
        // Retrieve existing orders
        List<String> orders = getOrders(context);

        // Add the new order to the list
        orders.add(order);

        // Save the updated orders
        saveOrders(context, orders);
    }

    // Method to retrieve the list of saved orders
    public static List<String> getOrders(Context context) {
        // Access SharedPreferences for storing orders
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        // Retrieve the orders string from SharedPreferences
        String ordersString = sharedPreferences.getString(ORDERS_KEY, "");

        // Check if there are any saved orders
        if (ordersString.isEmpty()) {
            return new ArrayList<>();
        } else {
            // Split the orders string and convert it to a list
            return new ArrayList<>(Arrays.asList(ordersString.split("@")));
        }
    }

    // Method to clear all saved orders
    public static void clearOrders(Context context) {
        // Access SharedPreferences for storing orders
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        // Remove the saved orders
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(ORDERS_KEY);
        editor.apply();
    }

    // Method to save the updated list of orders
    private static void saveOrders(Context context, List<String> orders) {
        // Access SharedPreferences for storing orders
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        // Convert the list of orders to a single string using delimiter '@'
        String ordersString = TextUtils.join("@", orders);

        // Save the orders string in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORDERS_KEY, ordersString);
        editor.apply();
    }
}
