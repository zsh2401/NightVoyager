package org.nightvoyager.app.exceptions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NvApiException extends Exception {

    private final int statusCode;

    public NvApiException(@NotNull Exception cause){
        this(-1,"",cause);
    }
    public NvApiException(@NotNull String message, @Nullable Exception cause){
        this(-1,message,cause);
    }
    public NvApiException(@NotNull String message){
        this(-1,message,null);
    }
    public NvApiException(int statusCode, @NotNull String message, @Nullable Exception cause){
        super(message,cause);
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
}
