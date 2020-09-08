package org.nightvoyager.app.service;

import org.nightvoyager.core.data.IPersonInfo;

public interface ITokenManager {

    /**
     * Create an new token for specified person.
     *
     * @param personInfo
     * @return
     */
    String newToken(IPersonInfo personInfo);

    /**
     * @param token
     * @return IPersonInfo's implementation instance or null if not found any match.
     */
    IPersonInfo findPersonByToken(String token);

    /**
     * Clear token for a specified person.
     *
     * @param personInfo target person.
     */
    void clearToken(IPersonInfo personInfo);

    /**
     * Clear all token.
     */
    void clearAllToken();
}
