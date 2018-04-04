package com.example.froukje.countingbirds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Toestand extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toestand);
        buildMenu();
    }
}
