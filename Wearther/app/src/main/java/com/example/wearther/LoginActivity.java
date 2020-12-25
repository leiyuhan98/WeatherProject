package com.example.wearther;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editTextName,getEditTextPwd;
    TextView textViewRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button) this.findViewById(R.id.buttonLogin);
        editTextName=(EditText)this.findViewById(R.id.editTextName);
        getEditTextPwd=(EditText)this.findViewById(R.id.editTextPassword);
        textViewRegister=(TextView)this.findViewById(R.id.textViewRegister);
        btnLogin.setOnClickListener(new View.OnClickListener(){//实现登录

            @Override
            public void onClick(View v) {
                login();
            }
        });
        textViewRegister.setOnClickListener(new View.OnClickListener(){//实现注册

            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register() {//跳转到注册页面
        Intent intent=new Intent();
        intent.setClass(this,RegisterActivity.class);
        startActivity(intent);
    }
    private void login(){//登录校验
        String name=editTextName.getText().toString();
        String pwd=getEditTextPwd.getText().toString();
        if(name.equals("admin") && pwd.equals("admin")){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
        }
    }

}
