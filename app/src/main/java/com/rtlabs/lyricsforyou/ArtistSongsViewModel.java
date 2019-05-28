package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

public class ArtistSongsViewModel extends ViewModel {

    LiveData<PagedList<Lyric>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Lyric>> liveDataSource;

    public ArtistSongsViewModel() {

        ArtistSongsDataSourceFactory itemDataSourceFactory = new ArtistSongsDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
