package com.example.week11_1;


import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private final static String TAG="MyService";

    private DownloadBinder mBinder =new DownloadBinder();
    public MyService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind executed");
        return new DownloadBinder();
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate executed");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy executed");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind executed");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    public void startDownload() {
        Log.d(TAG,"startDownload executed");
    }
    class DownloadBinder extends Binder {
        public MyService getService(){
            return MyService.this;
        }
    }
}
