package com.wasta.api;

import com.wasta.models.category.CategoryResponse;
import com.wasta.models.slider.SliderResponse;
import com.wasta.models.store.TopResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIService {

    @GET("Categories/GetAll")
    Observable<CategoryResponse.GetAll> getAllCategories(@Query("lang") String lang);

    @GET("Slider/Get")
    Observable<SliderResponse.Get> getSliders();

    @GET("Tops/All")
    Observable<TopResponse.All> getTopItems(@Header("AreaID") int areaID);
}
