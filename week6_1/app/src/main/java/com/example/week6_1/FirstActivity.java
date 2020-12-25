package com.example.week6_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.util.Log;
public class FirstActivity extends AppCompatActivity {
    private final static String TAG = "FirstActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            if(resultCode==RESULT_OK){
                String msg=data.getStringExtra("msg");
                Log.d(TAG,"msg"+msg);
            }
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button buttin1 = findViewById(R.id.Button1);
        buttin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                String myname = "leiyuhan";
//                String mynumbre = "41812532";
//                bundle.putString("name", myname);
//                bundle.putString("number", mynumbre);
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("Message", bundle);
//                startActivity(intent);
            }
        //隐式intent示例1
        /*Intent intent=new Intent(com.example.activityapplication.MY_ACTION);
        intent.addCategory(android.intent.category.DEFAULT);
        startActivity(intent);
        */

         //隐式intent示例2
        /*Intent intent=new Intent(Intetn.ACTION_VIEW);
        intent.addCategory(Uri.parse("https://www.baidu.com"));
        startActivity(intent);
       */

            //隐式intent示例4
//            Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//            startActivityForResult(intent,1);

            //示例5
            Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
            Bundle bundle=new Bundle();
            Message msg=new Message("zhangsan","M",20);
            bundle.putParcelable("msg",msg);
            intent.putExtra("message",bundle);
            startActivity(intent);
        });
    }
}
