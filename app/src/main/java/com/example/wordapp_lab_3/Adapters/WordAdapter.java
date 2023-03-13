package com.example.wordapp_lab_3.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordapp_lab_3.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public WordAdapter(Context context, String selected_letter)
    {
        this.context=context;
        Log.d("TAG", "WordAdapter: " + selected_letter);
        this.list=LetterWordList(context, selected_letter);
        Log.d("TAG", "List: " + list.size()) ;
    }
    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        //holder.bindData(list, position);
        holder.btn.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ArrayList<String> LetterWordList(Context context, String provided_letter)
    {
        List<String> list = Arrays.asList(context.getResources().getStringArray(R.array.words));
        Log.d("Banana", "LetterWordList: " + provided_letter);
        ArrayList<String> sortedList = new ArrayList<String>();

        for(int i=0; i<list.size(); i++)
        {
            Log.d("TAG", "word: " + list.get(i));
            if(list.get(i).charAt(0)==provided_letter.toLowerCase().charAt(0))
                sortedList.add(list.get(i));
        }

        Log.d("TAG", "final wordlist: " + sortedList.toString());
        return sortedList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private Button btn;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
            btn = itemView.findViewById(R.id.button_item);
        }

        private void bindData(List list, int position)
        {
            this.btn.setText(list.get(position).toString());
        }

    }

}
