package com.example.wordapp_lab_3.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.wordapp_lab_3.Adapters.WordAdapter;
import com.example.wordapp_lab_3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView letterRecyclerView;
    private WordAdapter wordAdapter;

    public static final String TAG ="DETAIL_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        letterRecyclerView=findViewById(R.id.recycler_view);

        Log.d(TAG, "onCreate: I'm In");
        wordAdapter = new WordAdapter(this, getIntent().getStringExtra("LETTER"));

        letterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        letterRecyclerView.setAdapter(wordAdapter);
        setTitle("Words with the letter : " + getIntent().getStringExtra("LETTER"));

    }






}