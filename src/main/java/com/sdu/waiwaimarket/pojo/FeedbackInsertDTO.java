package com.sdu.waiwaimarket.pojo;

public class FeedbackInsertDTO {
    Integer userid;
    Integer orderid;
    String feedbackdesc;
    Integer feedbackstatus;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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
}
