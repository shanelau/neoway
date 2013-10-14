<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/taglib.jsp" %>


<!--[if !IE]><!-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>有方生产数据系统</title>
    <base href="<%=basePath %>">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <%@include file="../inc/import.jsp" %>
    <link rel="stylesheet" type="text/css" href="css/datetimepicker.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-fileupload.css" />
    <style>
        .ui-autocomplete {
            max-height: 300px;
            overflow-y: auto;
            /* prevent horizontal scrollbar */
            overflow-x: hidden;
        }
            /* IE 6 doesn't support max-height
             * we use height instead, but this forces the menu to always be this tall
             */
        * html .ui-autocomplete {
            height: 100px;
        }
       input[name='type_id']{
           width: 10px;
       }
    </style>
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

            <!-- BEGIN STYLE CUSTOMIZER -->

            <!-- END BEGIN STYLE CUSTOMIZER -->

            <!-- BEGIN PAGE TITLE & BREADCRUMB-->

            <h3 class="page-title">新建计划单<small></small>  <span class="text-error controls">${msg}</span></h3>
            <ul class="breadcrumb">
                <li> <i class="icon-home"></i> <a href="../index.jsp">主页</a> <i class="icon-angle-right"></i> </li>
                <li> <a href="#">模块计划单</a> <i class="icon-angle-right"></i> </li>
                <li><a href="#">新建计划单</a></li>
            </ul>

            <!-- END PAGE TITLE & BREADCRUMB-->

        </div>
    </div>

    <!-- END PAGE HEADER-->

    <!-- BEGIN PAGE CONTENT-->

    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption"> <i class="icon-reorder"></i>计划单 <span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <form class="form-horizontal" name="project_info" method="POST" action="plan/create_module_base">
                        <div class="alert alert-info"> <strong>第一步!</strong> 基本信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">计划单号</label>
                            <input class="span2 m-wrap required" type="text" name="moduleProId">
                            <label class="span2 control-label">计划人</label>
                            <input class="span2 m-wrap" type="text" name="proCreateUser" readonly="readonly" value="${currUser.userName}">
                            <label class="span2 control-label">计划来源</label>
                            <input class="span2 m-wrap" type="text" name="proSource">
                        </div>

                    <div class="controls-row">
                            <label class="span2 control-label">加工厂商</label>
                            <input class="span2 m-wrap" type="text" name="proceManu">

                            <label class="span2 control-label" >REV版本</label>
                            <input class="span2 m-wrap" type="text" name="revVersion">

                            <label class="span2 control-label">生产机型</label>
                            <input class="span2 m-wrap" type="text" name="mkType">

                        </div>

                        <div class="controls-row">
                            <label class="span2 control-label">加工总数</label>
                            <input class="span2 m-wrap digits required" type="text" name="proceCount" value="0">

                             <label class="span2 control-label ">完成时间</label>
                            <input class="span2 m-wrap datepicker required" type="text" readonly data-date-format="yyyy-mm-dd hh:ii:ss" name="accomplishDate">
                        </div>

                        <div class="space20"></div>
                        <div class="alert alert-info"> <strong>第二步!</strong>装配、包装信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">产品代码</label>
                            <input class="span2 m-wrap required" type="text" name="packProCode">
                            <label class="span2 control-label">产品名称</label>
                            <input class="span2 m-wrap" type="text" name="packProName">
                            <label class="span2 control-label">是否批量质检</label>
                            <select class="m-wrap span2" name="packIsCheck">
                                <option value="false">否</option>
                                <option value="true">是</option>
                            </select>
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">升级软件版本</label>
                            <input class="span6 m-wrap" type="text" name="packSoftwareNo">
                            <label class="span2 control-label">是否定制标贴</label>
                            <select class="m-wrap span2" name="packIsBiaotie">
                                <option value="否">否</option>
                                <option value="是">是</option>
                                <option value="不定制(通用版)">不定制(通用版)</option>
                            </select>
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">是否修改波特率</label>
                            <select class="m-wrap span2" name="packUpdateRate">
                                <option value="false">否</option>
                                <option value="true">是</option>
                            </select>
                            <label class="span2 control-label">波特率修改为</label>
                            <input class="span2 m-wrap" type="text" name="packBaudRate">

                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">IMEI号</label>
                            <input class="span6 m-wrap" type="text" name="packImeiStart">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">标贴料号</label>
                            <input class="span2 m-wrap" type="text" name="packBiaotieNo">
                            <label class="span2 control-label">碳带料号</label>
                            <input class="span2 m-wrap" type="text" name="packTangdaiNo">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">SN号开始</label>
                            <input class="span2 m-wrap" type="text" name="proSnStart">
                            <label class="span2 control-label">SN号结尾</label>
                            <input class="span2 m-wrap" type="text" name="proSnEnd">
                        </div>
                        <div class="alert alert-info"> <strong>第三步!</strong>人员信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">配置文件</label>
                            <input class="span4 m-wrap users required" type="text" name="confUser" placeholder="输入空格/用户名/邮箱/真名">
                            <label class="span2 control-label">生产技术</label>
                            <input class="span4 m-wrap users required" type="text" name="proTechUser" placeholder="输入空格/用户名/邮箱/真名">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">软件经理</label>
                            <input class="span4 m-wrap users required" type="text" name="softManUser" placeholder="输入空格/用户名/邮箱/真名">
                            <label class="span2 control-label">项目经理</label>
                            <input class="span4 m-wrap users required" type="text" name="proManUser" placeholder="输入空格/用户名/邮箱/真名">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">抄送</label>
                            <input class="span9" type="text"  placeholder="输入需要抄送的邮箱账号，用‘,’隔开" name="sendEmail">
                        </div>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue submit_project"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- END PAGE CONTENT-->


    </div>
    <!-- 生产信息结束--
    </div>

    <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->


</div>
<%@include file="../inc/footer.jsp"%>

<script type="text/javascript" src="js/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="js/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/script/my.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script>

    jQuery(document).ready(function() {

        App.init(); // initlayout and core plugins

    });

</script>
<!-- END CONTAINER -->
<script>
    (function(){
        $(document).ready(function(){
            $("form[name='project_info']").validate({

            });
            $(".datepicker").datetimepicker({
                language:'zh',
                autoclose: true,
                todayBtn: true,
                pickerPosition: "bottom-left"

            });
        });
    })($);

</script>

</body>

<!-- END BODY -->

</html>