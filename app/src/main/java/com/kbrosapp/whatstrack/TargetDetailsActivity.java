package com.kbrosapp.whatstrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class TargetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_details);

        //INTENTS
        String nameOfTheClickedTarget=getIntent().getExtras().getString("NameOfTheClickedTarget");
        String idOfTheClickedTarget=getIntent().getExtras().getString("IdOfTheClickedTarget");

        //FOR TOOLBAR
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(nameOfTheClickedTarget);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}