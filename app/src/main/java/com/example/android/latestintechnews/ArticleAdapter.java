package com.example.android.latestintechnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private ArrayList<Article> articles;


    /**
     * Constructor for the adapter.
     */
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        this.layoutInflater = LayoutInflater.from(context);
        this.articles = articles;
    }

    /**
     * Inflates the view and creates its ViewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Finds the current article in the arraylist, and binds the article's data with the ViewHolder
     * created for the article.
     */
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        final Article currentArticle = articles.get(position);

        viewHolder.titleTextView.setText(currentArticle.getTitle());
        viewHolder.sectionTextView.setText(currentArticle.getSection());
        viewHolder.contributorTextView.setText(currentArticle.getContributor());

        //Format the date from DateTime format to MMM DD, YYYY before binding to TextView
        String date = formatDate(currentArticle.getPublishedDate());
        viewHolder.publishDateTextView.setText(date);
    }

    /**
     * Returns size of the Article ArrayList.
     */
    @Override
    public int getItemCount() {
        return articles.size();
    }

    /**
     * Inner class for the Article ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView contributorTextView;
        private TextView publishDateTextView;

        public ViewHolder (View v) {
            super(v);
            titleTextView = v.findViewById(R.id.title);
            sectionTextView = v.findViewById(R.id.section);
            contributorTextView = v.findViewById(R.id.contributor);
            publishDateTextView = v.findViewById(R.id.date);
        }
    }

    /**
     * Formats a String in DateTime format and returns its MMM DD, YYYY format as a String.
     */
    private String formatDate(String dateString) {
        Date articleDate = null;
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            articleDate = spf.parse(dateString);
        } catch (ParseException pe){
            pe.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(articleDate);
    }

}
