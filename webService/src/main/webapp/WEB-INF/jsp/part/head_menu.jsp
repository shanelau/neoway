
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 13-11-27
  Time: 下午1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container logo_line">
    <div class="masthead">
        <h3 class="text-muted">JSR云上的日子</h3>
    </div>
</div>
<header role="banner" class="navbar navbar-inverse bs-docs-nav">
    <div class="container">
        <div class="navbar-header">
            <button data-target=".bs-navbar-collapse" data-toggle="collapse" type="button" class="navbar-toggle"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="index"><shiro:principal/></a> </div>
        <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li name="index"> <a href="index">主页</a> </li>
                <li name="feedback"> <a href="feedback/index">用户反馈</a> </li>

                <li> <a href="findphone/index">手机找回</a> </li>
                <li name="fota" class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                     fota升级 <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu" role="menu">
                      <li><a href="fota/brand">项目管理</a></li>
                      <li><a href="fota/version/index">版本管理</a></li>
                      <li class="divider"></li>
                      <li><a href="fota/imei/index">配置IMEI</a></li>
                  </ul>
             </li>
                <li> <a href="#">云存储</a> </li>
                <li> <a href="#">统计</a> </li>
                <li class="logout">
                    <a href="logout" style="color:#FFFFFF;">退出</a>
                </li>
            </ul>
        </nav>
    </div>
</header>