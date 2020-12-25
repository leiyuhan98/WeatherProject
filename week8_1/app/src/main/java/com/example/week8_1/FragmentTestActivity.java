package com.example.week8_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FragmentTestActivity extends AppCompatActivity {
    private  final static String TAG = "FragmentTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_title_frag);

        Log.d(TAG,"Activity--onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Activity--onCreate()");
    }

}
