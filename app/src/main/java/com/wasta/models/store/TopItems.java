package com.wasta.models.store;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wasta.models.slider.Slider;

import java.util.List;

public class TopItems {

    @Expose
    @SerializedName("type")
    private int type;

    @Expose
    @SerializedName("NameAr")
    private String arabic;

    @Expose
    @SerializedName("NameEn")
    private String english;

    @Expose
    @Nullable
    @SerializedName("StoreList")
    private List<Store> stores;

    @Expose
    @Nullable
    @SerializedName("ListOfProducts")
    private List<Product> products;

    @Expose
    @Nullable
    @SerializedName("SlidersList")
    private List<Slider> sliders;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Nullable
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(@Nullable List<Product> products) {
        this.products = products;
    }

    @Nullable
    public List<Store> getStores() {
        return stores;
    }

    public void setStores(@Nullable List<Store> stores) {
        this.stores = stores;
    }

    @Nullable
    public List<Slider> getSliders() {
        return sliders;
    }

    public void setSliders(@Nullable List<Slider> sliders) {
        this.sliders = sliders;
    }
}
