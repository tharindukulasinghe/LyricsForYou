package com.rtlabs.lyricsforyou;

import java.util.List;

public class TrendingResult {
    public List<Trending> results;
}

class Trending {
    public int hits;
    public String _id;
    public long date;
    public Lyric lyric;
}