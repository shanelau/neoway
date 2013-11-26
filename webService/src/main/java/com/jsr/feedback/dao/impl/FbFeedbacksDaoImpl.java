package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.common.dao.util.ConditionQuery;
import com.jsr.common.dao.util.OrderBy;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.dao.FbFeedbacksDao;
import com.jsr.feedback.model.FBQueryModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-19
 * Time: 下午9:50
 * coding for fun and coding my life!
 */
@Repository("FbFeedbacksDao")
public class FbFeedbacksDaoImpl extends BaseHibernateDao<FbFeedbacks, Integer> implements FbFeedbacksDao {
    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FbFeedbacksDaoImpl.class.getName());
    //private final String HQL_FIND_FEEDBACK_BY_WORD = "from FbFeedbacks fb where fb.fbId like ? or fb.subject like ? or fb.content like ? or fb.version like ? or fb.fbDate like ? order by fb.fbId";
    private final String HQL = " from FbFeedbacks fb ";
    private String right ="";//and 的右括号

    @Override
    public Page<FbFeedbacks> listAll(int pn, int pageSize, String search, String order) {
        Integer count;
        List<FbFeedbacks> items;
        if(search == null || search.equals("")){
             count = countAll();
             items = list(HQL+addOrder("fb.fbId",order),pn,pageSize);
        }else{
            String HQL_COUNT_SEARCH ="select count(*) "+HQL+" where "+getQueryParam(search)+addOrder("fb.fbId",order);
            Query query = getSession().createQuery(HQL_COUNT_SEARCH);
            count=(int)((long)query.uniqueResult());

            items = list(HQL+getQueryParam(search), pn, pageSize);
        }
        return  PageUtil.getPage(count, pn, items, pageSize);
    }

    @Override
    public Page<FbFeedbacks> list(int pn, int pageSize, FBQueryModel fbQueryModel) {
        String count_hql = "select count(*) "+HQL+" ";
        String query_hql = HQL;
        String  sql= " where "+getSQLFromQueryModel(fbQueryModel)+getQueryParam(fbQueryModel.getSearch())+right+ addOrder("fb.fbId",fbQueryModel.getOrder());
        System.out.println(query_hql + sql);
        long count = unique(count_hql+sql);
        List<FbFeedbacks> items = list(query_hql + sql, pn, pageSize);
        return  PageUtil.getPage((int)count, pn, items, pageSize);
    }

    public String getSQLFromQueryModel(FBQueryModel queryMode){
        String sql = "";
        boolean hasStatus = false;
        boolean hasTypeId = false;
        String stauts = queryMode.getStatu();
        String typeId = queryMode.getType();
        if(stauts!=null && !stauts.equals("")){
            sql = "  fb.fbStatuByStatusId.statusId = "+queryMode.getStatu();
            hasStatus = true;
        }
        if(typeId!=null && !typeId.equals("")){
            if(hasStatus){
                sql +=" and ";
            }
            sql +=  "fb.fbTypeByTypeId.typeId = "+queryMode.getType();
            hasTypeId = true;
        }
        return sql+getAnd(hasTypeId,hasStatus);
    }

    /**
     * 有其中之一，则添加and符号
     * @param hasTypeId     是否有类型
     * @param hasStatus     是否有状态查询条件
     * @return
     */
    public String getAnd(boolean hasTypeId,boolean hasStatus){
        if(hasStatus || hasTypeId){
            right = ")";
            return " and (";
        }else {
            right="";
        }
        return "";
    }
    private String getQueryParam(String search) {
       return " fb.fbId like "+"'%"+search+"%' " +" or fb.subject like "+"'%"+search+"%' " +" or fb.content like "+"'%"+search+"%' " +" or fb.version like "+"'%"+search+"%' " +" or fb.contact like "+"'%"+search+"%' ";
    }
    private String addOrder(String index ,String orderTye){
        String orderSql =" order by "+index +" "+orderTye;
        return orderSql;
    }
}
