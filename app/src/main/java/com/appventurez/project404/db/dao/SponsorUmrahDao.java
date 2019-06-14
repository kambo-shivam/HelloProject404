package com.appventurez.project404.db.dao;//package com.drivingschool.db.dao;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import com.deem.labbaik.ui.sponsor.vo.SponsorUmrahListEntity;
//
//import java.util.List;
//
//@Dao
//public interface SponsorUmrahDao {
//
//    @Query("Select * from SponsorUmrahEntity")
//    LiveData<List<SponsorUmrahListEntity>> loadUmrahSponsor();
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void saveUmrahSponsor(List<SponsorUmrahListEntity> respEntities);
//
//    @Query("DELETE FROM SponsorUmrahEntity")
//    void clearUmrahSponsor();
//}
