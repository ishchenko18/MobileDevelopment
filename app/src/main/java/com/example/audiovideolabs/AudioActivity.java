package com.example.audiovideolabs;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setOnCompletionListener(mp -> stop());

        playButton = findViewById(R.id.playAudio);
        pauseButton = findViewById(R.id.pauseAudio);
        stopButton = findViewById(R.id.stopAudio);

        playButton.setOnClickListener(v -> play());
        pauseButton.setOnClickListener(v -> pause());
        stopButton.setOnClickListener(v -> stop());

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    private void stop() {
        mediaPlayer.stop();

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
            playButton.setEnabled(true);
        } catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play() {
        mediaPlayer.start();

        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    public void pause() {
        mediaPlayer.pause();

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer.isPlaying()) {
            stop();
        }
    }
}
