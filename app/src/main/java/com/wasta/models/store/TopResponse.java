package com.wasta.models.store;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wasta.api.Response;

import java.util.List;

public class TopResponse {
    public static class All extends Response {

        @Expose
        @SerializedName("Data")
        private List<TopItems> topItems;

        public List<TopItems> getTopItems() {
            return topItems;
        }

        public void setTopItems(List<TopItems> topItems) {
            this.topItems = topItems;
        }
    }
}
