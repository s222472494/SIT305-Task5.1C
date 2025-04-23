package com.example.a51cnewsapp.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a51cnewsapp.R;
import com.example.a51cnewsapp.adapters.RelatedNewsAdapter;
import com.example.a51cnewsapp.models.NewsItem;
import com.example.a51cnewsapp.utils.DummyData;

public class NewsDetailFragment extends Fragment {

    public NewsDetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        ImageView imageView = view.findViewById(R.id.news_image);
        TextView title = view.findViewById(R.id.news_title);
        TextView description = view.findViewById(R.id.news_description);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_related_news);

        NewsItem newsItem = (NewsItem) getArguments().getSerializable("news");

        if (newsItem != null) {
            title.setText(newsItem.getTitle());
            description.setText(newsItem.getDescription());

            Glide.with(requireContext())
                    .load(newsItem.getImageUrl())
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.placeholder_image)
                    .into(imageView);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new RelatedNewsAdapter(DummyData.getRelatedNews(newsItem.getId())));
        }

        return view;
    }
}