package com.example.parkpoom.rxjava_bootstrap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by digio-macair13 on 12/26/17.
 */

interface Service {
    @GET("users/parkpoom2984")
    Observable<User> getProfileUser();


    @GET("users/azka")
    Observable<User> getTest();

    @GET("users/aa")
    Observable<User> getProfileAA();
}
