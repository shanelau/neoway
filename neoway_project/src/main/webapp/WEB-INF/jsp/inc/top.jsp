<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header navbar navbar-inverse navbar-fixed-top">

    <!-- BEGIN TOP NAVIGATION BAR -->

    <div class="navbar-inner">
        <div class="container-fluid">

            <!-- BEGIN LOGO -->

            <a class="brand" href="index"> <img src="image/logo.png" alt="logo"/> </a>

            <!-- END LOGO -->

            <!-- BEGIN RESPONSIVE MENU TOGGLER -->

            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse"> <img src="image/menu-toggler.png" alt="" /> </a>

            <!-- END RESPONSIVE MENU TOGGLER -->

            <!-- BEGIN TOP NAVIGATION MENU -->

            <ul class="nav pull-right">

                <!-- BEGIN NOTIFICATION DROPDOWN -->



                <!-- END NOTIFICATION DROPDOWN -->

                <!-- BEGIN USER LOGIN DROPDOWN -->

                <li class="dropdown user"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img alt="" src="image/avatar1_small.jpg" /> <span class="username"> <shiro:principal/></span>  </a>
                    <ul class="dropdown-menu">
                   <%--     <li class="divider"></li>--%>
                        <li><a href="logut"><i class="icon-key"></i>注销</a></li>
                    </ul>
                </li>
                <li>
                    <div class="scroll_to_bottom" title="滚动到底部"> <span class="go-down"> <i class="icon-angle-down"></i> </span> </div>
                </li>
                <!-- END USER LOGIN DROPDOWN -->

            </ul>

            <!-- END TOP NAVIGATION MENU -->

        </div>
    </div>

    <!-- END TOP NAVIGATION BAR -->

</div>
