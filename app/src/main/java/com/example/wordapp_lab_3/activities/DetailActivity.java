package com.example.wordapp_lab_3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wordapp_lab_3.Adapters.WordAdapter;
import com.example.wordapp_lab_3.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView=findViewById(R.id.recycler_view);
        wordAdapter = new WordAdapter(DetailActivity.this, returnStringList(getResources().getStringArray(R.array.words)));

    }

    public ArrayList<String> returnStringList(String [] wordList)
    {
        return new ArrayList<String>();
    }
}