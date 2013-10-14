<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 13-9-23
  Time: 上午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-sidebar nav-collapse collapse">

    <!-- BEGIN SIDEBAR MENU -->

    <ul class="page-sidebar-menu">
        <li>

            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

            <div class="sidebar-toggler hidden-phone"></div>

            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

        </li>
        <li>

            <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

            <form class="sidebar-search">
                <div class="input-box"> <a href="javascript:;" class="remove"></a>
                    <input type="text" placeholder="Search..." />
                    <input type="button" class="submit" value=" " />
                </div>
            </form>

            <!-- END RESPONSIVE QUICK SEARCH FORM -->

        </li>
        <li class="start active "> <a href="index"> <i class="icon-home"></i> <span class="title">工作台</span> <span class="selected"></span> </a> </li>
        <li class="modul_plan"> <a href="javascript:;"> <i class="icon-cogs"></i> <span class="title">模块计划单</span> <span class="arrow "></span> </a>
            <ul class="sub-menu">
                       <shiro:hasRole name="plan_create">
                <li > <a href="plan/create_module_plan"> 新建计划单 </a> </li>   </shiro:hasRole>
                <li > <a href="plan/plan-list-deal"> 待处理计划单 </a> </li>
                <li > <a href="plan/plan-list-finish"> 已经完成计划单 </a> </li>
                <li > <a href="#"> 计划单信息统计 </a> </li>
            </ul>
        </li>
        <li class=""> <a href="javascript:;"> <i class="icon-bookmark-empty"></i> <span class="title">手机计划单</span> <span class="arrow "></span> </a>
            <ul class="sub-menu">

            </ul>
        </li>
        <li class=""> <a href="javascript:;"> <i class="icon-table"></i> <span class="title">用户信息</span> <span class="arrow "></span> </a>
            <ul class="sub-menu">
                <li > <a href="user_list"> 所有用户 </a> </li>
                <li > <a href="user_info"> 个人信息 </a> </li>
            </ul>
        </li>
        <li class=""> <a href="javascript:;"> <i class="icon-briefcase"></i> <span class="title">权限管理</span> <span class="arrow "></span> </a>

        </li>
        <li class=""> <a href="javascript:;"> <i class="icon-briefcase"></i> <span class="title">其他</span> <span class="arrow "></span> </a>
            <ul class="sub-menu">
                <li > <a href="advice_list">用户反馈 </a> </li>
                <li > <a href="image/assets/neoway计划单使用说明书.doc"> 系统帮助 </a> </li>
            </ul>
        </li>
    </ul>

    <!-- END SIDEBAR MENU -->

</div>