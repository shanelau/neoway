<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp" %>
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->


<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title>欢迎登陆有方云</title>
    <base href="<%=basePath %>">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="css/select2_metro.css" />
    <link rel="stylesheet" href="css/DT_bootstrap.css" />

    <!-- END PAGE LEVEL STYLES -->

    <link rel="shortcut icon" href="image/favicon.ico" />
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->

<%@include file="inc/top.jsp"%>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid">

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

            <div class="container-fluid">

                <h3 class="page-title"> 工作台
                    <small>欢迎登陆有方生产信息管理系统</small>
                </h3>
                <ul class="breadcrumb">
                    <li><i class="icon-home"></i> <a href="index.jsp">主页</a> <i class="icon-angle-right"></i></li>
                    <li><a href="#">工作台</a></li>
                </ul>
            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->

            <div class="row-fluid">
                <div class="span8" data-tablet="fix-offset">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box green">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-user"></i>待处理计划单</div>

                        </div>
                        <div class="portlet-body">
                            <table class="table table-striped table-bordered table-hover" id="sample_2">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>计划单代号</th>
                                    <th>型号</th>
                                    <th>生产总数</th>
                                    <th>等待处理人</th>
                                    <th class="hidden-480">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="model" items="${dealList}" varStatus="s">
                                    <tr>
                                        <td>${s.index}</td>
                                        <td><input type="text" name="proPlanId" value="${model.proPlanId}" class="hidden" style="width: 1px;"/>  ${model.moduleProId}</td>
                                        <td> ${model.mkType}</td>
                                        <td>${model.proceCount}</td>
                                        <td><a href="#" class="btn" rel="popoverTop" data-content="邮箱:${model.dealUser.email}<br/>手机:${model.dealUser.phone}" data-html="true" title="真名:${model.dealUser.trueName}" data-original-title="Popover on top">${model.dealUser.userName}</a></td>
                                        <td><c:if test="${model.dealUser.userName == currUser.userName}"><a href="plan/module-plan-editor?moduleId=${model.moduleProId}" class="btn blue"><i class="icon-pencil"></i>编辑</a></c:if>
                                            <a href="plan/module-plan-editor?moduleId=${model.moduleProId}&is_view=module_plan_view" class="btn green"><i class="icon-star"></i>预览</a>
                                            <c:if test="${model.planState == Constants.PLAN_STATE_BASE && model.dealUser.userName == currUser.userName}"> <shiro:hasRole name="plan_create"><a href="plan/delete?moduleId=${model.proPlanId}" class="btn red"><i class="icon-trash"></i> 删除</a></shiro:hasRole>    </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>
                <div class="span4">
                    <h2>快捷操作</h2>

                    <div class="top-news">
                        <shiro:hasRole name="plan_create">
                            <a href="plan/create_module_plan" class="btn green"> <span>新建计划单</span> <em> <i class="icon-tags"></i>
                                创建一份计划单,计划员才有权限 </em> <i class="icon-music top-news-icon"></i> </a>
                        </shiro:hasRole>
                        <a href="plan/plan-list-deal" class="btn yellow"> <span>待处理计划单</span> <em> <i class="icon-tags"></i>
                            所有等待处理的计划单 </em> <i class="icon-book top-news-icon"></i> </a>
                        <a href="plan/plan-list-finish" class="btn red"> <span>已经完成计划单</span> <em> <i class="icon-tags"></i> Money,
                            已经通过审核的计划单 </em> <i class="icon-briefcase top-news-icon"></i> </a>
                        <a href="#" class="btn blue"> <span>我是生产人员</span> <em> <i class="icon-tags"></i> USA,
                            生产人员</em> <i class="icon-globe top-news-icon"></i> </a>
                        <a href="user_info" class="btn black"> <span>我的信息设置</span> <em> <i class="icon-tags"></i> USA,
                            个人信息</em> <i class="icon-globe top-news-icon"></i> </a></div>
                </div>
            </div>

            <!-- END PAGE CONTENT-->

        </div>

        <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->

</div>
<%@include file="inc/footer.jsp"%>

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script type="text/javascript" src="js/select2.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/DT_bootstrap.js"></script>

<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="js/table-managed.js"></script>
<script>

    jQuery(document).ready(function() {

        App.init();

        TableManaged.init();

    });
</script>
</body>

<!-- END BODY -->

</html>