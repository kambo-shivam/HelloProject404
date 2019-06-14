package com.appventurez.project404.ui.MyLocalRoom;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = LocalDBEntity.class, version = 1)
public abstract class LocalDataBase extends RoomDatabase {
    public abstract DataBaseDao dataBaseDao();
}
