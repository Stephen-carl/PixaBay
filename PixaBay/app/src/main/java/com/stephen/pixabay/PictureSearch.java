package com.stephen.pixabay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PictureSearch extends AppCompatActivity {

    Button button;
    EditText editText;
    String theText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_search);

        button = findViewById(R.id.butt);
        editText = findViewById(R.id.et_enterPet);

        button.setOnClickListener(view -> {
            theText = editText.getText().toString().trim();
            Intent intent = new Intent(this, MainActivity.class);
            //take the entered text into the next activity
            intent.putExtra("imageText", theText);
            startActivity(intent);
        });

    }
}