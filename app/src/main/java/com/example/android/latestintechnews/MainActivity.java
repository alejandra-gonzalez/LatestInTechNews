package com.example.android.latestintechnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArticleAdapter mAdapter;

    /**
     * Create the MainActivity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This will be swapped out for Loader stuff eventually.
        ArrayList<Article> articles = QueryUtils.extractArticles();

        //This is to set up the RecyclerView.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView articleListView = findViewById(R.id.list);
        articleListView.setLayoutManager(linearLayoutManager);

        //Initialize and set adapter.
        mAdapter = new ArticleAdapter(this, articles);
        articleListView.setAdapter(mAdapter);
    }
}
