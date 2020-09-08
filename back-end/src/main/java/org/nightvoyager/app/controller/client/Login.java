package org.nightvoyager.app.controller.client;

import org.nightvoyager.app.entity.PersonInfo;
import org.nightvoyager.app.exceptions.AccountNotFoundException;
import org.nightvoyager.app.exceptions.NvApiException;
import org.nightvoyager.app.exceptions.PasswordException;
import org.nightvoyager.app.service.IAutoAccountFinder;
import org.nightvoyager.app.service.ITokenManager;
import org.nightvoyager.core.security.MissingPermissionException;
import org.nightvoyager.core.security.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("login")
public class Login {
    @Autowired
    private IAutoAccountFinder finder;

    @Autowired
    private ITokenManager tokenManager;

    @PostMapping
    public Object doLogin(@RequestParam String account, @RequestParam String passwd) throws NvApiException {
        PersonInfo person = finder.autoFind(account);
        if (person == null) {
            throw new AccountNotFoundException();
        } else if (!person.permissionAllowed(Permissions.LOGIN)) {
            throw new NvApiException(new MissingPermissionException(Permissions.LOGIN));
        } else if (!person.getPassword().equals(passwd)) {
            throw new PasswordException();
        } else {
            return tokenManager.newToken(person);
        }
    }
}
