<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="inc/header.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎</title>
</head>
<body>
Hello, <shiro:principal/>, how are you today?
<br/>
<a href="<c:url value='/user'/>">用户列表</a>

<br/>
<shiro:hasRole name="小小管理员">
    <a href="admin.jsp">Administer the system</a>
</shiro:hasRole>
<br/>
<shiro:hasPermission name="改赏金">
    <a href="createUser.jsp">Create a new User</a>
</shiro:hasPermission>
<br/>
</body>
</html>