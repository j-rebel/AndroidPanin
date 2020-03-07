package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class T_221 extends ToolbarActivity {

    private EditText mNoteInput;
    private Button mOkButton;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_221);
        initViews();
        loadNote();
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mNoteInput = findViewById(R.id.noteInput);
        mOkButton = findViewById(R.id.okButton);
        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
        String noteTxt = mNoteInput.getText().toString();
        myEditor.putString(NOTE_TEXT, noteTxt);
        myEditor.apply();
        showMag();
    }

    private void loadNote(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mNoteInput.setText(noteTxt);
    }

    private void showMag() {
        Toast.makeText(T_221.this, getText(R.string.note_saved).toString(), Toast.LENGTH_LONG).show();
    }
}
