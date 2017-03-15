package com.example.uberv.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoView = new VideoView(this);
//        videoView.setVideoURI( Uri.parse("https://youtu.be/MXJ-zpJeY3E") );
        controller = new MediaController(this);
        videoView.setMediaController(controller);

        RedirectTracerTask task = new RedirectTracerTask(videoView);
        Uri location = Uri.parse("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
        task.execute(location);
        videoView.start();
        setContentView(videoView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}
