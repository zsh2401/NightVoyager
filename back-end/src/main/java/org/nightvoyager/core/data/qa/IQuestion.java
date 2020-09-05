package org.nightvoyager.core.data.qa;

import org.jetbrains.annotations.NotNull;

public interface IQuestion extends IUnique {

    @NotNull
    String getDescription();
    void setDescription(String desc);

    @NotNull
    String getStandardAnswerData();
    void setStandardAnswerData(String data);

    @NotNull
    String getScorerClassName();
    void setScorerClassName();

    @NotNull
    ITestPaperInfo getOwner();
    default IQuestionScorer getScorer(){
        try {
           Class<?> clazz =  this.getClass().getClassLoader().loadClass(getScorerClassName());
           if(IQuestionScorer.class.isAssignableFrom(clazz)){
                return (IQuestionScorer) clazz.newInstance();
           }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
