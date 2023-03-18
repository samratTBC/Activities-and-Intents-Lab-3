package com.example.wordapp_lab_3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordapp_lab_3.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return ViewHolder in which the data source, here the list, is to be attatched.
     */
    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(this.context==null)
            this.context=parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        //holder.bindData(list, position);
        holder.btn.setText(list.get(position).toString());
        holder.btn.setOnClickListener(holder.btnOnclickListener);
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
        ArrayList<String> randomList = new ArrayList<String>();
        Random random = new Random();
        int randomNumber;

        /**
         * Check all the words that is of the same letter and store it in a list.
         */
        for(int i=0; i<list.size(); i++)
        {
            Log.d("TAG", "word: " + list.get(i));
            if(list.get(i).charAt(0)==provided_letter.toLowerCase().charAt(0))
                sortedList.add(list.get(i));
        }


        int count =0;

        /**
         * Select only 5 words for the recyclerView.
         */
        while(count!=5)
        {
            randomNumber = random.nextInt(sortedList.size());
            if(!randomList.contains(sortedList.get(randomNumber))) {
                randomList.add(sortedList.get(randomNumber));
                count++;
            }
        }
        return randomList;
    }

    /**
     * ViewHolder class which is to be inflated in the recylcerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private Button btn;
        private View view;

        public static final String googleURL ="https://www.google.com/search?q=";
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
            btn = itemView.findViewById(R.id.button_item);
        }

        /**
         * On click Listener set for the button for each of the word.
         */
        View.OnClickListener btnOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.button_item)
                {
                    /**
                     *Intent provided to access the browser, to open the url resources.
                     */
                    String website_url = googleURL + btn.getText().toString();
                    Uri web_uri = Uri.parse(website_url);

                    Intent webBasedIntent = new Intent(Intent.ACTION_VIEW, web_uri);
                    view.getContext().startActivity(webBasedIntent);

                }


            }
        };

        /**
         *
         * @param list
         * @param position
         * Function for binding data that is called from the recycler view adapter that binds the
         * view-holder with the data source, here it is the list.
         */
        private void bindData(List list, int position)
        {
            this.btn.setText(list.get(position).toString());
        }

    }

}
