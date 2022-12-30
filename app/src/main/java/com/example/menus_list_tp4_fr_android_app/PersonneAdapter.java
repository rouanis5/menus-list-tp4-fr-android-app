package com.example.menus_list_tp4_fr_android_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonneAdapter extends BaseAdapter {

    ArrayList<Personne> persons;
    Context context;

    public PersonneAdapter(Context context, ArrayList<Personne> persons){
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("my console", "getView is working");
        Personne person = persons.get(i);

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.customitem, null);
        }

        Log.d("my console", "hello world");

        ((TextView) view.findViewById(R.id.name_custom_item)).setText(person.name);
        ((TextView) view.findViewById(R.id.wilaya_custom_item)).setText(person.wilaya);

        ImageView imgView = view.findViewById(R.id.image_custom_item);
        LinearLayout bgView = view.findViewById(R.id.bg_custom_item);

        if (person.gender == Gender.MALE){
            imgView.setImageResource(R.drawable.boy_img);
            bgView.setBackgroundResource(R.color.bg_green);
        } else {
            imgView.setImageResource(R.drawable.girl_img);
            bgView.setBackgroundResource(R.color.bg_pink);
        }

        return view;
    }
}
