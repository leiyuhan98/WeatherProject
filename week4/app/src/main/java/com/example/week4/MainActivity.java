package com.example.week4;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener {


    private String[] mountainArray;
    private ProgressBar progressBar;
    private EditText usernameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdemo);
        mountainArray = getResources().getStringArray(R.array.visit_place_array);
        initView();
        onSubmitConfirn();
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        mountainArry=getResources();

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        TextView placeLabeView = findViewById(R.id.place_label1);
        placeLabeView.setText("请投票");
        TextView tv = findViewById(R.id.place_label1);

        RadioGroup rg = findViewById(R.id.visit_place_rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int index = -1;
                if (i == R.id.button1) {
                    index = 0;
                } else if (i == R.id.button2) {
                    index = 1;
                } else if (i == R.id.button3) {
                    index = 1;
                }
                if (index >= 0 && index < mountainArray.length) {
                    showUIToast(mountainArray[index]);
                }

            }
        });
        CheckBox checkbox = findViewById(R.id.badminton_view);
        CheckBox checkbox2 = findViewById(R.id.badminton11_view);
        checkbox.setOnCheckedChangeListener(this);
        checkbox2.setOnCheckedChangeListener(this);

        Button bu = findViewById(R.id.plus_view);
        Button bu2 = findViewById(R.id.plus2_view);
        Button submit = findViewById(R.id.submit);
        bu.setOnClickListener(this);
        bu2.setOnClickListener(this);
        submit.setOnClickListener(this);


        progressBar = findViewById(R.id.progressBar);

        usernameView = findViewById(R.id.username);


    }

    private void showUIToast(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "投票的景点是" + info,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.plus_view:
                updateProgressView(true);
                break;
            case R.id.submit:
                onSubmitConfirn();
            case R.id.plus2_view:
                updateProgressView(false);
                break;
            default:
                break;
        }
    }

    private void updateProgressView(boolean b) {
        int progress = progressBar.getProgress();
        if (b) {
            progress += 10;
            {
                if (progress > 100) {
                    progress = 100;
                }
            }
        } else {
            progress -= 10;
            if (progress < 0) {
                progress = 0;
            }
        }
        progressBar.setProgress(progress);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    private void onSubmitConfirn() {
        //声明对象
        AlertDialog dlg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("是否确定退出应用:")
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onSubmit();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
        });
        //添加确定按钮
        //添加取消按钮
        dlg = builder.create();
        dlg.show();
    }

   private void onSubmit() {
        StringBuffer sb = new StringBuffer();
        sb.append("您选择的爱好是：${hobbies}");
        String username=usernameView.getText().toString();
        if(username!=null && username.isEmpty()){
            sb.append("\n by"+username);
        }
    //    resultView.setText(sb.toString());
   }
    }

