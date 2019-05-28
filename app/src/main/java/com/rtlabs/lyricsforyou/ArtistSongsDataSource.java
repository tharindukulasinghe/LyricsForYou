package com.rtlabs.lyricsforyou;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistSongsDataSource extends PageKeyedDataSource<Integer, Lyric> {

    public static final int PAGE_SIZE = 100;
    private static final int FIRST_PAGE = 0;
    static String phrase;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Lyric> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getArtistSongs(FIRST_PAGE, PAGE_SIZE,phrase)
                .enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

                        if(response.body() != null){
                            callback.onResult(response.body().results, null, FIRST_PAGE + 1);
                        }

                    }
                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Lyric> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getArtistSongs(params.key, PAGE_SIZE,phrase)
                .enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {



                        if(response.body() != null){
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().results, key);
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Lyric> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getArtistSongs(params.key, PAGE_SIZE,phrase)
                .enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

                        if(response.body() != null){
                            Integer key = params.key + 1;
                            callback.onResult(response.body().results, key);
                        }

                    }

                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {

                    }
                });


    }
}