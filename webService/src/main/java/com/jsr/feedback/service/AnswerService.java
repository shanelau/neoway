package com.jsr.feedback.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsr.common.service.IBaseService;
import com.jsr.feedback.bean.FbAnswer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:10
 * coding for fun and coding my life!
 */
public interface AnswerService extends IBaseService<FbAnswer,Integer>{
    void saveAndModifyStatus(int fbId, String content) throws Exception;

    List<FbAnswer> getByFbId(int fbId);

    void saveReplyAll(int[] addr, String message);
}
