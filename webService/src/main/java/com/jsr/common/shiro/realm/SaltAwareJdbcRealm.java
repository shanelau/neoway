package com.jsr.common.shiro.realm;

import com.jsr.feedback.bean.*;
import com.jsr.feedback.service.RolePermissionService;
import com.jsr.feedback.service.UserInfoService;
import com.jsr.feedback.service.UserRolesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Realm that exists to support salted credentials.  The JdbcRealm implementation needs to be updated in a future
 * Shiro release to handle this.
 */

public class SaltAwareJdbcRealm extends JdbcRealm {

    private static final Logger log = LoggerFactory.getLogger(SaltAwareJdbcRealm.class);
    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userService;

    @Autowired
    @Qualifier("RolePermissionService")
    RolePermissionService rolePermissionService;

    @Autowired
    @Qualifier("UserRolesService")
    UserRolesService userRolesService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        Connection conn = null;
        AuthenticationInfo info = null;
        try {
            conn = dataSource.getConnection();

            Users users = userService.findUserByName(username);

            if (users == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }

            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, users.getPassword(), getName());
            info = saInfo;
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            session.setAttribute("currUser", users);
        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        // String username = (String) getAvailablePrincipal(principals);
        Users users = (Users) session.getAttribute("currUser");
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        ;
        List<UsersRoles> list = userRolesService.findByUserId(users.getUserId());
        for (UsersRoles userRoles : list) {
            Roles role = userRoles.getRolesByRoleId();
            if (role != null) {
                roleNames.add(role.getRoleName());               //װ���ɫ
                List<RolesPermissions> perList = rolePermissionService.findPermissionByRoleId(role.getRoleId());
                for (RolesPermissions rp : perList) {
                    Permissions p = rp.getPermissionsByPermId();
                    permissions.add(p.getPermName());

                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;

    }
}

