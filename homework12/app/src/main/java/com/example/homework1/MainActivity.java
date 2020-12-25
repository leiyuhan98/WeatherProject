package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.layout1);

        Button createDB_btn=findViewById(R.id.creatDB_btn);
        createDB_btn.setOnClickListener(this);
        Button addData_btn=findViewById(R.id.addData_btn);
        addData_btn.setOnClickListener(this);
        Button updateData_btn=findViewById(R.id.updateData_btn);
        updateData_btn.setOnClickListener(this);
        Button deleteData_btn=findViewById(R.id.deleteData_btn);
        deleteData_btn.setOnClickListener(this);
        Button queryData_btn=findViewById(R.id.queryData_btn);
        queryData_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.creatDB_btn:
                LitePal.getDatabase();
                break;
            case R.id.addData_btn:
                Book addbook=new Book();
                addbook.setName("the first");
                addbook.setAuther("无");
                addbook.setPages(435);
                addbook.setPrice(16.90);
                addbook.setPress("null");
                addbook.save();
                break;
            case R.id.updateData_btn:
                Book updatebook=new Book();
                updatebook.setPrice(10);
                updatebook.updateAll("name=?","the first");

        }
    }
}
