package com.example.room_mvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
// entity is used to create table in sqlite
@Entity(tableName = "note_table")
public class note {
    @PrimaryKey
private int id;
private  String description;
private  String title;
private int priority;

    public note(String title , String description, int priority) {
        this.description = description;
        this.title = title;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }
}
