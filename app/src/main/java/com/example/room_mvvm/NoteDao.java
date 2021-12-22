package com.example.room_mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(note note);
    @Update
    void update(note note);
    @Delete
    void delete(note note);
    //delete all table using query
    @Query("DELETE FROM note_table")
    void  deleteALlNotes();
    //return list of note of all object using query
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<note>>getAllNotes();

}
