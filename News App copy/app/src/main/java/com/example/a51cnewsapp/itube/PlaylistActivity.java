package com.example.a51cnewsapp.itube;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a51cnewsapp.R;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    private EditText etUrl;
    private Button btnPlay, btnAddToPlaylist, btnViewPlaylist;
    private List<String> playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        etUrl = findViewById(R.id.etUrl);
        btnPlay = findViewById(R.id.btnPlay);
        btnAddToPlaylist = findViewById(R.id.btnAddToPlaylist);
        btnViewPlaylist = findViewById(R.id.btnViewPlaylist);

        // Retrieve the playlist from SharedPreferences (if exists)
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedPlaylist = prefs.getString("playlist", null);

        // If there is no saved playlist, initialise a new one
        if (savedPlaylist == null) {
            playlist = new ArrayList<>();
        } else {
            String[] savedUrls = savedPlaylist.split(",");
            playlist = new ArrayList<>();
            for (String url : savedUrls) {
                playlist.add(url);
            }
        }

        // Set up button click listeners
        btnPlay.setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            if (!url.isEmpty()) {
                // Play the URL (open in a new screen)
                playVideo(url);
            } else {
                Toast.makeText(PlaylistActivity.this, "Please enter a URL", Toast.LENGTH_SHORT).show();
            }
        });

        btnAddToPlaylist.setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            if (!url.isEmpty()) {
                // Add the URL to the playlist
                playlist.add(url);

                // Save the updated playlist in SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("playlist", String.join(",", playlist));
                editor.apply();

                Toast.makeText(PlaylistActivity.this, "URL added to playlist", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PlaylistActivity.this, "Please enter a URL", Toast.LENGTH_SHORT).show();
            }
        });

        btnViewPlaylist.setOnClickListener(v -> {
            Intent intent = new Intent(PlaylistActivity.this, PlaylistViewActivity.class);
            startActivity(intent);
        });

    }

    private void playVideo(String url) {
        // Add "https://" if it's missing in the URL
        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }

        // Get the video ID from the URL
        String videoId = getVideoIdFromUrl(url);
        if (videoId != null) {
            // Start VideoPlayerActivity and pass the video URL
            Intent intent = new Intent(PlaylistActivity.this, VideoPlayerActivity.class);
            intent.putExtra("VIDEO_URL", "https://www.youtube.com/watch?v=" + videoId);
            startActivity(intent);  // Open the VideoPlayerActivity
        } else {
            Toast.makeText(PlaylistActivity.this, "Invalid YouTube URL", Toast.LENGTH_SHORT).show();
        }
    }

    private String getVideoIdFromUrl(String url) {
        String videoId = null;
        if (url.contains("youtube.com") || url.contains("youtu.be")) {
            if (url.contains("v=")) {
                videoId = url.substring(url.indexOf("v=") + 2, url.indexOf("v=") + 13);  // Extract video ID
            } else if (url.contains("youtu.be")) {
                videoId = url.substring(url.lastIndexOf("/") + 1);  // For shortened URLs
            }
        }
        return videoId != null ? videoId : null;
    }
}
