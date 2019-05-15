package com.example.audiovideolabs;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoPlayer;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        playButton = findViewById(R.id.playVideoButton);
        pauseButton = findViewById(R.id.pauseVideoButton);
        stopButton = findViewById(R.id.stopVideoButton);

        playButton.setOnClickListener(view -> {
            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);

            videoPlayer.start();
        });

        pauseButton.setOnClickListener(view -> {
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(true);

            videoPlayer.pause();
        });

        stopButton.setOnClickListener(view -> {
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(false);

            videoPlayer.stopPlayback();
            videoPlayer.resume();
        });

        videoPlayer = findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
    }
}
