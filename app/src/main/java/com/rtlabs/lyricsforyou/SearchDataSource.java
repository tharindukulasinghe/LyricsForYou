package com.rtlabs.lyricsforyou;

import android.app.Activity;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDataSource extends PageKeyedDataSource<Integer, Lyric> {

    public static final int PAGE_SIZE = 100;
    private static final int FIRST_PAGE = 0;
    static String phrase;

    public SearchDataSource(){

    }



    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Lyric> callback) {

        Log.e("length","start");

        RetrofitClient.getInstance()
                .getApi()
                .getSearchResults(FIRST_PAGE, PAGE_SIZE,this.phrase)
                .enqueue(new Callback<SearchResult>() {
                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                        Log.e("length",""+response.body().results.size());
                        if(response.body() != null){
                            callback.onResult(response.body().results, null, FIRST_PAGE + 1);
                        }


                    }
                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {
                        Log.e("length",t.getMessage());
                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Lyric> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getSearchResults(params.key, PAGE_SIZE,this.phrase)
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
                .getSearchResults(params.key, PAGE_SIZE,this.phrase)
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
