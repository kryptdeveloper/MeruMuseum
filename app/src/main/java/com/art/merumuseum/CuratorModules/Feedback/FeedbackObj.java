package com.art.merumuseum.CuratorModules.Feedback;

public class FeedbackObj {
    String mail;
    String feedback;

    public FeedbackObj(String mail, String feedback) {
        this.mail = mail;
        this.feedback = feedback;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
