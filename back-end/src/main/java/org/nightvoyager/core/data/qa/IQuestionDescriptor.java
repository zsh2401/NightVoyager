package org.nightvoyager.core.data.qa;

public interface IQuestionDescriptor {
    QuestionDescriptionType getType();
    String getContent();
    String getTitle();
    String getMark();
    String getHumanReadableStandardAnswer();
}
