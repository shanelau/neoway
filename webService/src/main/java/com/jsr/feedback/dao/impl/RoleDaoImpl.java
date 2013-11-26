package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.Roles;
import com.jsr.feedback.dao.RoleDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-5
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */
@Repository("RoleDao")
public class RoleDaoImpl extends BaseHibernateDao<Roles, Integer> implements RoleDao {
}
