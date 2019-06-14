package com.appventurez.project404.ui.MyLocalRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class LocalDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;

    LocalDBEntity() {
    }

    @Ignore
    public LocalDBEntity(int position, String name) {
        this.name = name;
        this.id = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
