package com.example.week9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SharedPressActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_press);

        Button save_data=findViewById(R.id.save_data);
        save_data.setOnClickListener(this);
        Button restore_data=findViewById(R.id.restore_data);
        restore_data.setOnClickListener(this);

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.save_data:
                SharedPreferences sharedPreference1 =getSharedPreferences("MySharePres",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreference1.edit();
                editor.putString("Name","LYH");
                editor.putInt("Number",41812532);
                editor.apply();
                Log.d("SharedPressActivity","save data");
                break;
            case R.id.restore_data:
                SharedPreferences sharedPreference2 =getSharedPreferences("MySharePres",MODE_PRIVATE);
                String name=sharedPreference2.getString("Name","");
                int number=sharedPreference2.getInt("Number",0);
                Log.d("SharedPressActivity","this name is"+name+",this number is"+number);
                break;
        }
    }
}
