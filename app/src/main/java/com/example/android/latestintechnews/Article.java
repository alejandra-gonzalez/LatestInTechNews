package com.example.android.latestintechnews;

public class Article {

    private String title;
    private String section;
    private String webUrl;
    private String contributor;
    private String publishedDate;

    /**
     * Constructor for a Article object.
     */
    public Article(String articleTitle, String articleSection, String articleWebUrl, String
            articleContributor, String articlePublishedDate) {
        title = articleTitle;
        section = articleSection;
        webUrl = articleWebUrl;
        contributor = articleContributor;
        publishedDate = articlePublishedDate;
    }

    /**
     * The rest of the methods in this file are getter methods for the private field variables of
     * this class.
     */
    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getContributor() {
        return contributor;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}
