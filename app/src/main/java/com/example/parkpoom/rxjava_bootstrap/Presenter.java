package com.example.parkpoom.rxjava_bootstrap;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by digio-macair13 on 12/26/17.
 */

public class Presenter {
    private ListenerToUIThread listenerToUIThread;

    public void init(ListenerToUIThread listenerToUIThread){
        this.listenerToUIThread = listenerToUIThread;
    }

    public void callServiceAA() {
        Controller controller = new Controller();
        controller.callUserAA().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        listenerToUIThread.showResponseAA(user.getLogin());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void callService(){
        Controller controller = new Controller();


//        Observable<String> observable = Observable.zip(controller.callMutiple(), controller.callUser(),new BiFunction<User, User, String>(){
//
//                    @Override
//                    public String apply(@NonNull User user, @NonNull User user2) throws Exception {
//                        return user.getLogin() + "/" + user2.getLogin();
//                    }
//                });
//        observable.subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                listenerToUIThread.updateRecyclerview(s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        controller.callUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {


            }

            @Override
            public void onNext(@NonNull User user) {
                Log.d("test",user.getLogin());
                listenerToUIThread.updateRecyclerview(user.getLogin());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("test","onError"+ e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    interface ListenerToUIThread{
        void updateRecyclerview(String user);
        void showResponseAA(String user);
    }
}
