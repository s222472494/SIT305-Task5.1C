package com.example.a51cnewsapp.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.a51cnewsapp.R;
import com.example.a51cnewsapp.adapters.NewsAdapter;
import com.example.a51cnewsapp.adapters.TopStoriesAdapter;
import com.example.a51cnewsapp.models.NewsItem;
import com.example.a51cnewsapp.utils.DummyData;
import com.example.a51cnewsapp.itube.LoginActivity;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerTopStories, recyclerNews;
    private ImageButton btnLeft, btnRight;
    private Button btnItube;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerTopStories = view.findViewById(R.id.recycler_top_stories);
        recyclerNews = view.findViewById(R.id.recycler_news);
        btnLeft = view.findViewById(R.id.btn_left);
        btnRight = view.findViewById(R.id.btn_right);
        btnItube = view.findViewById(R.id.btn_itube);

        btnItube.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        List<NewsItem> topStories = DummyData.getTopStories();
        List<NewsItem> news = DummyData.getNews();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerTopStories.setLayoutManager(layoutManager);
        recyclerTopStories.setAdapter(new TopStoriesAdapter(topStories, this::openNewsDetail));

        recyclerNews.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerNews.setAdapter(new NewsAdapter(news, this::openNewsDetail));

        btnLeft.setOnClickListener(v -> recyclerTopStories.smoothScrollBy(-300, 0));
        btnRight.setOnClickListener(v -> recyclerTopStories.smoothScrollBy(300, 0));

        return view;
    }

    private void openNewsDetail(NewsItem newsItem) {
        NewsDetailFragment detailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("news", newsItem);
        detailFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
