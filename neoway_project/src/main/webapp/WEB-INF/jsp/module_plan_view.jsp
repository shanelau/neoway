<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp" %>


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

    <link rel="stylesheet" type="text/css" href="/css/datetimepicker.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-fileupload.css"/>

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
<%@include file="inc/top.jsp" %>

<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container">

<!-- BEGIN SIDEBAR -->
<%@include file="inc/leftmenu.jsp" %>

<!-- END SIDEBAR -->

<!-- BEGIN PAGE -->

<!-- BEGIN PAGE -->

<div class="page-content">


<!-- BEGIN PAGE CONTAINER-->

<div class="container-fluid">

<!-- BEGIN PAGE HEADER-->

<div class="row-fluid">
    <div class="span12">

        <!-- BEGIN STYLE CUSTOMIZER -->

        <!-- END BEGIN STYLE CUSTOMIZER -->

        <!-- BEGIN PAGE TITLE & BREADCRUMB-->

        <h3 class="page-title">计划单预览
            <small></small>
        </h3>
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="index.jsp">主页</a> <i class="icon-angle-right"></i></li>
            <li><a href="#">模块计划单</a> <i class="icon-angle-right"></i></li>
            <li><a href="#">计划单预览</a></li>
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
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" name="project_info" method="POST" action="/plan/create_module">
                    <div class="alert alert-info"><strong>第一步!</strong> 基本信息</div>
                    <input class="hidden" type="text" name="proPlanId" value="${project.proPlanId}">

                    <div class="controls-row">
                        <label class="span2 control-label">计划单号</label>
                        <input class="span2 m-wrap" type="text" name="moduleProId" value="${project.moduleProId}">
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
                        <input class="span4 m-wrap " type="text" readonly
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
                        <label class="span2 control-label">发货地</label>
                        <input class="span2 m-wrap" type="text" name="packResource" value="${project.packResource}">
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">升级软件版本</label>
                        <input class="span6 m-wrap" type="text" name="packSoftwareNo" value="${project.packSoftwareNo}">
                        <label class="span2 control-label">整机装配料单</label>
                        <input class="span2 m-wrap" type="text" name="packPeiliao" value="${project.packPeiliao}">
                    </div>
                        <div class="controls-row">
                            <label class="span2 control-label">彩盒包装料单</label>
                            <input class="span2 m-wrap" type="text" name="packCaihe" value="${project.packCaihe}">
                            <label class="span2 control-label">大卡通包装料单</label>
                            <input class="span2 m-wrap" type="text" name="packDakat" value="${project.packDakat}">
                            <label class="span2 control-label">是否定制标贴</label>
                            <input class="span2 m-wrap" type="text" name="packDakat" value="${project.packIsBiaotie}">
                        </div>
                    <div class="controls-row">
                        <label class="span2 control-label">是否修改波特率</label>
                            <c:choose>
                                <c:when test="${project.packUpdateRate}">
                                    <input class="span2 m-wrap" type="text" value="是"/>
                                </c:when>
                                <c:otherwise>
                                    <input class="span2 m-wrap" type="text" value="否"/>
                                </c:otherwise>
                            </c:choose>

                        <label class="span2 control-label">波特率修改为</label>
                        <input class="span2 m-wrap" type="text" name="packBaudRate" value="${project.packBaudRate}">
                        <label class="span2 control-label">是否批量质</label>
                            <c:choose>
                                <c:when test="${project.packIsCheck}">
                                    <input class="span2 m-wrap" type="text" value="是"/>
                                </c:when>
                                <c:otherwise>
                                    <input class="span2 m-wrap" type="text" value="否"/>
                                </c:otherwise>
                            </c:choose>
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">IMEI起始</label>
                        <input class="span2 m-wrap" type="text" name="packImeiStart" value="${project.packImeiStart}">
                        <label class="span2 control-label">IMEI结尾</label>
                        <input class="span2 m-wrap" type="text" name="packImeiEnd" value="${project.packImeiEnd}">
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
                        <input class="span4 m-wrap" type="text" name="confUser" value="${userMap.module_plan_conf}">
                        <label class="span2 control-label">生产技术</label>
                        <input class="span4 m-wrap" type="text" name="proTechUser"
                               value="${userMap.module_plan_pro_info}">
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">软件经理</label>
                        <input class="span4 m-wrap" type="text" name="softManUser"
                               value="${userMap.module_plan_soft_man}">
                        <label class="span2 control-label">项目经理</label>
                        <input class="span4 m-wrap" type="text" name="proManUser"
                               value="${userMap.module_plan_pro_mana}">
                    </div>
                    <div class="controls-row">
                        <label class="span2 control-label">抄送</label>
                        <input class="span10 m-wrap" type="text" placeholder="输入需要抄送的邮箱账号，用‘,’隔开" name="sendEmail"
                               value="${project.sendEmail}">
                    </div>
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
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" action="/plan/create_conf" method="post" enctype="multipart/form-data">
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
                            <!-- Text input-->
                            <label class="control-label">备注</label>

                            <div class="controls">
                                <input type="text" placeholder="有什么要补充的" class="input-xlarge" name="remark"
                                       value="${project.confInfoByConfFileId.remark}">

                                <p class="help-block"></p>
                            </div>
                        </div>

                    </fieldset>
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
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" action="/plan/create_smt" method="post">
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
            </div>
            <div class="portlet-body">
                <form class="form-horizontal" action="/plan/add_soft_list" method="post">
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
                                <td><a class="btn green" href="${soft.softwareInfoByProSoftwareId.softwarePath}">下载</a></td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
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
</div>
<div class="portlet-body">
<form class="form-horizontal" action="/plan/create_manu" method="post">
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
                <input type="radio" value="实验版" name="manuState" checked="checked">
                实验版 </label>
                </c:when>
                <c:otherwise>
                    <input type="radio" value="实验版" name="manuState">
                    实验版 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='预测试'}">
                    <label class="radio inline">
                        <input type="radio" value="预测试" name="manuState" checked="checked">
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
                        <input type="radio" value="中试" name="manuState" checked="checked">
                        中试 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="中试" name="manuState">
                        中试 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='批量'}">
                    <label class="radio inline">
                        <input type="radio" value="批量" name="manuState" checked="checked">
                        批量 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="批量" name="manuState">
                        批量 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState=='重工'}">
                    <label class="radio inline">
                        <input type="radio" value="重工" name="manuState" checked="checked">
                        重工 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="重工" name="manuState">
                        重工 </label>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${project.manuInfoByManuInfoId.manuState == '其他'}" >
                    <label class="radio inline">
                        <input type="radio" value="其他" name="manuState" checked="checked">
                        其他 </label>
                </c:when>
                <c:otherwise>
                    <label class="radio inline">
                        <input type="radio" value="其他" name="manuState">
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
                    <input type="radio" value="false" name="isReback">
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isReback" checked="checked">
                    是 </label>
            </c:when>
            <c:otherwise>
                <label class="radio inline">
                    <input type="radio" value="false" name="isReback" checked="checked">
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isReback">
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
               value="${project.manuInfoByManuInfoId.rebackInfo}">

        <p class="help-block"></p>
    </div>
</div>
<div class="control-group">

    <!-- Text input-->
    <label class="control-label">变更信息</label>

    <div class="controls">
        ${project.manuInfoByManuInfoId.updateInfo}
    </div>
</div>
<div class="control-group">
    <label class="control-label">是否复检</label>

    <div class="controls">


        <c:choose>
            <c:when test="${project.manuInfoByManuInfoId.backCheck}">
                <label class="radio inline">
                    <input type="radio" value="false" name="isBackCheck">
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isBackCheck" checked="checked">
                    是 </label>
            </c:when>
            <c:otherwise>
                <label class="radio inline">
                    <input type="radio" value="false" name="isBackCheck" checked="checked">
                    否 </label>
                <label class="radio inline">
                    <input type="radio" value="true" name="isBackCheck">
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
           <p>
                ${project.manuInfoByManuInfoId.manuNotice}
           </p>
        </div>
    </div>
</div>
</fieldset>
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
            </div>
            <div class="portlet-body">
                <form class="form-horizontal">

                    <table class="responsive table table-bordered">
                        <thead>
                        <tr>
                            <th>处理类别</th>
                            <th>计划单角色</th>
                            <th>是否通过</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="pu" items="${planUserList}" varStatus="s">
                            <tr class="shenpi_tr">
                                <td>${pu.planUserTypeByPlanUserTypeId.planUserDesc}
                                </td>
                                <td> <a href="#" class="btn" rel="popoverTop" data-content="邮箱:${pu.usersByUserId.email}" title="手机:${pu.usersByUserId.phone}" data-original-title="Popover on top">${pu.usersByUserId.userName}</a></td>
                                <td class="">
                                    <c:choose>
                                        <c:when test="${pu.pass}">
                                            同意
                                        </c:when>
                                        <c:otherwise>
                                            不同意
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                                </td>

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
<%@include file="inc/footer.jsp" %>
<script src="/js/script/my.js"></script>
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

    });
    (function(){
        $(document).ready(function(){
            $("input").attr("readonly","readonly");
        });
    })($);

</script>
<!-- END CONTAINER -->
</body>

<!-- END BODY -->

</html>