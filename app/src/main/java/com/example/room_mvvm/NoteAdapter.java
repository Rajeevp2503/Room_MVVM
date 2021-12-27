package com.example.room_mvvm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
private List<note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        note CurrentNote = notes.get(position);

        holder.title.setText(CurrentNote.getTitle());

        Log.e("rajjjj",CurrentNote.getTitle());

        holder.desc.setText(CurrentNote.getDescription());
        holder.Priority.setText(String.valueOf(CurrentNote.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<note>notes){
        this.notes = notes;
        notifyDataSetChanged();
    }


    class NoteHolder extends RecyclerView.ViewHolder{
        TextView title , desc, Priority;
        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_View_title);
            desc = itemView.findViewById(R.id.text_View_desc);
            Priority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
