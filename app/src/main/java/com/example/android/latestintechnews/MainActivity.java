package com.example.android.latestintechnews;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Article>>{

    private ArticleAdapter adapter;
    private TextView emptyState;
    private ProgressBar progressBar;
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

        // Initialize variables for empty state and progress bar.
        emptyState = findViewById(R.id.empty_state);
        progressBar = findViewById(R.id.loading_spinner);

        // Check for Internet connection.
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            // Let user know if they are not connected to the internet.
            progressBar.setVisibility(View.GONE);
            emptyState.setText(R.string.no_internet);
        } else {
            // This is to set up the RecyclerView.
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            RecyclerView articleListView = findViewById(R.id.list);
            articleListView.setLayoutManager(linearLayoutManager);

            // Initialize and set adapter.
            adapter = new ArticleAdapter(this, new ArrayList<Article>());
            articleListView.setAdapter(adapter);

            // Start the loader.
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        }

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
        progressBar.setVisibility(View.GONE);
        adapter.clear();

        // If there are articles to display, add them to the adapter and display them.
        if (articles != null && !articles.isEmpty()) {
            adapter.addAll(articles);
            adapter.notifyDataSetChanged();
        }

        // If the adapter is empty, display "no results" string.
        if (adapter.getItemCount() == 0){
            emptyState.setText(R.string.no_results);
        }
    }

    /**
     * Clear data when the loader resets.
     */
    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        adapter.clear();
    }
}
