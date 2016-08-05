package com.talmeida.weather.services.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.talmeida.weather.BR;

/**
 * Created by Tiago on 04/08/2016.
 */
public class User extends BaseObservable {
    private final String firstName;
    private final String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    @Bindable
    public int getAge(){
        return this.age;
    }

    public void incrementAge(){
        ++age;
        notifyPropertyChanged(BR.age);
    }
}