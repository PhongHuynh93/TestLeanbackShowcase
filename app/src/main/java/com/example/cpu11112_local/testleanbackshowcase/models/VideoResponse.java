package com.example.cpu11112_local.testleanbackshowcase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CPU11112-local on 10/19/2017.
 */

public class VideoResponse {
    @SerializedName("googlevideos")
    @Expose
    public List<VideoRow> googlevideos = null;
}
