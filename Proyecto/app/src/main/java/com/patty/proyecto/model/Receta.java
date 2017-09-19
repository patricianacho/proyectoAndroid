package com.patty.proyecto.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eddy on 15-09-17.
 */

public class Receta {
    private String publisher;
    @SerializedName("f2f_url")
    private String url;
    private String title;
    @SerializedName("source_url")
    private String sourceUrl;
    @SerializedName("recipe_id")
    private String recipeId;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("social_rank")
    private int socialRank;
    @SerializedName("publisher_url")
    private String publisherUrl;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(int socialRank) {
        this.socialRank = socialRank;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        this.publisherUrl = publisherUrl;
    }
}
