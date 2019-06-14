package com.appventurez.project404.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.appventurez.project404.db.dao.MyDao;
import com.appventurez.project404.db.dao.MyEntity;

@Database(entities = {MyEntity.class}, version = 1, exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {
    public abstract MyDao myDao();
}
