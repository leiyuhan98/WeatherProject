package com.example.week6_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Call onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","调用onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","调用onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","调用onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","调用onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","调用onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","调用onRestart()");
    }
}
