package com.patty.proyecto.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eddy on 17-09-17.
 */

public class Ingredientes {
    private String publisher;
    @SerializedName("f2f_url")
    private String f2furl;
    private List<String> ingredients;
    @SerializedName("source_url")
    private String sourceUrl;
    @SerializedName("recipe_id")
    private String recipeId;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("social_rank")
    private float socialRank;
    @SerializedName("publisher_url")
    private String publisherUrl;
    private String title;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2furl() {
        return f2furl;
    }

    public void setF2furl(String f2furl) {
        this.f2furl = f2furl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
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

    public float getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(float socialRank) {
        this.socialRank = socialRank;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        this.publisherUrl = publisherUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
