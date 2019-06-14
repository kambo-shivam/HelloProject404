package com.appventurez.project404.ui.MyLocalRoom;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DataBaseDao {

    @Insert(onConflict = REPLACE)
    void insert(LocalDBEntity entity);

    @Query("SELECT * FROM LocalDBEntity")
    LiveData<List<LocalDBEntity>> getAllName();

    @Query("DELETE FROM LocalDBEntity")
    void deleteAll();

    @Update
    void updateList(LocalDBEntity... localDBEntities);


    @Delete
    void deleteWord(LocalDBEntity... localDBEntities);

}
