package com.example.week13_2;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {
    private MediaPlayer player;
    private Timer timer;

    public MusicService(){

    }
    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicControl();
    }
    class MusicControl extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }
    public void play(){
        try{
            player.release();//重置音乐播放器
            player = MediaPlayer.create(getApplicationContext(),R.raw.music);
            //加载多媒体文件
            player.start();//播放音乐
//            if(!player.isPlaying()){
//                player.start();//播放音乐
//            }
            addTimer();//添加计时器
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void pausePlay(){
        player.pause();  //暂停播放音乐
    }
    public void continuePlay(){
        player.start(); //继续播放
    }
    public void seekTo(int progress){
        player.seekTo(progress);    //设置音乐的播放位置
    }
    private void addTimer() {
        if(timer==null){
            timer=new Timer(); //创建计时器对象
            TimerTask task=new TimerTask() {
                @Override
                public void run() {
                    if(player==null) return;
                    int duration =player.getDuration(); //获取歌曲时长
                    int currentPosition=player.getCurrentPosition();    //获取播放进度
                    Message msg=MainActivity.handler.obtainMessage();   //创建消息对象
                    //将音乐的总时长和播放进度封装至消息对象中
                    Bundle bundle=new Bundle();
                    bundle.putInt("duration",duration);
                    bundle.putInt("currentPosition",currentPosition);
                    msg.setData(bundle);
                    //将消息发送到主线程的消息队列
                    MainActivity.handler.sendMessage(msg);
                }
            };
            //开始计时任务后5毫秒，第一次执行task任务，以后每5000毫秒执行一次
            timer.schedule(task,5,500);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=new MediaPlayer();//创建音乐播放器对象
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player==null) return;
        if (player.isPlaying())player.stop();//停止播放音乐
        player.release();//释放占用的资源
        player=null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

