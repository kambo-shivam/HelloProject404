package com.appventurez.project404.ui.MyLocalRoom;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.appventurez.project404.common.base.BaseViewModel;

import java.util.List;

public class DataBaseVM extends BaseViewModel {
    private MyLocalDBRepository repository;
    LiveData<List<LocalDBEntity>> listLiveData;

    public DataBaseVM(@NonNull Application application) {
        super(application);
        repository = new MyLocalDBRepository(getApplication());
        listLiveData = repository.getListLiveData();
    }

    LiveData<List<LocalDBEntity>> getListLiveData() {
        return listLiveData;
    }

    public void insertName(LocalDBEntity entity) {
        repository.insertEntityData(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void updateList(LocalDBEntity entity) {
        repository.updateList(entity);
    }



    public void deleteWord(LocalDBEntity entity) {
        repository.delexte(entity);
    }
}
