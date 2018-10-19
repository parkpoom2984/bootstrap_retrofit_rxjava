package com.example.parkpoom.rxjava_bootstrap;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by digio-macair13 on 12/27/17.
 */

public class Controller{


    RetrofitConfig retrofitConfig = new RetrofitConfig();
    Service service = retrofitConfig.getRetrofit().create(Service.class);

    public Observable<User> callUser(){
        return service.getProfileUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<User> callUserAA() {
        return service.getProfileAA().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


//    public Observable<User> callMutiple(){
//        return service.getTest().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//
//    }
}
