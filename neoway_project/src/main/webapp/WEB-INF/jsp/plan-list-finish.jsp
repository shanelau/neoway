<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp"%>


<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>有方生产数据系统</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <link rel="stylesheet" type="text/css" href="/css/datetimepicker.css" />
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-fileupload.css" />
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

<!-- BEGIN PAGE -->

<div class="page-container row-fluid">

<!-- BEGIN SIDEBAR -->

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

                <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                <div class="space20"></div>
                <ul class="breadcrumb">
                    <li> <i class="icon-home"></i> <a href="index.html">主页</a> <i class="icon-angle-right"></i> </li>
                    <li> <a href="#">模块计划单</a> <i class="icon-angle-right"></i> </li>
                    <li><a href="#">已完成计划单</a></li>
                </ul>

                <!-- END PAGE TITLE & BREADCRUMB-->

            </div>
        </div>

        <!-- END PAGE HEADER-->

        <!-- BEGIN PAGE CONTENT-->

        <div class="row-fluid">
            <div class="span6 responsive" data-tablet="span12 fix-offset" data-desktop="span6">

                <!-- BEGIN EXAMPLE TABLE PORTLET-->

                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption"><i class="icon-user"></i>已完成计划单</div>

                    </div>
                    <div class="portlet-body">
                        <table class="table table-striped table-bordered table-hover" id="sample_2">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>计划单代号</th>
                                <th class="hidden-480">创建建时间</th>
                                <th>型号</th>
                                <th>生产总数</th>
                                <th>计划完成时间</th>
                                <th class="hidden-480">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="model" items="${dealList}" varStatus="s">
                                <tr>
                                    <td>${s.index}</td>
                                    <td> ${model.moduleProId}<input type="text" class="hidden" name="proPlanId" value="${model.proPlanId}" style="width: 2px;"/> </td>
                                    <td>${model.proCreateDate}</td>
                                    <td>${model.mkType}</td>
                                    <td>${model.proceCount}</td>
                                    <td>${model.accomplishDate}</td>
                                  <td><shiro:hasRole name="admin"> <a href="/plan/module-plan-editor?moduleId=${model.moduleProId}" class="btn blue"><i class="icon-pencil"></i>编辑</a> </shiro:hasRole>
                                      <a href="/plan/module-plan-editor?moduleId=${model.moduleProId}&is_view=module_plan_view" class="btn green"><i class="icon-star"></i> 预览</a></td>
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

<!-- END PAGE -->

<!-- END PAGE -->

</div>
<%@include file="inc/footer.jsp"%>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="/js/bootstrap-fileupload.js"></script>
<script src="/js/table-managed.js"></script>
<script src="/js/script/my.js"></script>
<script>

    jQuery(document).ready(function() {

        App.init();

        TableManaged.init();

    });
    (function(){
        $(document).ready(function(){


            $("ul.page-sidebar-menu li").removeClass("active");
            $("ul.page-sidebar-menu li.modul_plan").addClass("active");
        });
    })($);

</script>
<!-- END CONTAINER -->

</body>

<!-- END BODY -->

</html>