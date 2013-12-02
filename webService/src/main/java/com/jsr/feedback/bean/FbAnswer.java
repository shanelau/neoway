package com.jsr.feedback.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "fb_answer", schema = "")
@Entity
public class FbAnswer extends AbstractModel {
    private int answerId;

    @javax.persistence.Column(name = "answer_Id")
    @Id
    @GeneratedValue
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    private String content;

    @javax.persistence.Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Timestamp replyTime;

    @javax.persistence.Column(name = "reply_time")
    @Basic
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FbAnswer fbAnswer = (FbAnswer) o;

        if (answerId != fbAnswer.answerId) return false;
        if (content != null ? !content.equals(fbAnswer.content) : fbAnswer.content != null) return false;
        if (replyTime != null ? !replyTime.equals(fbAnswer.replyTime) : fbAnswer.replyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = answerId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        return result;
    }

    private Users usersByUserId;
    @JsonIgnore
    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    private FbFeedbacks fbFeedbacksByFbId;
    @JsonIgnore
    @ManyToOne
    @javax.persistence.JoinColumn(name = "fb_Id", referencedColumnName = "fb_Id")
    public FbFeedbacks getFbFeedbacksByFbId() {
        return fbFeedbacksByFbId;
    }

    public void setFbFeedbacksByFbId(FbFeedbacks fbFeedbacksByFbId) {
        this.fbFeedbacksByFbId = fbFeedbacksByFbId;
    }
}
