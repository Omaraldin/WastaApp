package com.wasta.models.slider;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wasta.api.Response;
import com.wasta.models.category.Category;

import java.util.List;
import java.util.Map;

public class SliderResponse extends Response {

    public static class Get extends Response {
        @Expose
        @SerializedName("Data")
        private Map<String, List<Slider>> data;

        public Map<String, List<Slider>> getData() {
            return data;
        }

        public void setData(Map<String, List<Slider>> data) {
            this.data = data;
        }
    }

}
