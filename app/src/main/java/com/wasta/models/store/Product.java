package com.wasta.models.store;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @Expose
    @Nullable
    @SerializedName("extras")
    private Object extras;

    @Expose
    @SerializedName("ProductId")
    private int id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("IsMultipleSize")
    private boolean isMultipleSize;


    @Expose
    @SerializedName("Description")
    private String description;

    @Expose
    @SerializedName("SingleOriginalPrice")
    private String singleOriginalPrice;

    @Expose
    @SerializedName("SingleOfferPrice")
    private String singleOfferPrice;

    @Expose
    @SerializedName("StoreId")
    private int storeId;

    @Expose
    @SerializedName("StoreName")
    private String storeName;

    @Expose
    @SerializedName("Images")
    private List<String> images;

    @Expose
    @SerializedName("ImagesProduct")
    private List<String> imagesProduct;

    @Expose
    @SerializedName("Sizes")
    private List<Integer> sizes;

    @Expose
    @SerializedName("OptionModifiers")
    private List<Object> optionModifiers;

    @Expose
    @SerializedName("CatId")
    private int categoryId;

    @Expose
    @SerializedName("isFav")
    private boolean isFavorite;

    @Nullable
    public Object getExtras() {
        return extras;
    }

    public void setExtras(@Nullable Object extras) {
        this.extras = extras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMultipleSize() {
        return isMultipleSize;
    }

    public void setMultipleSize(boolean multipleSize) {
        isMultipleSize = multipleSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSingleOfferPrice() {
        return singleOfferPrice;
    }

    public void setSingleOfferPrice(String singleOfferPrice) {
        this.singleOfferPrice = singleOfferPrice;
    }

    public String getSingleOriginalPrice() {
        return singleOriginalPrice;
    }

    public void setSingleOriginalPrice(String singleOriginalPrice) {
        this.singleOriginalPrice = singleOriginalPrice;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    public List<Object> getOptionModifiers() {
        return optionModifiers;
    }

    public void setOptionModifiers(List<Object> optionModifiers) {
        this.optionModifiers = optionModifiers;
    }

    public List<String> getImagesProduct() {
        return imagesProduct;
    }

    public void setImagesProduct(List<String> imagesProduct) {
        this.imagesProduct = imagesProduct;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "extras=" + extras +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", isMultipleSize=" + isMultipleSize +
                ", description='" + description + '\'' +
                ", singleOriginalPrice='" + singleOriginalPrice + '\'' +
                ", singleOfferPrice='" + singleOfferPrice + '\'' +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", images=" + images +
                ", imagesProduct=" + imagesProduct +
                ", sizes=" + sizes +
                ", optionModifiers=" + optionModifiers +
                ", categoryId=" + categoryId +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
