package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

public class SearchDataSourceFactory extends DataSource.Factory {

    public SearchDataSourceFactory(){
    }

    private MutableLiveData<PageKeyedDataSource<Integer, Lyric>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        SearchDataSource itemDataSource = new SearchDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Lyric>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
