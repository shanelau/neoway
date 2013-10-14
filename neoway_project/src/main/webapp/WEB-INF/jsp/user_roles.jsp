<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp"%>


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
    <!-- END GLOBAL MANDATORY STYLES -->
    <link rel="stylesheet" type="text/css" href="css/datetimepicker.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-fileupload.css" />
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->
<%@include file="inc/top.jsp"%>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container">

    <!-- BEGIN SIDEBAR -->
    <%@include file="inc/leftmenu.jsp"%>

    <!-- END SIDEBAR -->

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

                    <!-- BEGIN STYLE CUSTOMIZER -->


                    <!-- END BEGIN STYLE CUSTOMIZER -->

                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->

                    <h3 class="page-title"> 用户角色 <small>权限管理</small> </h3>
                    <ul class="breadcrumb">
                        <li> <i class="icon-home"></i> <a href="index">主页</a> <i class="icon-angle-right"></i> </li>
                        <li> <a href="#">角色权限管理</a> <i class="icon-angle-right"></i> </li>
                        <li><a href="#">用户角色</a></li>
                    </ul>

                    <!-- END PAGE TITLE & BREADCRUMB-->

                </div>
            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->
            <div class="alert alert-success"><button class="close" data-dismiss="alert"></button>
                <strong>提示!</strong> 勾选左侧的角色完成权限分配，右侧为当前用户的权限。</div>
            <div class="row-fluid">
                <div class="span12">
                    <div class="row-fluid">
                        <div class="span12">

                            <!-- BEGIN PORTLET-->

                            <div class="portlet box green">
                                <div class="portlet-title">
                                    <div class="caption"><i class="icon-reorder"></i>角色分配</div>
                                    <div class="tools"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                                </div>

                                <div class="portlet-body">
                                    <div id="legend" class="">
                                        <legend class="">用户信息：${manuUser.userName}${manuUser.userId}</legend>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover" id="sample_2">
                                        <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>角色名</th>
                                            <th>角色描述</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="roleModel" items="${list}" varStatus="s">
                                            <tr>
                                                <td>${s.index}</td>
                                                <td>${roleModel.roles.roleName}</td>
                                                <td>${roleModel.roles.roleDesc}</td>
                                                <td>      <c:choose>
                                                    <c:when test="${roleModel.containt}">
                                                        <a href="update_user_role?userId=${manuUser.userId}&roleId=${roleModel.roles.roleId}&type=delete" class="btn red">关闭</a></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="update_user_role?userId=${manuUser.userId}&roleId=${roleModel.roles.roleId}&type=add" class="btn green">激活</a></td>
                                                    </c:otherwise>
                                                </c:choose>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>


                                </div>

                            </div>

                            <!-- END PORTLET-->
                        </div>

                    </div>
                </div>

                <!-- END PAGE CONTENT-->

            </div>

            <!-- END PAGE CONTAINER-->

        </div>
    </div>

    <!-- END PAGE -->

    <!-- END PAGE -->

</div>
<%@include file="inc/footer.jsp"%>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-fileupload.js"></script>
<script src="js/script/my.js"></script>
<!-- END CONTAINER -->
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

    });

</script>
</body>

<!-- END BODY -->

</html>