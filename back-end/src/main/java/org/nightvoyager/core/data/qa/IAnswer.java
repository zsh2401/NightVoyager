package org.nightvoyager.core.data.qa;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.roler.IPersonInfo;

public interface IAnswer extends IUnique {

    /**
     * Get the question about answer.
     * @return
     */
    IQuestion getQuestion();

    /**
     * Get answerer.
     * @return
     */
    IPersonInfo getAnswerer();

    /**
     * Get the information of where the answer is written.
     * @return
     */
    IExaminationInfo getExamination();

    /**
     * Get base 64 string as answer data.
     */
    String getBase64Data();

    /**
     * Set base 64 string as answer data.
     *
     * @param data
     */
    void setBase64Data(String data);
}
