package com.wasta.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @Expose
    @SerializedName("ErrorCode")
    private ErrorCode code;

    @Expose
    @SerializedName("ErrorMessage")
    private String message;

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
