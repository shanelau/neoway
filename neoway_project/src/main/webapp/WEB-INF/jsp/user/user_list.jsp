<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<%@include file="../inc/taglib.jsp" %>


<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>有方生产数据系统</title>
    <base href="<%=basePath%>">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <%@include file="../inc/import.jsp" %>
    <!-- END GLOBAL MANDATORY STYLES -->
    <link rel="stylesheet" type="text/css" href="css/select2_metro.css" />
    <link rel="stylesheet" href="css/DT_bootstrap.css" />
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->
<%@include file="../inc/top.jsp"%>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container">

    <!-- BEGIN SIDEBAR -->
    <%@include file="../inc/leftmenu.jsp"%>

    <!-- END SIDEBAR -->

    <!-- BEGIN PAGE -->

    <!-- BEGIN PAGE -->

    <div class="page-content">

    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

    <div id="portlet-config" class="modal hide">

        <div class="modal-header">

            <button data-dismiss="modal" class="close" type="button"></button>

            <h3>portlet Settings</h3>

        </div>

        <div class="modal-body">

            <p>Here will be a configuration form</p>

        </div>

    </div>

    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

    <!-- BEGIN PAGE CONTAINER-->

    <div class="container-fluid">

    <!-- BEGIN PAGE HEADER-->

    <div class="row-fluid">

        <div class="span12">
            <!-- BEGIN PAGE TITLE & BREADCRUMB-->

            <h3 class="page-title">

                用户信息和权限 <small></small>  <span class="text-error controls">${msg}</span>

            </h3>

            <ul class="breadcrumb">

                <li>

                    <i class="icon-home"></i>

                    <a href="../index.jsp">主页</a>

                    <i class="icon-angle-right"></i>

                </li>

                <li>

                    <a href="#">用户权限管理</a>

                    <i class="icon-angle-right"></i>

                </li>

                <li><a href="#">用户角色分配</a></li>

            </ul>

            <!-- END PAGE TITLE & BREADCRUMB-->

        </div>

    </div>

    <!-- END PAGE HEADER-->

    <!-- BEGIN PAGE CONTENT-->
    <div class="alert alert-success">

        <button class="close" data-dismiss="alert"></button>

        <strong>该页面只有管理员可见!</strong> 冻结用户后，用户无法登陆，进行任何操作。

    </div>
    <div class="row-fluid">

        <div class="span12">

            <!-- BEGIN CONDENSED TABLE PORTLET-->

            <div class="portlet box green">

                <div class="portlet-title">

                    <div class="caption"><i class="icon-picture"></i> 用户信息和权限</div>

                    <div class="tools">

                        <a href="javascript:;" class="collapse"></a>

                        <a href="#portlet-config" data-toggle="modal" class="config"></a>

                        <a href="javascript:;" class="reload"></a>

                        <a href="javascript:;" class="remove"></a>

                    </div>

                </div>

                <div class="portlet-body" style="display: block;">

                    <table class="table table-striped table-bordered table-hover" id="sample_2">

                        <thead>

                        <tr>

                            <th>序号</th>

                            <th>用户名</th>

                            <th>真名</th>
                            <th>部门</th>
                            <th>手机</th>
                            <th>邮箱</th>
                            <th>操作</th>

                        </tr>

                        </thead>

                        <tbody>
                        <c:forEach var="user" items="${userList}" varStatus="s">
                        <tr>
                            <td>${s.index}</td>
                            <td>${user.userName}</td>
                            <td>${user.trueName}</td>
                            <td>${user.dept}</td>
                            <td>${user.phone}</td>
                            <td>${user.email}</td>
                            <td><shiro:hasRole name="admin"><a class="btn blue"  href="user/user_roles?userId=${user.userId}">编辑权限</a>
                                <c:choose>
                                    <c:when test="${user.userState}">
                                        <a class="btn red" href="user/lock_user?userId=${user.userId}&userState=${user.userState}">冻结</a>
                                    </c:when><c:otherwise>
                                      <a class="btn green" href="user/lock_user?userId=${user.userId}&userState=${user.userState}">解冻</a>
                                    </c:otherwise>
                                </c:choose>
                            </shiro:hasRole>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </div>

            </div>

            <!-- END CONDENSED TABLE PORTLET-->

        </div>

    </div>

    <!-- END PAGE CONTENT-->

    </div>

    <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->

    <!-- END PAGE -->

</div>
<%@include file="../inc/footer.jsp"%>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/DT_bootstrap.js"></script>
<script type="text/javascript" src="js/select2.min.js"></script>
<script type="text/javascript" src="js/script/my.js"></script>
<script src="js/table-managed.js"></script>
<!-- END CONTAINER -->
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins
        TableManaged.init();

    });
    (function(){
        $(document).ready(function(){
            $("ul.page-sidebar-menu li").removeClass("active");
            $("ul.page-sidebar-menu li.user_info").addClass("active");
        });
    })($);

</script>
</body>

<!-- END BODY -->

</html>