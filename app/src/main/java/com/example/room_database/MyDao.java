package com.example.room_database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);
}
