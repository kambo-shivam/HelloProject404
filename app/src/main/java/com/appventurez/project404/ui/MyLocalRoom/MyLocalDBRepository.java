package com.appventurez.project404.ui.MyLocalRoom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class MyLocalDBRepository {
    private String DB_NAME = "db_local_task";

    private LocalDataBase localDataBase;
    private LiveData<List<LocalDBEntity>> listLiveData;

    public MyLocalDBRepository(Context context) {
        localDataBase = Room.databaseBuilder(context, LocalDataBase.class, DB_NAME).build();
        listLiveData = localDataBase.dataBaseDao().getAllName();
    }

    LiveData<List<LocalDBEntity>> getListLiveData() {
        return listLiveData;
    }


    void insertEntityData(LocalDBEntity entity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                localDataBase.dataBaseDao().insert(entity);
                return null;
            }
        }.execute();
    }

    public void deleteAll() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                localDataBase.dataBaseDao().deleteAll();
                return null;
            }
        }.execute();
    }

    public void updateList(LocalDBEntity entity) {
        new AsyncTask<LocalDBEntity, Void, Void>() {
            @Override
            protected Void doInBackground(LocalDBEntity... localDBEntities) {
                localDataBase.dataBaseDao().updateList(localDBEntities[0]);
                return null;
            }
        }.execute(entity);
    }

    public void delexte(LocalDBEntity entity) {
        new AsyncTask<LocalDBEntity, Void, Void>() {
            @Override
            protected Void doInBackground(LocalDBEntity... localDBEntities) {
                localDataBase.dataBaseDao().deleteWord(localDBEntities[0]);
                return null;
            }
        }.execute(entity);
    }
}
