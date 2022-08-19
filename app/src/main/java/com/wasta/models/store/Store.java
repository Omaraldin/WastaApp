package com.wasta.models.store;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Store {

    @Expose
    @SerializedName("Id")
    private int id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("ImageUrl")
    private String image;

    @Expose
    @SerializedName("Description")
    private String description;

    @Expose
    @SerializedName("IsOpen")
    private boolean isOpen;

    @Expose
    @Nullable
    @SerializedName("Rate")
    private Object rate;

    @Expose
    @Nullable
    @SerializedName("Distance")
    private Object distance;

    @Expose
    @Nullable
    @SerializedName("SliderImages")
    private List<String> sliders;

    @Expose
    @SerializedName("isFav")
    private boolean isFavorite;

    @Expose
    @Nullable
    @SerializedName("subCatDTO")
    private Object subCategory;

    @Expose
    @Nullable
    @SerializedName("cardcheck")
    private Object cardCheck;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public List<String> getSliders() {
        return sliders;
    }

    public void setSliders(@Nullable List<String> sliders) {
        this.sliders = sliders;
    }

    @Nullable
    public Object getCardCheck() {
        return cardCheck;
    }

    public void setCardCheck(@Nullable Object cardCheck) {
        this.cardCheck = cardCheck;
    }

    @Nullable
    public Object getDistance() {
        return distance;
    }

    public void setDistance(@Nullable Object distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public Object getRate() {
        return rate;
    }

    public void setRate(@Nullable Object rate) {
        this.rate = rate;
    }

    @Nullable
    public Object getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(@Nullable Object subCategory) {
        this.subCategory = subCategory;
    }


    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @NonNull
    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", isOpen=" + isOpen +
                ", rate=" + rate +
                ", distance=" + distance +
                ", sliders=" + sliders +
                ", isFavorite=" + isFavorite +
                ", subCategory=" + subCategory +
                ", cardCheck=" + cardCheck +
                '}';
    }
}
