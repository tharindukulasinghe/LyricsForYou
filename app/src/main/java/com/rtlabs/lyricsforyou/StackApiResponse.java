package com.rtlabs.lyricsforyou;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

class Pagination{
    public int current;
    public int perPage;
    public int previous;
    public int next;
}

class Item implements Serializable {
    public String _id;
}
public class StackApiResponse {
    public List<Item> results;
    //public Pagination pagination;
}
