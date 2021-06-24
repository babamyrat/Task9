package com.example.task9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
         EditText name, email;
         Button save, fetch, remove, clear;
         String Name = "Name Key"; String Email = "Email Key";
         SharedPreferences sp; SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name); email = findViewById(R.id.email);
        save = findViewById(R.id.save); fetch = findViewById(R.id.fetch);
        remove = findViewById(R.id.remove); clear = findViewById(R.id.clear);

        sp = getSharedPreferences("sdfasdfasd", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed = sp.edit();
                ed.putString(Name, name.getText().toString());
                ed.putString(Email, email.getText().toString());
                ed.apply();
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.contains(Name))
                    name.setText(sp.getString(Name, ""));
                if (sp.contains(Email))
                    email.setText(sp.getString(Email, ""));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(""); email.setText("");
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.remove(Name); ed.remove(Email);
                ed.apply();
            }
        });
    }
}