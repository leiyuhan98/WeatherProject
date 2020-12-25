package com.example.week6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private final static String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent i=getIntent();
        Bundle bundle=i.getBundleExtra("msg");
        if(bundle!=null){
            Message msg= (Message) bundle.get("msg");
            Log.d(TAG,"msg+"+msg);
        }

//        Intent intent=getIntent();
//        Bundle bundle=intent.getBundleExtra("Message");
//        if(bundle!=null){
//            String name=bundle.getString("name");
//            String number=bundle.getString("number");
//            Log.d("SecondActivity","name"+name+",number="+number);
//        }
        Button buttin2=findViewById(R.id.Button2);
        buttin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("msg","data from SecondActivity");
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
