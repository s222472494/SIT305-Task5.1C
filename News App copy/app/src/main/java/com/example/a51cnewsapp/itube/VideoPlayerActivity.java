package com.example.a51cnewsapp.itube;

import com.example.a51cnewsapp.R;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {

    private WebView webView;
    private ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        webView = findViewById(R.id.webView);
        btnClose = findViewById(R.id.btnClose);

        // Enable JavaScript for the WebView
        webView.getSettings().setJavaScriptEnabled(true);

        // Get the URL of the video from the intent
        String videoUrl = getIntent().getStringExtra("VIDEO_URL");

        // Load the YouTube video if the URL is not null
        if (videoUrl != null) {
            webView.loadUrl(videoUrl);
            webView.setWebViewClient(new WebViewClient()); // Open URL in WebView
        }

        // Set the close button functionality
        btnClose.setOnClickListener(v -> finish()); // Close the current activity and return to PlaylistActivity
    }
}
