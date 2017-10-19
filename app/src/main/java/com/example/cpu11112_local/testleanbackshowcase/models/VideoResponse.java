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
    public List<Googlevideo> googlevideos = null;

    public class Googlevideo {
        @SerializedName("category")
        @Expose
        public String category;
        @SerializedName("videos")
        @Expose
        public List<Video> videos = null;
    }

    public class Video {
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("sources")
        @Expose
        public List<String> sources = null;
        @SerializedName("card")
        @Expose
        public String card;
        @SerializedName("background")
        @Expose
        public String background;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("studio")
        @Expose
        public String studio;
    }
}
