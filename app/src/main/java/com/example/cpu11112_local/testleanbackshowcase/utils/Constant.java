package com.example.cpu11112_local.testleanbackshowcase.utils;

import android.support.v17.leanback.widget.FocusHighlight;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class Constant {

    public static final String ROW_NOT_SHADOW = "ROW_NOT_SHADOW";
    public static final String ROW_SHADOW = "ROW_SHADOW";
    public static final String BIG_ADAPTER = "BIG_ADAPTER";
    public static final String ACTION_ADAPTER = "ACTION_ADAPTER";
    public static final String RELATED_ITEM_ADAPTER = "RELATED_ITEM_ADAPTER";

    // page
    public static final long HEADER_ID_1 = 1;
    public static final String HEADER_NAME_1 = "Page Fragment";
    public static final long HEADER_ID_2 = 2;
    public static final String HEADER_NAME_2 = "Rows Fragment";
    public static final long HEADER_ID_3 = 3;
    public static final String HEADER_NAME_3 = "Settings Fragment";
    public static final long HEADER_ID_4 = 4;
    public static final String HEADER_NAME_4 = "User agreement Fragment";

    public static final String PAGE_1 = "PAGE_1";
    public static final String PAGE_2 = "PAGE_2";
    public static final String PAGE_3 = "PAGE_3";
    public static final String PAGE_4 = "PAGE_4";

    // grid
   public static final int ZOOM_FACTOR = FocusHighlight.ZOOM_FACTOR_MEDIUM;
   public static final int COLUMNS = 4;

    // retrofit
    public static final int CONNECT_TIMEOUT = 15;
    public static final int WRITE_TIMEOUT = 60;
    public static final int TIMEOUT = 60;
    public static final String CACHE_DIR = "HttpResponseCache";
    public static final long CACHE_SIZE = 10 * 1024 * 1024;    // 10 MB

}
