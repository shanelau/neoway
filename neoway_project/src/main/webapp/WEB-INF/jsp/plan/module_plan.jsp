<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../inc/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!--[if !IE]><!-->
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
    <link rel="stylesheet" type="text/css" href="css/datetimepicker.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-fileupload.css"/>

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

        input[name='type_id'] {
            width: 10px;
        }
    </style>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->
<%@include file="../inc/top.jsp" %>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container">

<!-- BEGIN SIDEBAR -->
<%@include file="../inc/leftmenu.jsp" %>

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
<!--begin upload file-->
<div id="add_file_type" class="modal hide">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3>新增文件类别</h3>
    </div>
    <div class="modal-body ">

        <form class="form-horizontal" name="add_file_type" action="plan/add_soft_type" method="post">
            <fieldset>
                <input class="hidden" type="text" name="proPlanId" value="${project.proPlanId}">
                <div class="control-group">
                    <label class="control-label">新增文件类别</label>
                    <!-- File Upload -->
                    <div class="controls">
                        <input name="typeName" type="text" placeholder="不要和已经有的类别名相同" class="input-xlarge required">
                    </div>

                </div>
            </fieldset>

        </form>
    </div>
    <div class="modal-footer">
        <button class="btn close_btn" data-dismiss="modal" aria-hidden="true">关闭</button>
        <button class="btn btn-primary green" id="file_type_up_btn">提交</button>
    </div>


</div>
<!--end upload file -->
<!--begin upload filetype-->
<div id="upload_file_modal" class="modal hide">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">上传文件</h3>
    </div>
    <div class="modal-body ">

        <form class="form-horizontal" name="file_up" action="plan/up_file" method="post" enctype="multipart/form-data">
            <fieldset>
                <div class="control-group">

                    <!-- Select Basic -->
                    <label class="control-label">文件类型</label>

                    <div class="controls">
                        <select class="input-xlarge .type_id" name="soft_type_id">
                            <c:forEach items="${softTypeList}" var="sotyType" >
                                <option value="${sotyType.softTypeId}">${sotyType.softTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="control-group">
                    <label class="control-label">选择文件</label>
                    <!-- File Upload -->
                    <div class="controls">
                        <input class="input-file" id="fileInput" type="file" name="upfile">
                    </div>

                </div>
                <div class="control-group">
                    <label class="control-label">备注</label>
                    <!-- File Upload -->
                    <div class="controls">
                        <input name="reMark" placeholder="有什么要补充的" class="input-xlarge">
                    </div>

                </div>
            </fieldset>

        </form>
    </div>
    <div class="modal-footer">
        <button class="btn close_btn" data-dismiss="modal" aria-hidden="true">关闭</button>
        <button class="btn btn-primary green" id="file_up" data-loading-text="Loading...">提交</button>
    </div>


</div>
<!--end upload filetype -->


<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

<!-- BEGIN PAGE CONTAINER-->

<div class="container-fluid">

<!-- BEGIN PAGE HEADER-->

<div class="row-fluid">
    <div class="span12">

        <!-- BEGIN STYLE CUSTOMIZER -->

        <!-- END BEGIN STYLE CUSTOMIZER -->

        <!-- BEGIN PAGE TITLE & BREADCRUMB-->

        <h3 class="page-title">编辑计划单
            <small></small>    <span class="text-error controls">${msg}</span>
        </h3>
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="index">主页</a> <i class="icon-angle-right"></i></li>
            <li><a href="#">模块计划单</a> <i class="icon-angle-right"></i></li>
            <li><a href="#">编辑计划单</a></li>
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
                <div class="caption"><i class="icon-reorder"></i>计划单 <span class="step-title"></span></div>
                <div class="tools hidden-phone"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                                data-toggle="modal"
                                                                                                class="config"></a> <a
                        href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" name="project_info" method="POST" action="plan/update_module_base">
                    <div class="alert alert-info"><strong>第一步!</strong> 基本信息</div>
                    <input class="hidden" type="text" name="proPlanId" value="${project.proPlanId}">

                    <div class="controls-row">
                        <label class="span2 control-label">计划单号</label>
                        <input class="span2 m-wrap required" type="text" name="moduleProId" value="${project.moduleProId}">
                        <label class="span2 control-label">计划人</label>
                        <input class="span2 m-wrap" type="text" name="proCreateUser"
                               value="${userMap.module_plan_create}">
                        <label class="span2 control-label">计划来源</label>
                        <input class="span2 m-wrap" type="text" name="proSource" value="${project.proSource}">
                    </div>

                    <div class="controls-row">
                        <label class="span2 control-label">加工厂商</label>
                        <input class="span2 m-wrap" type="text" name="proceManu" value="${project.proceManu}">

                        <label class="span2 control-label">REV版本</label>
                        <input class="span2 m-wrap" type="text" name="revVersion" value="${project.REVVversion}">

                        <label class="span2 control-label">生产机型</label>
                        <input class="span2 m-wrap" type="text" name="mkType" value="${project.mkType}">

                    </div>

                    <div class="controls-row">
                        <label class="span2 control-label">加工总数</label>
                        <input class="span2 m-wrap" type="text" name="proceCount" value="${project.proceCount}">

                        <label class="span2 control-label">完成时间</label>
                        <input class="span2 m-wrap timepicker required" type="text" readonly
                               data-date-format="yyyy-mm-dd hh:ii:ss" name="accomplishDate"
                               value="${project.accomplishDate}">
                    </div>

                    <div class="space20"></div>
                    <div class="alert alert-info"><strong>第二步!</strong>装配、包装信息</div>
                    <div class="controls-row">
                        <label class="span2 control-label">产品代码</label>
                        <input class="span2 m-wrap required" type="text" name="packProCode"
                               value="${project.packProCode}">
                        <label class="span2 control-label">产品名称</label>
                        <input class="span2 m-wrap" type="text" name="packProName" value="${project.packProName}">
                        <label class="span2 control-label">是否批量质检</label>
                        <select class="m-wrap span2" name="packIsCheck">
                            <c:choose>
                                <c:when test="${project.packIsCheck}">
                                    <option value="false">否</option>
                                    <option value="true" selected="selected">是</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="false" selected="selected">否</option>
                                    <option value="true" >是</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">升级软件版本</label>
                        <input class="span6 m-wrap" type="text" name="packSoftwareNo" value="${project.packSoftwareNo}">
                        <label class="span2 control-label">是否定制标贴</label>
                        <select class="m-wrap span2" name="packIsBiaotie">
                            <c:choose>
                                <c:when test="${project.packIsBiaotie == '是'}">
                                    <option value="否" >否</option>
                                    <option value="是" selected="selected">是</option>
                                    <option value="不定制">不定制(通用版)</option>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${project.packIsBiaotie == '否'}">
                                            <option value="否" selected="selected">否</option>
                                            <option value="是" >是</option>
                                            <option value="不定制">不定制(通用版)</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="否">否</option>
                                            <option value="是">是</option>
                                            <option value="不定制" selected="selected">不定制(通用版)</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>

                        </select>
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">是否修改波特率</label>
                        <select class="m-wrap span2" name="packUpdateRate">
                            <c:choose>
                                <c:when test="${project.packUpdateRate}">
                                    <option value="false">否</option>
                                    <option value="true" selected="selected">是</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="false" selected="selected">否</option>
                                    <option value="true" >是</option>
                                </c:otherwise>
                            </c:choose>

                        </select>
                        <label class="span2 control-label">波特率修改为</label>
                        <input class="span2 m-wrap" type="text" name="packBaudRate" value="${project.packBaudRate}">

                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">IMEI号</label>
                        <input class="span6 m-wrap" type="text" name="packImeiStart" value="${project.packImeiStart}">
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">标贴料号</label>
                        <input class="span2 m-wrap" type="text" name="packBiaotieNo" value="${project.packBiaotieNo}">
                        <label class="span2 control-label">碳带料号</label>
                        <input class="span2 m-wrap" type="text" name="packTangdaiNo" value="${project.packTangdaiNo}">
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">SN号开始</label>
                        <input class="span2 m-wrap" type="text" name="proSnStart" value="${project.proSnStart}">
                        <label class="span2 control-label">SN号结尾</label>
                        <input class="span2 m-wrap" type="text" name="proSnEnd" value="${project.proSnEnd}">
                    </div>
                    <div class="alert alert-info"><strong>第三步!</strong>人员信息</div>
                    <div class="controls-row">
                        <label class="span2 control-label">配置文件</label>
                        <input class="span4 m-wrap users required" type="text" name="confUser" value="${userMap.module_plan_conf}"/>
                        <label class="span2 control-label ">生产技术</label>
                        <input class="span4 m-wrap users required" type="text" name="proTechUser"
                               value="${userMap.module_plan_pro_info}"/>
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">软件经理</label>
                        <input class="span4 m-wrap users required" type="text" name="softManUser"
                               value="${userMap.module_plan_soft_man}"/>
                        <label class="span2 control-label">项目经理</label>
                        <input class="span4 m-wrap users required" type="text" name="proManUser"
                               value="${userMap.module_plan_pro_mana}"/>
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">抄送</label>
                        <input class="span9 m-wrap" type="text" placeholder="输入需要抄送的邮箱账号，用‘,’隔开" name="sendEmail"
                               value="${project.sendEmail}">
                    </div>
                    <c:if test="${userTypeId == Constants.PLAN_STATE_BASE && project.proStateTypeByProPlanStateId.proPlanStateId == Constants.PLAN_STATE_BASE}">
                    <div class="form-actions ">
                        <button type="submit" class="btn blue submit_project"><i class="icon-ok"></i> 提交</button>
                        <button type="reset" class="btn">取消</button>
                    </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- END PAGE CONTENT-->

<!-- BEGIN 配置文件-->

<div class="row-fluid">
    <div class="span6">
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>配置文件<span class="step-title"></span></div>
                <div class="tools hidden-phone"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                                data-toggle="modal"
                                                                                                class="config"></a> <a
                        href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" name="conf_form" action="plan/create_conf" method="post" enctype="multipart/form-data">
                    <input class="hidden" type="text" name="moduleProId" value="${project.moduleProId}">
                    <input class="hidden" type="text" name="confFileId"
                           value=" ${project.confInfoByConfFileId.confFileId}">
                    <fieldset>

                        <div class="control-group">
                            <!-- Text input-->
                            <label class="control-label">点击下载</label>

                            <div class="controls">
                                <p class="help-block">
                                    <a href="${project.confInfoByConfFileId.confPath}" class="btn red">${project.confInfoByConfFileId.confFileName}</a>

                                </p>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">配置文件</label>

                            <div class="controls">
                                <div class="fileupload fileupload-new" data-provides="fileupload">
                                    <div class="input-append">
                                        <div class="uneditable-input"><i class="icon-file fileupload-exists"></i> <span
                                                class="fileupload-preview"></span></div>
                          <span class="btn btn-file"> <span class="fileupload-new">选择文件</span> <span
                                  class="fileupload-exists">更换</span>
                          <input type="file" class="default required" name="confPath"
                                 >
                          </span> <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">备注</label>

                            <div class="controls">
                                <input type="text" placeholder="有什么要补充的" class="input-xlarge" name="remark"
                                       value="${project.confInfoByConfFileId.remark}">

                                <p class="help-block"></p>
                            </div>
                        </div>

                    </fieldset>
                    <c:if test="${userTypeId == Constants.PLAN_STATE_CONF && project.proStateTypeByProPlanStateId.proPlanStateId ==  Constants.PLAN_STATE_CONF}">
                    <div class="form-actions ">
                        <button type="submit" class="btn blue"><i class="icon-ok"></i> 提交</button>
                        <button type="reset" class="btn">取消</button>
                    </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>

    <!-- END 配置文件-->

    <!--贴片信息 -->

    <div class="span6">
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>SMT贴片信息 <span class="step-title"></span></div>
                <div class="tools hidden-phone"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                                data-toggle="modal"
                                                                                                class="config"></a> <a
                        href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" action="plan/create_smt" method="post">
                    <fieldset>
                        <input class="hidden" type="text" name="moduleProId" value="${project.moduleProId}">

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">PCB名称</label>

                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="pcbName"
                                       value="${project.smtTiepianInfoBySmtId.pcbName}">

                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">PCBA代码</label>

                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="pcbaCode"
                                       value="${project.smtTiepianInfoBySmtId.pcbaCode}">

                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">硬件版本</label>

                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="hardwareEditon"
                                       value="${project.smtTiepianInfoBySmtId.hardwareEditon}">

                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">光绘贴片文件</label>

                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="tiepianFile"
                                       value="${project.smtTiepianInfoBySmtId.tiepianFile}">

                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">PCB加工料单</label>

                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="pcbLiaodan"
                                       value="${project.smtTiepianInfoBySmtId.pcbLiaodan}">

                                <p class="help-block"></p>
                            </div>
                        </div>
                    </fieldset>
                    <c:if test="${userTypeId ==  Constants.PLAN_STATE_PROTECH && project.proStateTypeByProPlanStateId.proPlanStateId == Constants.PLAN_STATE_PROTECH}">
                    <div class="form-actions ">
                        <button type="submit" class="btn blue"><i class="icon-ok"></i> 提交</button>
                        <button type="reset" class="btn">取消</button>
                    </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 贴片信息结束-->

<!-- BEGIN 软件信息-->

<div class="row-fluid">
    <div class="span12">
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>软件信息<span class="step-title"></span></div>
                <div class="tools hidden-phone">
                    <c:if test="${userTypeId == 3}">
                    <a href="#upload_file_modal" role="button" class="btn red" data-toggle="modal">上传</a>
                        <a href="#add_file_type" role="button" class="btn blue" data-toggle="modal">添加类别</a>
                        </c:if>
                        <a href="javascript:;"class="collapse"></a>
                    <a href="#portlet-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
            </div>
            <div class="portlet-body">
                <div class="alert alert-error"><strong>提示!</strong>按键盘下键,或者删除文字,选择软件。如果没有合适的文件，请先上传。</div>
                <form class="form-horizontal" action="plan/add_soft_list" method="post">
                    <input class="hidden" type="text" name="moduleProId" value="${project.moduleProId}">
                    <table class="responsive table table-bordered">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>文件类别</th>
                            <th>文件名(从服务器选择已经上传的文件)</th>
                            <th>下载</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="soft" items="${softList}" varStatus="s">
                            <tr>
                                <td>${s.index+1}</td>
                                <td>${soft.softwareInfoByProSoftwareId.softwareTypeBySoftTypeId.softTypeName}</td>
                                <td><input type="text" name="auto_soft_type"
                                           value="${soft.softwareInfoByProSoftwareId.softName}"
                                           typeId="${soft.softwareInfoByProSoftwareId.softwareTypeBySoftTypeId.softTypeId}"/>
                                    <input type="text" class="span1 hidden" name="soft_id"
                                           value="${soft.softwareInfoByProSoftwareId.proSoftwareId}"/>
                                    <input type="text" class="span1 hidden" name="real_path"
                                           value="${soft.softwareInfoByProSoftwareId.softwarePath}"/>
                                </td>
                                <td><a class="btn green" name="download_file" href="${soft.softwareInfoByProSoftwareId.softwarePath}">下载</a></td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${userTypeId == Constants.PLAN_STATE_PROTECH && project.proStateTypeByProPlanStateId.proPlanStateId == Constants.PLAN_STATE_PROTECH}">
                    <div class="form-actions ">
                        <button type="submit" class="btn blue"><i class="icon-ok"></i> 提交</button>
                        <button type="reset" class="btn">取消</button>
                    </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- END 软件信息-->
<!--生产信息 -->
<!--生产信息 -->
<div class="row-fluid">
<div class="span12">
<div class="portlet box green">
<div class="portlet-title">
    <div class="caption"><i class="icon-reorder"></i>生产信息<span class="step-title"></span></div>
    <div class="tools hidden-phone"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                    data-toggle="modal"
                                                                                    class="config"></a> <a
            href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
</div>
<div class="portlet-body">
<form class="form-horizontal" action="plan/create_manu" method="post">
<input class="hidden" type="text" name="moduleProId" value="${project.moduleProId}">
<fieldset>
<div class="control-group">
    <label class="control-label">生产工序</label>

    <!-- Multiple Checkboxes -->
    <div class="controls">
        <!-- Inline Checkboxes -->
        <c:choose>
            <c:when test="${proces[0]}">
                <label class="checkbox inline">
                    <input type="checkbox" value="1" name="manuProcedure" checked="checked">
                    SMT </label>

            </c:when>
            <c:otherwise>
                <label class="checkbox inline">
                    <input type="checkbox" value="1" name="manuProcedure">
                    SMT </label>

            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${proces[1]}">
                <label class="checkbox inline">
                    <input type="checkbox" value="2" name="manuProcedure" checked="checked">
                    升级 </label>

            </c:when>
            <c:otherwise>
                <label class="checkbox inline">
                    <input type="checkbox" value="2" name="manuProcedure">
                    升级 </label>

            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${proces[2]}">
                <label class="checkbox inline">
                    <input type="checkbox" value="3" name="manuProcedure" checked="checked">
                    装配 </label>

            </c:when>
            <c:otherwise>

                <label class="checkbox inline">
                    <input type="checkbox" value="3" name="manuProcedure">
                    装配 </label>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${proces[3]}">
                <label class="checkbox inline">
                    <input type="checkbox" value="4" name="manuProcedure" checked="checked">
                    测试 </label>

            </c:when>
            <c:otherwise>

                <label class="checkbox inline">
                    <input type="checkbox" value="4" name="manuProcedure">
                    测试 </label>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${proces[4]}">
                <label class="checkbox inline">
                    <input type="checkbox" value="5" name="manuProcedure" checked="checked">
                    包装 </label>

            </c:when>
            <c:otherwise>

                <label class="checkbox inline">
                    <input type="checkbox" value="5" name="manuProcedure">
                    包装 </label>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${proces[5]}">

                <label class="checkbox inline">
                    <input type="checkbox" value="6" name="manuProcedure" checked="checked">
                    其他 </label>

            </c:when>
            <c:otherwise>

                <label class="checkbox inline">
                    <input type="checkbox" value="6" name="manuProcedure">
                    其他 </label>

            </c:otherwise>
        </c:choose>


    </div>
</div>
<div class="control-group">
    <label class="control-label">生产技术状态</label>

    <div class="controls">
        <!-- Inline Radios -->
        <label class="radio inline">
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='实验版'}">
                <label class="radio inline">
                <input type="radio" value="实验版" name="manuState" checked="checked"/>
                实验版 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                    <input type="radio" value="实验版" name="manuState">
                    实验版 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='预测试'}">
                    <label class="radio inline">
                        <input type="radio" value="预测试" name="manuState" checked="checked"/>
                        预测试 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="预测试" name="manuState">
                        预测试 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='中试'}" >
                    <label class="radio inline">
                        <input type="radio" value="中试" name="manuState" checked="checked"/>
                        中试 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="中试" name="manuState"/>
                        中试 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='批量'}">
                    <label class="radio inline">
                        <input type="radio" value="批量" name="manuState" checked="checked"/>
                        批量 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="批量" name="manuState"/>
                        批量 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='重工'}">
                    <label class="radio inline">
                        <input type="radio" value="重工" name="manuState" checked="checked"/>
                        重工 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="重工" name="manuState"/>
                        重工 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState == '其他'}" >
                    <label class="radio inline">
                        <input type="radio" value="其他" name="manuState" checked="checked"/>
                        其他 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="其他" name="manuState"/>
                        其他 </label>
                </c:otherwise>
            </c:choose>
    </div>
</div>
<div class="control-group">
    <label class="control-label">是否返工生产</label>

    <div class="controls">
        <!-- Inline Radios -->
        <c:choose>
            <c:when test="${project.manuInfoByManuInfoId.reback}">
                <label class="radio inline">
                    <input type="radio" value="false" name="isReback"/>
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isReback" checked="checked"/>
                    是 </label>
            </c:when>
            <c:otherwise>
                <label class="radio inline">
                    <input type="radio" value="false" name="isReback" checked="checked"/>
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isReback"/>
                    是 </label>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<div class="control-group">

    <!-- Text input-->
    <label class="control-label">返工原因</label>

    <div class="controls">
        <input type="text" placeholder="原因/或者返工流程" class="input-xlarge span8" name="rebackInfo"
               value="${project.manuInfoByManuInfoId.rebackInfo}"/>

        <p class="help-block"></p>
    </div>
</div>
<div class="control-group">

    <!-- Text input-->
    <label class="control-label">变更信息</label>

    <div class="controls">
        <input type="text" placeholder="" class="input-xlarge span8" name="updateInfo"
               value="${project.manuInfoByManuInfoId.updateInfo}"/>

        <p class="help-block"></p>
    </div>
</div>
<div class="control-group">
    <label class="control-label">是否复检</label>

    <div class="controls">


        <c:choose>
            <c:when test="${project.manuInfoByManuInfoId.backCheck}">
                <label class="radio inline">
                    <input type="radio" value="false" name="isBackCheck"/>
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isBackCheck" checked="checked"/>
                    是 </label>
            </c:when>
            <c:otherwise>
                <label class="radio inline">
                    <input type="radio" value="false" name="isBackCheck" checked="checked"/>
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isBackCheck"/>
                    是 </label>
            </c:otherwise>
        </c:choose>


    </div>
</div>
<div class="control-group">

    <!-- Textarea -->
    <label class="control-label">生产注意</label>

    <div class="controls">
        <div class="textarea">
            <textarea type="" class=" span9" rows="14" name="manuNotice">
                ${project.manuInfoByManuInfoId.manuNotice}
            </textarea>
        </div>
    </div>
</div>
</fieldset>
<c:if test="${userTypeId == Constants.PLAN_STATE_PROTECH && project.proStateTypeByProPlanStateId.proPlanStateId == Constants.PLAN_STATE_PROTECH}">
<div class="form-actions ">
    <button type="submit" class="btn blue"><i class="icon-ok"></i> 提交</button>
    <button type="reset" class="btn">取消</button>
</div>
</c:if>
</form>
</div>
</div>
</div>
</div>
<!--生产技术结束 -->


<div class="row-fluid">
    <div class="span12">
        <div class="portlet box green">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>处理环节<span class="step-title"></span></div>
                <div class="tools hidden-phone"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                                data-toggle="modal"
                                                                                                class="config"></a> <a
                        href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
            </div>
            <div class="portlet-body">
                <div class="alert alert-error"><strong>提示!</strong>选择'同意',处理意见和处理人都无效。选择'不同意',则请输入处理意见，指定处理人。</div>
                <form class="form-horizontal">

                    <table class="responsive table table-bordered">
                        <thead>
                        <tr>
                            <th>处理类别</th>
                            <th>计划单角色</th>
                            <th>是否通过</th>
                            <th>处理意见</th>
                            <th>退回给：</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="pu" items="${planUserList}" varStatus="s">
                            <tr class="shenpi_tr">
                                <td>${pu.planUserTypeByPlanUserTypeId.planUserDesc}

                                </td>
                                <td> <a href="#" class="btn" rel="popoverTop" data-content="邮箱:${pu.usersByUserId.email}<br/>手机:${pu.usersByUserId.phone}" title="真名:${pu.usersByUserId.trueName}" data-html="true" data-original-title="Popover on top">${pu.usersByUserId.userName}</a></td>
                                <td class=""><select class="" style="width: 100px;" name="isPass">
                                    <c:choose>
                                        <c:when test="${pu.pass}">
                                            <option value="true" selected="selected">同意</option>
                                            <option value="false">不同意</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="false" selected="selected">不同意</option>
                                            <option value="true">同意</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                                    <input type="text" class="hidden" style="width: 1px;" name="planUserListId1" value="${pu.planUserListId1}"/>
                                    <input type="text" class="hidden" style="width: 1px;" name="currState" value="${s.index+1}"/>
                                </td>
                                <td><input value="${pu.dealAdvice}" class="input" name="dealAdvice"/></td>
                                <td> <select class="dealUser" name="dealUser">
                                    <option value="">请选择</option>
                                    <c:forEach items="${uselist}" var="user" varStatus="s2">
                                        <!----只能提交给 之前的人处理--->

                                        <c:if test="${( s.index >= s2.index)&&(user!=pu.usersByUserId.userName)}">
                                            <c:choose>
                                            <c:when test="${user == pu.dealUser }">
                                            <option value="${user}" selected="selected">
                                                     ${user}
                                            </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${user}">
                                                      ${user}
                                                </option>
                                            </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>
                                </select></td>
                                <td>  <c:if test="${userTypeId == s.index+1 && project.proStateTypeByProPlanStateId.proPlanStateId == s.index+1}"> <a class="btn blue shenpi_btn">确定</a></c:if></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- 生产信息结束--
</div>
<!-- END PAGE CONTAINER-->

</div>

<!-- END PAGE -->


</div>
<%@include file="../inc/footer.jsp" %>

<script type="text/javascript" src="js/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="js/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script src="js/script/my.js"></script>
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

    });
    (function(){
        $(document).ready(function(){
            $("ul.page-sidebar-menu li").removeClass("active");
            $("ul.page-sidebar-menu li.modul_plan").addClass("active");
        });
    })($);

</script>
<!-- END CONTAINER -->
<script>
    (function () {
        $(document).ready(function () {
            $("#file_up").bind("click", function () {
                //  $("form[name='file_up']").submit();
                $(".up_msg").remove();
                $("form[name='file_up']").ajaxSubmit({
                    success: function (msg) {//文件上传成功后执行,msg为服务器端返回的信息
                        $(".close_btn").before("<div class='alert alert-success up_msg'> <strong>" + msg + "</strong></div>");
                    }
                });
                return false;	//防止刷新？
            });
            $("#file_type_up_btn").bind("click", function () {
                $(".up_msg").remove();
                $("form[name='add_file_type']").ajaxSubmit({
                    success: function (msg) {//文件上传成功后执行,msg为服务器端返回的信息
                        $(".close_btn").before("<div class='alert alert-success up_msg'> <strong>" + msg + "</strong></div>");
                        location.reload();
                    }
                });
                return false;	//防止刷新？
            });
        });
        var input;
        $("input[name='auto_soft_type']").bind("focus", function () {
            input = $(this);
        });
        $("input[name='auto_soft_type']").autocomplete({

            source: function (request, response) {
                var soft_type_id = input.attr("typeId");
                var mydata = {"soft_type": soft_type_id};

                //alert(softId)  ;
                $.ajax({
                    url: "plan/getSoftList",
                    dataType: "json",
                    type: 'post',
                    data: mydata,
                    success: function (data) {
                        response($.map(data.softWareList, function (item) {
                            return {
                                label: item.proSoftwareId + ", " + item.softName + ", " + ", " + (item.softRemark == null ? '' : item.softRemark),
                                value: item.softName,
                                id: item.proSoftwareId,
                                down_filePath:item.softwarePath
                            }
                        }));
                    }
                });
            },
            minLength: 0,
            select: function (event, ui) {
                // alert($(this).parent().children("input[name='soft_id']").val());
                // alert(ui.item.id)
                var type_id = isNaN(ui.item.id) ? 0 : ui.item.id;
                $(this).parent().children("input[name='soft_id']").val(type_id);       //软件编号
                $(this).parent().parent().children().children("a[name='download_file']").attr("href",ui.item.down_filePath);
            },
            open: function () {
                $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });

        //审批提交表单
        $(".shenpi_btn").bind("click",function(){
            var element = $(this).parent().parent().children();
                var data = {
                    'planUserListId1':element.children("input[name='planUserListId1']").val(),
                    'currState':element.children("input[name='currState']").val(),
                     'isPass':element.children("select[name='isPass']").val(),
                    'dealAdvice':element.children("input[name='dealAdvice']").val(),
                    'dealUser':element.children("select[name='dealUser']").val()
                };
            if(data.isPass=='false' && data.dealUser==''){
                alert("您选择了'不同意'，请指定处理人来处理这个问题");
               return;
            }
            alert("点击确定后提交,我们将发送邮件给下一个处理人。等耐心等待几秒")
               // alert(data.planUserListId1+"\t"+data.currState+"\t "+data.isPass+"\t"+data.dealAdvice+"\t "+data.dealUser);
            $.post(
                    'plan/shenpi',
                    data,
                    function(data){
                        if(data.result == false){
                            alert(data.msg);
                        }
                        location.href="plan/plan-list-deal";
                    },
                    'json'
            );

        });
        $("form[name='conf_form']").submit(function(){
            var confile = $("input[name='confPath']").val();
            if(confile==null || confile==''){
                alert("请选择一个文件");
                return false;
            }
        });
    })($);
</script>
</body>

<!-- END BODY -->

</html>