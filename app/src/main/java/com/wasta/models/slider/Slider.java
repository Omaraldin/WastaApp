package com.wasta.models.slider;

/* POJO */

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slider {

    @Expose
    @SerializedName("ID")
    private int id;

    @Expose
    @SerializedName("Image")
    private String image;

    @Expose
    @SerializedName("StoreID")
    private int storeId;

    @Expose
    @SerializedName("SortingNumber")
    private int sortingNUmber;

    @Expose
    @SerializedName("storeName")
    private String storeName;

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

    public int getSortingNUmber() {
        return sortingNUmber;
    }

    public void setSortingNumber(int sortingNUmber) {
        this.sortingNUmber = sortingNUmber;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @NonNull
    @Override
    public String toString() {
        return "SliderBanner{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", storeId=" + storeId +
                ", sortingNUmber=" + sortingNUmber +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
