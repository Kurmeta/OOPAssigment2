package com.example.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdersViewModel extends ViewModel {
    private static final String ORDERS_KEY = "orders";

    public static void addOrder(Context context, String order) {
        List<String> orders = getOrders(context);
        orders.add(order);
        saveOrders(context, orders);
    }

    public static List<String> getOrders(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String ordersString = sharedPreferences.getString(ORDERS_KEY, "");

        if (ordersString.isEmpty()) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(ordersString.split("@")));
        }
    }

    public static void clearOrders(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(ORDERS_KEY);
        editor.apply();
    }

    private static void saveOrders(Context context, List<String> orders) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String ordersString = TextUtils.join("@", orders);
        editor.putString(ORDERS_KEY, ordersString);

        editor.apply();
    }
}
