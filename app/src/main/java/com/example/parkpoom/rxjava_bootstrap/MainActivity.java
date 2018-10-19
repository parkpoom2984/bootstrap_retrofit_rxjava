package com.example.parkpoom.rxjava_bootstrap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements Presenter.ListenerToUIThread {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Presenter presenter = new Presenter();
        presenter.init(this);
        presenter.callServiceAA();
        // presenter.callService();
    }

    @Override
    public void updateRecyclerview(String user) {
        textView.setText(user);
    }

    @Override
    public void showResponseAA(String user) {
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
    }
}
