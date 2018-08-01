package com.example.android.latestintechnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ArticleAdapter extends ArrayAdapter<Article> {
    /**
     * Constructor for the adapter.
     */
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Formats a String in DateTime format and returns its MMM DD, YYYY format as a String.
     */
    private String formatDate(String dateString) {
        Date articleDate = null;
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        try {
            articleDate = spf.parse(dateString);
        } catch (ParseException pe){
            pe.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(articleDate);
    }

    /**
     * Returns the view for the current article.
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ArticleViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            holder = new ArticleViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ArticleViewHolder) convertView.getTag();
        }

        Article currentArticle = getItem(position);
        holder.titleTextView.setText(currentArticle.getTitle());
        holder.sectionTextView.setText(currentArticle.getSection());
        holder.contributorTextView.setText(currentArticle.getContributor());
        holder.publishDateTextView.setText(formatDate(currentArticle.getPublishedDate()));

        return convertView;
    }

    /**
     * Inner class for the Article ViewHolder
     */
    static class ArticleViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView contributorTextView;
        private TextView publishDateTextView;

        public ArticleViewHolder (View v) {
            titleTextView = v.findViewById(R.id.title);
            sectionTextView = v.findViewById(R.id.section);
            contributorTextView = v.findViewById(R.id.contributor);
            publishDateTextView = v.findViewById(R.id.date);
        }
    }
}
