package com.example.room_mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.security.PrivateKey;
import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<note>> allNotes;

    public  NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }
    public void insert(note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void update(note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public void delete(note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }
    public void deleteAllNotes(){
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public  LiveData<List<note>>getAllNotes(){
         return allNotes;
    }
    private static  class InsertNoteAsyncTask extends AsyncTask<note,Void,Void>{
        private  NoteDao noteDao;
        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(note... notes) {
           noteDao.insert(notes[0]);
           return null;
        }
    }


    private static  class UpdateNoteAsyncTask extends AsyncTask<note,Void,Void>{
        private  NoteDao noteDao;
        private UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static  class DeleteNoteAsyncTask extends AsyncTask<note,Void,Void>{
        private  NoteDao noteDao;
        private DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

// delete all nodes async task using interface

    private static  class DeleteAllNotesAsyncTask extends AsyncTask<note,Void,Void>{
        private  NoteDao noteDao;
        private DeleteAllNotesAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            noteDao.deleteALlNotes();
            return null;
        }
    }
}
