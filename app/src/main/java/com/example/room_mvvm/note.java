package com.example.room_mvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
// entity is used to create table in sqlite
@Entity(tableName = "note_table")
public class note {
    @PrimaryKey(autoGenerate = true)
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
