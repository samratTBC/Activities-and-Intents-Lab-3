package com.example.wordapp_lab_3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.wordapp_lab_3.Adapters.LetterAdapter;
import com.example.wordapp_lab_3.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LetterAdapter letterAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        letterAdapter = new LetterAdapter(MainActivity.this, provideList());
        recyclerView.setAdapter(letterAdapter);

    }

    public ArrayList<Character> provideList()
    {
        ArrayList<Character> list = new ArrayList<Character>();
        for(char first_char ='A' ; first_char <='Z'; first_char++)
        {
            list.add(first_char);
            Log.d("TAG", "provideList: " + Character.toString(first_char));
        }

        return list;
    }
}