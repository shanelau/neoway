package com.jsr.fota.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.dao.FotaFileDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:32
 * coding for fun and coding my life!
 */
@Repository("FotaFileDao")
public class FotaFileDaoImpl extends BaseHibernateDao<FotaFile,Integer> implements FotaFileDao {
}
