package com.example.wordapp_lab_3.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.wordapp_lab_3.Adapters.LetterAdapter;
import com.example.wordapp_lab_3.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LetterAdapter letterAdapter;

    private Boolean isGridLayoutManager = true;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        setRecyclerView();

        setTitle("Letter App");

    }


    private void setRecyclerView()
    {
        if(isGridLayoutManager)
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView.setAdapter(new LetterAdapter());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu, menu);
        setIcon(menu.findItem(R.id.action_switch_layout));
        return true;

    }

    public void setIcon(MenuItem menuItem)
    {
        if(menuItem != null)
            menuItem.setIcon(
                    isGridLayoutManager? ContextCompat.getDrawable(this,R.drawable.vertical_distribute)
                            :ContextCompat.getDrawable(this,R.drawable.grid_drawable)
            );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_switch_layout)
        {
            isGridLayoutManager = !isGridLayoutManager;
            setRecyclerView();
            setIcon(item);
            return true;
        }
        else
            return super.onOptionsItemSelected(item);

    }
}