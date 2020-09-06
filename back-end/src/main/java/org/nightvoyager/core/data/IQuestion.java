package org.nightvoyager.core.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IQuestion extends IUnique {

    @NotNull
    String getDescription();
    void setDescription(String desc);

    String getStandardAnswerData();
    void setStandardAnswerData(String data);

    QuestionType getType();
    void setType(QuestionType type);

    @Nullable
    String getAnswerAnalysis();
    void setAnswerAnalysis(String data);

    void setScoreData();
    String getScoreData();

    @NotNull
    IQuestionScorer getScorer();
    void setScorer(IQuestionScorer scorer);

    @NotNull
    ITestPaperMasterCopy getOwner();

}
