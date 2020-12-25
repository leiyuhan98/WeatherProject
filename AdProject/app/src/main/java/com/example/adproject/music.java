package com.example.adproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class music extends AppCompatActivity {
//VideoView控件的使用
    private VideoView video;
    private Button play, end;
    private Button back;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }
    private void InitView() {
        video = (VideoView) findViewById(R.id.videoView);
        play = (Button) findViewById(R.id.btn_play);
        end = (Button) findViewById(R.id.btn_end);
        back = (Button) findViewById(R.id.btn_back);
        play.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Init();

            }

        });

        end.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                video.stopPlayback();

            }

        });

//返回MainActivity页面的页面跳转

//并且同时结束视频的播放

        back.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                video.stopPlayback();

                Intent intent2 = new Intent(music.this, MainActivity.class);

                startActivity(intent2);

            }

        });

    }

    private void Init() {

        String uri = null;

        mediaController = new MediaController(this);//控制器，里面包含媒体播放器控件的视图，比如快进后退，进度条

//这是是将点击ListView中Item的值，传过来进行判断

//来确定是哪一个电影

        Intent intent = getIntent();

        String data = intent.getStringExtra("video");

        switch (data){

            case "0":

                uri = "android.resource://" + getPackageName() + "/" + R.raw.test;//

                break;

            case "1":

                uri = "android.resource://" + getPackageName() + "/" + R.raw.test;//

                break;

            case "2":

                uri = "android.resource://" + getPackageName() + "/" + R.raw.last_stop;//

                break;

            case "3":

                uri = "android.resource://" + getPackageName() + "/" + R.raw.music;//

                break;

            case "4":

                uri = "android.resource://" + getPackageName() + "/" + R.raw.test;//

                break;

            default:

                break;

        }

        video.setVideoURI(Uri.parse(uri));

        video.setMediaController(mediaController);

        mediaController.setMediaPlayer(video);

        video.requestFocus();

        video.start();

    }

}