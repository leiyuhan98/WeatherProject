package com.example.week11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG="ServiceActivity";
    private MyService service;
    private ServiceConnection connection=new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG,"onServiceConnected executed");
            service=((MyService.DownloadBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG,"onServiceConnected executed");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button start_service=findViewById(R.id.start_service);
        Button stop_service=findViewById(R.id.stop_service);
        Button bind_service=findViewById(R.id.bind_service);
        Button unbind_service=findViewById(R.id.unbind_service);
        Button call_method_startDownload=findViewById(R.id.call_method_startDownload);
        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);
        bind_service.setOnClickListener(this);
        unbind_service.setOnClickListener(this);
        call_method_startDownload.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                Intent startInter=new Intent(this,MyService.class);
                startService(startInter);
                break;
            case R.id.stop_service:
                Intent stopInter=new Intent(this,MyService.class);
                stopService(stopInter);
                break;
            case R.id.bind_service:
                Intent bindInter=new Intent(this,MyService.class);
                bindService(bindInter,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            case R.id.call_method_startDownload:
                Log.d(TAG,"call startdownload next");
                if(service!=null){
                    service.startDownload();
                }
                break;
            default:
                break;
        }
    }

}
