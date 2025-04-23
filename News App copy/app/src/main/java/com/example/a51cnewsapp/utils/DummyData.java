package com.example.a51cnewsapp.utils;

import com.example.a51cnewsapp.models.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<NewsItem> getTopStories() {
        List<NewsItem> topStories = new ArrayList<>();

        topStories.add(new NewsItem(
                101,
                "AI Breakthrough in Healthcare",
                "AI is revolutionising medical diagnostics and personalized treatment.",
                "https://images.unsplash.com/photo-1588776814546-bd048d2433f9"  // Healthcare
        ));

        topStories.add(new NewsItem(
                102,
                "Mars Mission Launch Successful",
                "NASA's latest rover mission to Mars successfully lifts off.",
                "https://mars.nasa.gov/system/news_items/main_images/9336_PIA24428-FigureA-web.jpg"  // Space
        ));

        topStories.add(new NewsItem(
                103,
                "Quantum Computing Advances",
                "New quantum chip dramatically boosts computing speeds.",
                "https://cdn.pixabay.com/photo/2020/06/10/16/52/computer-5287532_1280.jpg"
        ));

        return topStories;
    }

    public static List<NewsItem> getNews() {
        List<NewsItem> news = new ArrayList<>();

        news.add(new NewsItem(
                201,
                "Climate Change Affecting Ocean Life",
                "Recent studies show a drastic shift in marine ecosystems.",
                "https://cdn.pixabay.com/photo/2015/10/30/20/13/coral-1015566_1280.jpg"  // Ocean
        ));

        news.add(new NewsItem(
                202,
                "Technology in Education",
                "Schools are integrating AR and VR to enhance student learning.",
                "https://cdn.pixabay.com/photo/2020/04/14/07/56/online-5033385_1280.jpg"  // Tech
        ));

        news.add(new NewsItem(
                203,
                "Electric Cars: Future of Transportation",
                "Global EV sales surge as infrastructure improves.",
                "https://cdn.pixabay.com/photo/2020/06/28/09/16/electric-car-5349999_1280.jpg"  // EV
        ));

        news.add(new NewsItem(
                204,
                "Wildfires Threaten Wildlife",
                "Australia faces increased bushfires endangering species.",
                "https://cdn.pixabay.com/photo/2016/05/04/19/04/koala-1373105_1280.jpg"  // Wildlife
        ));

        return news;
    }

    public static List<NewsItem> getRelatedNews(int id) {
        List<NewsItem> relatedNews = new ArrayList<>();
        relatedNews.add(new NewsItem(
                301,
                "Battery Innovations in EVs",
                "New lithium-sulfur batteries may triple electric car range.",
                "https://cdn.pixabay.com/photo/2020/10/02/08/13/battery-5621380_1280.jpg"  // Battery
        ));
        return relatedNews;
    }
}
