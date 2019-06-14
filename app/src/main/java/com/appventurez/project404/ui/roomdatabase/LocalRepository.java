package com.appventurez.project404.ui.roomdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.appventurez.project404.db.MyRoomDataBase;
import com.appventurez.project404.db.dao.MyEntity;

import java.util.List;

public class LocalRepository {
    private String DB_NAME = "db_task";

    private MyRoomDataBase noteDatabase;

    public LocalRepository(Context context) {
        noteDatabase = Room.databaseBuilder(context, MyRoomDataBase.class, DB_NAME).build();
    }

    public void insertTask(String name) {
        insertTask(name, "");
    }

    public void insertTask(String name, String value) {
        MyEntity entity = new MyEntity();
        entity.setName(name);
        entity.setTime(value);
        insertTask(entity);
    }

    private void insertTask(MyEntity entity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.myDao().insertTask(entity);
                return null;
            }
        }.execute();
    }

    public void deleteTask() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.myDao().deleteTask();
                return null;
            }
        }.execute();
    }


    public LiveData<MyEntity> getTask(int id) {
        return noteDatabase.myDao().getTask(id);
    }

    public LiveData<List<MyEntity>> getTasks() {
        return noteDatabase.myDao().fetchAllTasks();
    }


    public void update(MyEntity entity) {
        new AsyncTask<MyEntity, Void, Void>() {
            @Override
            protected Void doInBackground(MyEntity... myEntities) {
                noteDatabase.myDao().updateTask(myEntities[0]);
                return null;
            }
        }.execute(entity);
    }
}
