package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.mail.SendMail;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.common.service.impl.BaseService;
import com.jsr.common.shiro.realm.MD5;
import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.dao.UserInfoDao;
import com.jsr.feedback.model.UserQueryModel;
import com.jsr.feedback.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl extends BaseService<Users, Integer> implements UserInfoService {
    private UserInfoDao userInfoDao;

    @Autowired
    @Qualifier("UserInfoDao")
    @Override
    public void setBaseDao(IBaseDao<Users, Integer> userInfoDao) {
        this.baseDao = userInfoDao;
        this.userInfoDao = (UserInfoDao)userInfoDao;
    }

    @Override
    public Users findUserByName(String username) {
        return userInfoDao.findByUserName(username);
    }

    @Override
    public List<Users> listByKeyword(String keyword) {
        return userInfoDao.listByKeyword(keyword);
    }

    @Override
    public String updateForgetPassword(String username,String basePath) throws Exception {
            Users users = findUserByName(username);
            if(users == null){              //用户名不存在
                throw new Exception("");
            }
            String secretKey= UUID.randomUUID().toString();  //密钥
            Timestamp outDate = new Timestamp(System.currentTimeMillis()+30*60*1000);//30分钟后过期
            long date = outDate.getTime()/1000*1000;                  //忽略毫秒数
            users.setValidataCode(secretKey);
            users.setRegDate(new Timestamp(date));
            saveOrUpdate(users);
            String key = users.getUserName()+"$"+date+"$"+secretKey;
            String digitalSignature = MD5.MD5Encode(key);                 //数字签名
            String emailTitle = "JSR云密码找回";
            String resetPassHref =  basePath+"user/reset_password?sid="+digitalSignature+"&userName="+users.getUserName();
            String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="+resetPassHref +" target='_BLANK'>点击我重新设置密码</a>" +
                    "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'";
            System.out.print(resetPassHref);
            SendMail.getInstatnce().sendHtmlMail(emailTitle,emailContent,users.getEmail());
           return  "操作成功,已经发送找回密码链接邮箱"+users.getEmail()+"。请在30分钟内重置密码";
    }

    @Override
    public Page<Users> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userInfoDao.countQuery(command), pn, userInfoDao.query(pn, pageSize, command), pageSize);
    }


}
