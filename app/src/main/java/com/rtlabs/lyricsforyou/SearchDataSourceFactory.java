package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

public class SearchDataSourceFactory extends DataSource.Factory {

    private String phrase;

    public SearchDataSourceFactory(String phrase){
        this.phrase = phrase;
    }

    private MutableLiveData<PageKeyedDataSource<Integer, Lyric>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        SearchDataSource itemDataSource = new SearchDataSource(this.phrase);
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Lyric>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
