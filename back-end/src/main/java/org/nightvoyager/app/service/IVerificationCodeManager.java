package org.nightvoyager.app.service;

public interface IVerificationCodeManager {
    /**
     *
     * @param email
     * @return token
     */
    String sendEmail(String email);

    /**
     *
     * @param phoneNumber
     * @return token
     */
    String sendSMS(String phoneNumber);

    /**
     *
     * @param token
     * @param input
     * @return
     */
    boolean check(String token,String input);
}
