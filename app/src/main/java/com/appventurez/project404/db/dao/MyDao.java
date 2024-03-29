package com.appventurez.project404.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MyDao {

    @Insert(onConflict = REPLACE)
    Long insertTask(MyEntity MyEntity);

    //@Query("SELECT * FROM MyEntity)
    @Query("SELECT * FROM MyEntity")
    LiveData<List<MyEntity>> fetchAllTasks();


    @Query("SELECT * FROM MyEntity WHERE id =:taskId")
    LiveData<MyEntity> getTask(int taskId);


    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateTask(MyEntity... MyEntity);


    @Query("DELETE FROM MyEntity")
    void deleteTask();

}
