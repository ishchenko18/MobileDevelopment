package com.example.audiovideolabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //open audio player
        Button audioPlayButton = findViewById(R.id.playAudio);
        audioPlayButton.setOnClickListener(view -> {
            startActivity(new Intent(this, AudioActivity.class));
        });

        //open video player
        Button videoPlayButton = findViewById(R.id.playVideo);
        videoPlayButton.setOnClickListener(view -> {
            startActivity(new Intent(this, VideoActivity.class));
        });
    }
}
