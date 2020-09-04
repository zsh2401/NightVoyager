package org.nightvoyager.app.style;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestfulResult<T> {

    private final int statusCode;
    private final String statusMessage;
    private final T result;

    public RestfulResult(int statusCode, String statusMessage, T result) {
        this.statusCode = statusCode;
        this.result = result;
        this.statusMessage = statusMessage;
    }
    public RestfulResult(int statusCode,T result){
        this(statusCode,"",result);
    }
    public RestfulResult(T result){
        this(0,"",result);
    }

    @JsonProperty("statusCode")
    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    @JsonProperty("result")
    public T getResult() {
        return result;
    }
}
