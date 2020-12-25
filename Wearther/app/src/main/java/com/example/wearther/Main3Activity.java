package com.example.wearther;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_editnote =  findViewById(R.id.btn_editnote);
        btn_editnote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editnote:
                Intent intent=new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}
