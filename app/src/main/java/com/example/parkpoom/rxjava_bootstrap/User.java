package com.example.parkpoom.rxjava_bootstrap;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by digio-macair13 on 12/26/17.
 */

public class User {

    @SerializedName("node_id")
    private String login;


    public String getLogin() {
        return login;
    }
}
