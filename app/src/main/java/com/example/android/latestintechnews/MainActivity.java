package com.example.android.latestintechnews;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Article>>{

    private ArticleAdapter mAdapter;
    private static final int ARTICLE_LOADER_ID = 1;
    private static final String GUARDIAN_URL_REQUEST =
            "https://content.guardianapis.com/search?q=technology&order-by=newest&show-tags=contributor&api-key=0bd554a4-e9c9-4ec8-89e3-7b34fb23d284";

    /**
     * Create the MainActivity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is to set up the RecyclerView.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView articleListView = findViewById(R.id.list);
        articleListView.setLayoutManager(linearLayoutManager);

        //Initialize and set adapter.
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());
        articleListView.setAdapter(mAdapter);

        //Start the loader.
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
    }

    /**
     * Creates a new loader instance for the specified URL.
     */
    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {
        return new ArticleLoader(this, GUARDIAN_URL_REQUEST);
    }

    /**
     * Adds data to the adapter once the loader finishes its work.
     */
    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articles) {
        mAdapter.clear();

        if (articles != null && !articles.isEmpty()) {
            mAdapter.addAll(articles);
        }
    }

    /**
     * Clear data when the loader resets.
     */
    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        mAdapter.clear();
    }
}
