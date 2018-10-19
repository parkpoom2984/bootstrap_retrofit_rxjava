package com.example.parkpoom.rxjava_bootstrap;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //String result = "";
    ArrayList<String> listString = new ArrayList<>();

    @Before
    public void beforeTest() {
        listString.add("Thai_1");
        listString.add("Thai_2");
        listString.add("Thai_3");
        listString.add("Thai_4");
        listString.add("Thai_5");
        listString.add("Thai_6");
        listString.add("Thai_7");
        listString.add("Thai_8");
    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testRxJava() throws Exception {
        //result = "";
        Observable<ArrayList<String>> observer = Observable.fromCallable(new Callable<ArrayList<String>>() {
            @Override
            public ArrayList<String> call() throws Exception {
                return listString;
            }
        });
        observer.subscribe(new DisposableObserver<ArrayList<String>>() {

            @Override
            public void onNext(@NonNull ArrayList<String> s) {
                //result=s;
                Log.d("Test", "OnNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }); // Callable as subscriber
        //assertTrue(result.equals("Hello"));
    }
}