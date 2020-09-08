package org.nightvoyager.app.exceptions;

import org.jetbrains.annotations.NotNull;

public class PasswordException extends NvApiException {
    public PasswordException() {
        super("Password is not correct!");
    }
}
