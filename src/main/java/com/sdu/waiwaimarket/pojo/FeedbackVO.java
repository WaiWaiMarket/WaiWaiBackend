package com.sdu.waiwaimarket.pojo;

import java.util.Date;

public class FeedbackVO {
    Integer feedbackid;
    Integer orderid;
    Integer userid;
    String feedbackdesc;
    Integer feedbackstatus;
    Date feedbackdate;

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getFeedbackdesc() {
        return feedbackdesc;
    }

    public void setFeedbackdesc(String feedbackdesc) {
        this.feedbackdesc = feedbackdesc;
    }

    public Integer getFeedbackstatus() {
        return feedbackstatus;
    }

    public void setFeedbackstatus(Integer feedbackstatus) {
        this.feedbackstatus = feedbackstatus;
    }

    public Date getFeedbackdate() {
        return feedbackdate;
    }

    public void setFeedbackdate(Date feedbackdate) {
        this.feedbackdate = feedbackdate;
    }
}
