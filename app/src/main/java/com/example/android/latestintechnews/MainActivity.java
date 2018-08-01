package com.example.android.latestintechnews;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Article>>{

    private ArticleAdapter mAdapter;
    private static final int ARTICLE_LOADER_ID = 1;
    private static final String GUARDIAN_URL_REQUEST =
            "https://content.guardianapis.com/search?q=technology&order-by=newest&show-tags=contributor&api-key=0bd554a4-e9c9-4ec8-89e3-7b34fb23d284";
    private TextView mEmptyStateTextView;
    private ListView articleListView;
    private ProgressBar mProgressSpinner;

    /**
     * Load the MainActivity, set adapter and onItemClickListener for adapter
     * items, start loader for network request.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI variables.
        articleListView = findViewById(R.id.list);
        mEmptyStateTextView = findViewById(R.id.empty_state);
        mProgressSpinner = findViewById(R.id.loading_spinner);

        // Set empty view.
        articleListView.setEmptyView(mEmptyStateTextView);

        // Initialize and set adapter.
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());
        articleListView.setAdapter(mAdapter);

        // When article is clicked, open a new intent to view the article in a web browser.
        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Article currentArticle = mAdapter.getItem(position);
                Uri articleUri = Uri.parse(currentArticle.getWebUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);

                if (websiteIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(websiteIntent);
                }
            }
        });

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
        mProgressSpinner.setVisibility(View.GONE);
        mAdapter.clear();
        mEmptyStateTextView.setText(R.string.no_results);
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
