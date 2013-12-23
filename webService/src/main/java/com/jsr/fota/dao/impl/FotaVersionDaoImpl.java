package com.jsr.fota.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.dao.FotaVersionDao;
import com.jsr.fota.model.FotaVersionQueryModel;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:33
 * coding for fun and coding my life!
 */
@Repository("FotaVersionDao")
public class FotaVersionDaoImpl extends BaseHibernateDao<FotaVersion,Integer> implements FotaVersionDao {
    String HQL_LIST = "from FotaVersion fv ";

    @Override
    public Page<FotaVersion> listAll(int pn, int pageSize, FotaVersionQueryModel fvModel) {
        String QUERY = HQL_LIST+ " where fv.versionId like '%"+fvModel.getSearch()+"%' or fv.versionName like '%"+fvModel.getSearch()+"%'order by fv.versionId "+fvModel.getOrder();
        String COUNT = "select count(*) "+QUERY;
        Query query = getSession().createQuery(COUNT);
        int count=(int)((long)query.uniqueResult());
        List<FotaVersion> items = list(HQL_LIST, pn, pageSize);
        return  PageUtil.getPage(count, pn, items, pageSize);
    }
}
