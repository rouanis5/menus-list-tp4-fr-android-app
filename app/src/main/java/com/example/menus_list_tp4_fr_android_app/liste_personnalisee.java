package com.example.menus_list_tp4_fr_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class liste_personnalisee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_personnalisee);

        setTitle(R.string.liste_personnalisee);
    }
}