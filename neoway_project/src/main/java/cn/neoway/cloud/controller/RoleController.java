package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.model.RoleModel;
import cn.neoway.cloud.service.RolePermissionService;
import cn.neoway.cloud.service.RoleService;
import cn.neoway.cloud.service.UserInfoService;
import cn.neoway.cloud.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    RoleService roleService;

    public ModelAndView getAllRole(){
        ModelAndView model = new ModelAndView("user/user_roles");
        List<UserRoles> userRolesList = userRolesService.listAll();

        model.addObject("userRolesList",userRolesList);
        return model;
    }
    @RequestMapping(value = "/user/user_roles")
    public ModelAndView getRoleAndPermission(HttpServletRequest request){
        ModelAndView model = new ModelAndView("user/user_roles");
        String _userId = request.getParameter("userId");
        int userId = Integer.parseInt(_userId);
        Users users = userService.get(userId);
        Collection<UserRoles> userRolesList = userRolesService.findByUserId(userId);
        List<Roles> rolesList = roleService.listAll();
        List<RoleModel> list = new ArrayList<RoleModel>();
        for(Roles roles : rolesList){
            RoleModel rm = new RoleModel();
            boolean temp  = false;
            for(UserRoles ur : userRolesList){
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
                Integer userId = Integer.parseInt(_userId);
                Integer roleId = Integer.parseInt(_roleId);
                if(type.equals("add")){
                    UserRoles ur = new UserRoles();
                    ur.setRolesByRoleId(roleService.get(roleId));
                    ur.setUsersByUserId(userService.get(userId));
                    userRolesService.saveOrUpdate(ur);
                }else if(type.equals("delete")){
                   userRolesService.deleteByUserIdRoleId(userId,roleId);
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
}
