package com.jsr.feedback.controller;


import com.jsr.feedback.bean.Roles;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.bean.UsersRoles;
import com.jsr.feedback.model.RoleModel;
import com.jsr.feedback.service.RolePermissionService;
import com.jsr.feedback.service.UserInfoService;
import com.jsr.feedback.service.UserRolesService;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-5
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RoleController {
    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userService;

    @Autowired
    @Qualifier("RolePermissionService")
    RolePermissionService rolePermissionService;

    @Autowired
    @Qualifier("UserRolesService")
    UserRolesService userRolesService;

    @Autowired
    @Qualifier("RoleService")
    com.jsr.feedback.service.RoleService roleService;
    private static Logger logger = Logger.getLogger(UserLoginController.class);

    public ModelAndView getAllRole(){
        ModelAndView model = new ModelAndView("user/user_roles");
        List<UsersRoles> userRolesList = userRolesService.listAll();

        model.addObject("userRolesList",userRolesList);
        return model;
    }
    @RequestMapping(value = "/user/user_roles")
    public ModelAndView getRoleAndPermission(HttpServletRequest request){
        ModelAndView model = new ModelAndView("user/user_roles");
        String _userId = request.getParameter("userId");
        int userId = Integer.parseInt(_userId);
        Users users = userService.get(userId);
        Collection<UsersRoles> userRolesList = userRolesService.findByUserId(userId);
        List<Roles> rolesList = roleService.listAll();
        List<RoleModel> list = new ArrayList<RoleModel>();
        for(Roles roles : rolesList){
            RoleModel rm = new RoleModel();
            boolean temp  = false;
            for(UsersRoles ur : userRolesList){
                if(ur.getRolesByRoleId().getRoleId() ==  roles.getRoleId()){
                    temp = true;                                          //该用户包含该权限
                    break;
                }
            }
            rm.setContaint(temp);
            rm.setRoles(roles);
            list.add(rm);
        }
        model.addObject("manuUser",users);
        model.addObject("list",list);
        return model;
    }
    @RequestMapping(value = "/user/update_user_role")
    public ModelAndView deleteUserRole(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        String msg = "";
        String _userId = request.getParameter("userId");
        String _roleId = request.getParameter("roleId");
        String type = request.getParameter("type");
        try{
            if(_roleId!=null && !_roleId.equals("") && _userId !=null && !_userId.equals("")){
                Subject currentUser = SecurityUtils.getSubject();
                Users users = (Users) currentUser.getSession().getAttribute("currUser");
                Integer userId = Integer.parseInt(_userId);
                Integer roleId = Integer.parseInt(_roleId);
                if(type.equals("add")){
                    UsersRoles ur = new UsersRoles();
                    Roles role = roleService.get(roleId);
                    Users u = userService.get(userId);
                    ur.setRolesByRoleId(role);
                    ur.setUsersByUserId(u);
                    userRolesService.saveOrUpdate(ur);


                }else if(type.equals("delete")){
                   userRolesService.deleteByUserIdRoleId(userId,roleId);
                    logInfo(request,users.getUserName(),"关闭角色id"+roleId);
                }
                msg  = "更新成功";
            }
        }catch (Exception e){
            e.printStackTrace();
            msg = "更新失败"   ;
        }
        model.setViewName("redirect:/user/user_roles?userId="+_userId);
        model.addObject("msg", msg);
        return model;
    }
    public void logInfo(HttpServletRequest request,String userName,String msg){
        MDC.put("user_name", userName);
        MDC.put("manu_ip", request.getRemoteAddr());
        logger.info(msg);
    }
    public void logInfo(String userName,String msg){
        MDC.put("user_name",userName);
        logger.info(msg);
    }
}
