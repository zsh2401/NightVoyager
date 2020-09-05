package org.nightvoyager.core.data.qa;

public interface ITestPaperInfo extends IUnique {

    IQuestion[] getQuestions();

    String getTitle();
    void setTitle(String newTitle);

    String getPublisherName();
    void setPublisherName(String publisherName);

    long UNLIMITED = -1;

    long getTimeLimitation();
    void setTimeLimitation(long newTimeLimitation);

    String getDescription();
    void setDescription(String desc);

//    default String getTitle(){
//        final String DEFAULT_TITLE = "Unknown";
//        try {
//            return this.getMetadata().getValue(ExtraData.KEY_TITLE,String.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return DEFAULT_TITLE;
//        }
//    }
//
//    long UNLIMITED = -1;
//    default long getTimeLimit(){
//        try {
//            return this.getMetadata().getValue(ExtraData.KEY_TITLE,long.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return UNLIMITED;
//        }
//    }
}
