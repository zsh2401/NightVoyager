package org.nightvoyager.app.service;

import org.nightvoyager.app.entity.PersonInfo;

public interface IAutoAccountFinder {
    /**
     * Auto check the type of inputted data and find related account in data base.
     * This method's implementation should NEVER throws any exception!
     *
     * @param account
     * @return null if not found otherwise related {@link PersonInfo} entity.
     */
    PersonInfo autoFind(String account);
}
