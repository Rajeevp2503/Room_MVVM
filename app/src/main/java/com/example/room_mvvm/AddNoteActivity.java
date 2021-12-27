package com.example.room_mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private EditText title, description;
    private NumberPicker numberpicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        title = findViewById(R.id.edit_text_title);
        description = findViewById(R.id.edit_text_description);
        numberpicker = findViewById(R.id.edit_text_number_picker);

        numberpicker.setMinValue(1);
        numberpicker.setMaxValue(15);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String stitle = title.getText().toString();
        String sdescription = description.getText().toString();
        int spriority = numberpicker.getValue();

        if (stitle.trim().isEmpty() || sdescription.trim().isEmpty()) {
            Toast.makeText(this, "please insert a title and desc", Toast.LENGTH_LONG);
            return;
        }
        Intent data = new Intent();
        data.putExtra("TITLE", stitle);
        data.putExtra("DESC", sdescription);
        data.putExtra("PRIORITY", spriority);
        setResult(RESULT_OK, data);
        finish();

    }
}