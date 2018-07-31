package com.example.android.latestintechnews;

import java.util.List;
import android.content.AsyncTaskLoader;
import android.content.Context;

public class ArticleLoader extends AsyncTaskLoader<List<Article>>{

    //API URL to perform a GET request on
    private String mUrl;

    /**
     * Constructor for the loader.
     */
    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * Performs a network request to an API, parses and returns the response.
     */
    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        return QueryUtils.fetchArticleData(mUrl);
    }
}
