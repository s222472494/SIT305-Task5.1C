package com.example.a51cnewsapp.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a51cnewsapp.R;
import com.example.a51cnewsapp.models.NewsItem;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<NewsItem> items;
    private final TopStoriesAdapter.OnItemClickListener listener;

    public NewsAdapter(List<NewsItem> items, TopStoriesAdapter.OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        NewsItem item = items.get(position);
        holder.title.setText(item.getTitle());

        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.image);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            image = itemView.findViewById(R.id.news_image);
        }
    }
}
