package org.nightvoyager.app.exceptions;

import org.jetbrains.annotations.NotNull;

public class AccountNotFoundException extends NvApiException {
    public AccountNotFoundException() {
        super("Account not found!");
    }
}
