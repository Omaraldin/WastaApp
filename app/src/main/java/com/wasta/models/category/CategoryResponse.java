package com.wasta.models.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wasta.api.Response;

import java.util.List;

public class CategoryResponse {

    public static class GetAll extends Response {

        @Expose
        @SerializedName("Data")
        private List<Category> data;

        public List<Category> getData() {
            return data;
        }

        public void setData(List<Category> data) {
            this.data = data;
        }

    }

}
