package io.bridgelabz.codinclub.api;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName(value = "message")
    private String message;

    @SerializedName(value = "data")
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
