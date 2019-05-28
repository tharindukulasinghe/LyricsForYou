package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import android.util.Log;
import android.widget.Toast;

public class SearchViewModel extends ViewModel {

    LiveData<PagedList<Lyric>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Lyric>> liveDataSource;
    static String phrase = "";

    PagedList.Config config =
            (new PagedList.Config.Builder())
                    .setEnablePlaceholders(false)
                    .setPageSize(ItemDataSource.PAGE_SIZE)
                    .build();

    public SearchViewModel() {

        SearchDataSourceFactory searchDataSourceFactory = new SearchDataSourceFactory();
        liveDataSource = searchDataSourceFactory.getItemLiveDataSource();
        Log.e("class",phrase);
        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(searchDataSourceFactory, config)).build();

    }




}
