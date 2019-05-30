package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

public class GenreSongsDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Lyric>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        GenreSongsDataSource itemDataSource = new GenreSongsDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Lyric>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
