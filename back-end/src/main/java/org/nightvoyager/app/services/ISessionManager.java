package org.nightvoyager.app.services;

import org.nightvoyager.core.data.roler.IPersonInfo;

public interface ISessionManager {

    /**
     * Create new token for a person.
     *
     * @param personInfo
     * @return
     */
    String newToken(IPersonInfo personInfo);

    /**
     * @param token
     * @return IPersonInfo's implementation instance or null if not found any match.
     */
    IPersonInfo getPersonInfoByToken(String token);

    /**
     * Clear token for a specified person.
     *
     * @param personInfo target person.
     */
    void clearTokenFor(IPersonInfo personInfo);
}
