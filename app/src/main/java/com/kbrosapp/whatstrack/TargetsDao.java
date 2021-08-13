package com.kbrosapp.whatstrack;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TargetsDao {
    @Insert
    void insert(Target target);

    @Update
    void update(Target target);

    @Delete
    void delete(Target target);

    @Query("SELECT * FROM Target ORDER BY Target_Id")
    LiveData<List<Target>> getAllTargets();
}
