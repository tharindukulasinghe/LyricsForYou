package com.rtlabs.lyricsforyou;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Lyric {
    public String artist;
    public String title;
    public String lyric;
}
public class SearchResult {
    public List<Lyric> results;
    public Pagination pagination;
}
