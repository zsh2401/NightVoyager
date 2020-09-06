package org.nightvoyager.core.data;

import org.nightvoyager.core.data.roler.IPersonInfo;

public interface IAnswer extends IUnique {

    /**
     * Get the question about answer.
     *
     * @return
     */
    IQuestion getQuestion();

    /**
     * Get the answerer.
     *
     * @return
     */
    IPersonInfo getAnswerer();

    /**
     * Get the information of where this answer is written.
     *
     * @return
     */
    IExaminationInfo getExamination();


    /**
     * Check if data is BASE64 encoded.
     *
     * @return
     */
    boolean isBase64();

    /**
     * Set if the data is stored as base64 string.
     *
     * @param value
     */
    void setIsBase64(boolean value);

    /**
     * Get answer data.
     */
    String getData();

    /**
     * Set answer data.
     *
     * @param data
     */
    void setData(String data);
}
