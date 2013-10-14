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

                <h3 class="page-title"> 留言反馈
                    <small>欢迎登陆有方生产信息管理系统</small>
                </h3>
                <ul class="breadcrumb">
                    <li><i class="icon-home"></i> <a href="index.jsp">其他</a> <i class="icon-angle-right"></i></li>
                    <li><a href="#">留言反馈</a></li>
                </ul>
            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->

            <div class="row-fluid">
                <div class="span12" data-tablet="fix-offset">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box green">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-user"></i>留言反馈</div>

                        </div>
                        <div class="portlet-body">
                            <table class="table table-striped table-bordered table-hover dataTable" id="sample_1">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>留言内容</th>
                                    <th>时间</th>
                                    <shiro:hasRole name="admin"><th class="hidden-480">操作</th> </shiro:hasRole>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="advice" items="${adviceList}" varStatus="s">
                                    <tr>
                                        <td>${s.index}</td>
                                        <td>${advice.content}</td>
                                        <td>${advice.sendTime}</td>
                                        <shiro:hasRole name="admin"> <td><shiro:hasRole name="admin"><a class="btn red" href="msg/delete?msg_id=${advice.emailId}">删除</a></shiro:hasRole></td>     </shiro:hasRole>
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