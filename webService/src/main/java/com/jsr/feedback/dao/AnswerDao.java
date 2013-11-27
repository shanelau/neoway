package com.jsr.feedback.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.feedback.bean.FbAnswer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:09
 * coding for fun and coding my life!
 */
public interface AnswerDao extends IBaseDao<FbAnswer,Integer>{
    List<FbAnswer> getByFbId(int fbId);
}
