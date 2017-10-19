package com.example.cpu11112_local.testleanbackshowcase.db;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by CPU11112-local on 10/19/2017.
 */
//@Database(entities = {User.class, Repo.class, Contributor.class,
//        RepoSearchResult.class}, version = 3)
public abstract class GithubDb extends RoomDatabase {
    // can supply as much Dao as you want
    abstract public VideoDao userDao();
}
