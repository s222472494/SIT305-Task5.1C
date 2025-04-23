package com.example.a51cnewsapp.itube;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a51cnewsapp.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistViewActivity extends AppCompatActivity {

    private ListView playlistListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_view);

        playlistListView = findViewById(R.id.playlistListView);

        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedPlaylist = prefs.getString("playlist", null);
        List<String> playlist;

        if (savedPlaylist != null) {
            playlist = new ArrayList<>(Arrays.asList(savedPlaylist.split(",")));
        } else {
            playlist = new ArrayList<>();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                playlist
        );
        playlistListView.setAdapter(adapter);
    }
}
