package com.example.cpu11112_local.testleanbackshowcase.api;

import android.arch.lifecycle.LiveData;

import com.example.cpu11112_local.testleanbackshowcase.models.VideoRow;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by CPU11112-local on 10/19/2017.
 */

public interface TestApiService {
    // must be livedata because i parse retrofit into livedata.
    @GET("android-tv/android_tv_videos_new.json")
    LiveData<ApiResponse<List<VideoRow>>> getVideoList();

}
