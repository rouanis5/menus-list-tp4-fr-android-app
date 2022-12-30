package com.example.menus_list_tp4_fr_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class liste_personnalisee extends AppCompatActivity {
    ArrayList<Personne> personsList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_personnalisee);

        setTitle(R.string.liste_personnalisee);

        ListView lv = this.findViewById(R.id.myCustomlist);

        // Création et initialisation de tableau
        personsList.add(new Personne("ali", "alger", Gender.MALE));
        personsList.add(new Personne("aomar", "tizi ouzou", Gender.MALE));
        personsList.add(new Personne("karima", "boumerdes", Gender.FEMALE));

        // Création de l’adaptateur
        setArrayAdapter(lv);
        // associer un menu contextual à listeView
//        registerForContextMenu(lv);
    }

    void setArrayAdapter(ListView lv) {
        // Associer ListView et l'adaptateur
        PersonneAdapter a = new PersonneAdapter(this, personsList);
        lv.setAdapter(a);
        Log.d("my console", "setArrayAdapter: ");
    }
}