<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<%@include file="../inc/taglib.jsp" %>
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->


<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title>已经完成的计划单</title>
    <base href="<%=basePath %>">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- BEGIN PAGE LEVEL STYLES -->
    <%@include file="../inc/import.jsp" %>
    <link rel="stylesheet" type="text/css" href="css/select2_metro.css" />
    <link rel="stylesheet" href="css/DT_bootstrap.css" />

    <!-- END PAGE LEVEL STYLES -->

    <link rel="shortcut icon" href="image/favicon.ico" />
</head>


<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->

<%@include file="../inc/top.jsp"%>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid">

    <!-- BEGIN SIDEBAR -->

    <%@include file="../inc/leftmenu.jsp"%>

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

                <!-- END BEGIN STYLE CUSTOMIZER -->
                <h3 class="page-title">已经完成计划单<small></small>  <span class="text-error controls">${requestScope.msg}</span></h3>
                <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                <ul class="breadcrumb">
                    <li> <i class="icon-home"></i> <a href="index">主页</a> <i class="icon-angle-right"></i> </li>
                    <li> <a href="#">模块计划单</a> <i class="icon-angle-right"></i> </li>
                    <li><a href="#">已经完成计划单</a></li>
                </ul>
            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->

            <div class="row-fluid">
                <div class="span12" data-tablet="fix-offset">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box green">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-user"></i>已经完成计划单</div>

                        </div>
                        <div class="portlet-body">
                            <table class="table table-striped table-bordered table-hover" id="sample_2">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>计划单代号</th>
                                    <th>产品代号</th>
                                    <th>型号</th>
                                    <th>生产厂商</th>
                                    <th>生产总数</th>
                                    <th>产品名称</th>
                                    <th>IMEI号</th>
                                    <th>计划完成时间</th>
                                    <th class="hidden-480">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="model" items="${dealList}" varStatus="s">
                                    <tr>
                                        <td>${s.index}</td>
                                        <td> ${model.moduleProId}<input type="text" class="hidden" name="proPlanId" value="${model.proPlanId}" style="width: 2px;"/> </td>
                                        <td>${model.packProCode}</td>
                                        <td>${model.mkType}</td>
                                        <td>${model.proceManu}</td>
                                        <td>${model.proceCount}</td>
                                        <td>${model.packProName}</td>
                                        <td>${model.packImeiStart}</td>
                                        <td>${model.accomplishDate}</td>
                                        <td><shiro:hasRole name="admin"> <a href="plan/module-plan-editor?moduleId=${model.moduleProId}" class="btn blue"><i class="icon-pencil"></i>编辑</a> </shiro:hasRole>
                                            <a href="plan/module-plan-editor?moduleId=${model.moduleProId}&is_view=module_plan_view" class="btn green"><i class="icon-star"></i> 预览</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>
            </div>

            <!-- END PAGE CONTENT-->

        </div>

        <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->

</div>
<%@include file="../inc/footer.jsp"%>

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