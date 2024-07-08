package com.example.complaintapp;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    public static ArrayList<Customer> customers;

    @Override
    public void onCreate() {
        super.onCreate();
        customers = new ArrayList<>();
    }
}
