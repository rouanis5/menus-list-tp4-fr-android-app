package com.example.menus_list_tp4_fr_android_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class liste_simple extends AppCompatActivity{
    ArrayList<String> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_simple);

        setTitle(R.string.liste_simple);

        ListView lv = this.findViewById(R.id.mysimplelist);

        // Création et initialisation de tableau
        list.add("Ali"); list.add("Mohamed"); list.add("Amine");

        // Création de l’adaptateur
        setArrayAdapter(lv);

        // associer un menu contextual à listeView
        registerForContextMenu(lv);
    }

     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.context_menu, menu);
     }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ListView lv = findViewById(R.id.mysimplelist);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_simple);

        EditText et = dialog.findViewById(R.id.dialog_edittext);
        Button validBtn = dialog.findViewById(R.id.dialog_valider),
                annulBtn = dialog.findViewById(R.id.dialog_annuler);
        switch (item.getItemId()) {
            case R.id.delete_item:
                list.remove(info.position);
                setArrayAdapter(lv);
                break;
            case R.id.add_item:
                ((TextView) dialog.findViewById(R.id.dialog_title)).setText("nouveau étudiant: ");

                dialog.show();

                validBtn.setOnClickListener(v -> {
                    String name = et.getText().toString();
                    list.add(name);
                    Toast.makeText(this,name+" is added !", Toast.LENGTH_SHORT).show();
                    setArrayAdapter(lv);
                    dialog.dismiss();
                });

                annulBtn.setOnClickListener(v -> {
                    dialog.dismiss();
                });
                break;
            case R.id.edit_item:
                Integer id = Math.toIntExact(info.id);
                String oldName = list.get(id);

                ((TextView) dialog.findViewById(R.id.dialog_title)).setText("edit student "+ oldName);
                et.setText(oldName);

                dialog.show();

                validBtn.setOnClickListener(v -> {
                    String name = et.getText().toString();
                    list.remove(info.position);
                    list.add(id, name);
                    Toast.makeText(this,oldName+" is updated to "+name+" !", Toast.LENGTH_SHORT).show();
                    setArrayAdapter(lv);
                    dialog.dismiss();
                });

                annulBtn.setOnClickListener(v -> {
                    dialog.dismiss();
                });
                break;

            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    void setArrayAdapter(ListView lv) {
         // Associer ListView et l'adaptateur
         ArrayAdapter<String> a = new ArrayAdapter(
                 this, R.layout.simpleitem, R.id.text1, list);
         lv.setAdapter(a);
     }
}
