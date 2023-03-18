package com.example.wordapp_lab_3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordapp_lab_3.R;
import com.example.wordapp_lab_3.activities.DetailActivity;

import java.util.ArrayList;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.ViewHolder> {

    /**
     * Adapter fields and methods.
     */
    private ArrayList<Character> list;
    private Context context;
    public LetterAdapter()
    {
        this.list=provideList();
    }

    @NonNull
    @Override
    public LetterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(this.context==null)
            this.context=parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterAdapter.ViewHolder holder, int position) {
        holder.button.setText(list.get(position).toString());
        holder.button.setOnClickListener(holder.buttonListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * View-Holder class which contains the button that is to be inflated in the parent layout.
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Button button;

        private final String LETTER ="LETTER";
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(LETTER,button.getText().toString());
                view.getContext().startActivity(intent);
            }
        };
    }

    /**
     *
     * @return List of Character to be shown in the button view.
     */

    private ArrayList<Character> provideList()
    {
        ArrayList<Character> list = new ArrayList<Character>();
        for(char first_char ='A' ; first_char <='Z'; first_char++)
            list.add(first_char);
        return list;
    }
}
