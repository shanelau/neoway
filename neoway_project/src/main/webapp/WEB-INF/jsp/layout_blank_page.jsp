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

            <h3 class="page-title">编辑计划单<small></small> </h3>
            <ul class="breadcrumb">
                <li> <i class="icon-home"></i> <a href="index.jsp">主页</a> <i class="icon-angle-right"></i> </li>
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
                    <form class=" form-horizontal">
                        <div class="alert alert-info"> <strong>第一步!</strong> 基本信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">计划单号</label>
                            <input class="span2 m-wrap required" type="text" >
                            <label class="span2 control-label">计划人</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">计划来源</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">加工厂商</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">REV版本</label>
                            <input class="span2 m-wrap required" type="text" >
                            <label class="span2 control-label">生产机型</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">加工总数</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">创建时间</label>
                            <input class="span2 m-wrap datetimepicker" type="text" readonly data-date-format="yyyy-mm-dd hh:ii:ss">
                            <label class="span2 control-label">完成时间</label>
                            <input class="span2 m-wrap datetimepicker" type="text" readonly data-date-format="yyyy-mm-dd hh:ii:ss">
                        </div>
                        <div class="space20"></div>
                        <div class="alert alert-info"> <strong>第二步!</strong>装配、包装信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">产品代码</label>
                            <input class="span2 m-wrap required" type="text" >
                            <label class="span2 control-label">产品名称</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">发货地</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">升级软件版本</label>
                            <input class="span6 m-wrap" type="text" >
                            <label class="span2 control-label">整机装配料单</label>
                            <input class="span2 m-wrap" type="text" >
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">彩盒包装料单</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">大卡通包装料单</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">是否定制标贴</label>
                            <select class="m-wrap span2">
                                <option value="">否</option>
                                <option value="">是</option>
                                <option value="">不定制(通用版)</option>
                            </select>
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">是否修改波特率</label>
                            <select class="m-wrap span2">
                                <option value="">否</option>
                                <option value="">是</option>
                            </select>
                            <label class="span2 control-label">波特率修改为</label>
                            <input class="span2 m-wrap" type="text" >
                            <label class="span2 control-label">是否批量质</label>
                            <select class="m-wrap span2">
                                <option value="">否</option>
                                <option value="">是</option>
                            </select>
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">IMEI起始</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">IMEI结尾</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">标贴料号</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">碳带料号</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">SN号开始</label>
                            <input class="span2 m-wrap" type="text">
                            <label class="span2 control-label">SN号结尾</label>
                            <input class="span2 m-wrap" type="text">
                        </div>
                        <div class="alert alert-info"> <strong>第三步!</strong>人员信息</div>
                        <div class="controls-row">
                            <label class="span2 control-label">配置文件</label>
                            <input class="span4 m-wrap" type="text">
                            <label class="span2 control-label">生产技术</label>
                            <input class="span4 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">软件经理</label>
                            <input class="span4 m-wrap" type="text">
                            <label class="span2 control-label">项目经理</label>
                            <input class="span4 m-wrap" type="text">
                        </div>
                        <div class="controls-row">
                            <label class="span2 control-label">抄送</label>
                            <input class="span10 m-wrap" type="text"  placeholder="输入需要抄送的邮箱账号，用‘,’隔开">
                        </div>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
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
                    <div class="caption"> <i class="icon-reorder"></i>配置文件<span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <form class="form-horizontal">
                        <fieldset>

                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">发布时间</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge datetimepicker">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">配置文件</label>
                                <div class="controls">
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
                                        <input type="hidden" value="" name="">
                                        <div class="input-append">
                                            <div class="uneditable-input"> <i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span> </div>
                          <span class="btn btn-file"> <span class="fileupload-new">选择文件</span> <span class="fileupload-exists">更换</span>
                          <input type="file" class="default" name="">
                          </span> <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">备注</label>
                                <div class="controls">
                                    <input type="text" placeholder="有什么要补充的" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>

                        </fieldset>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- END 配置文件-->

        <!--贴片信息 -->

        <div class="span6">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption"> <i class="icon-reorder"></i>SMT贴片信息 <span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">PCB名称</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">PCBA代码</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">硬件版本</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">光绘贴片文件</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">PCB加工料单</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                        </fieldset>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
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
                    <div class="caption"> <i class="icon-reorder"></i>软件信息<span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <div class="alert alert-info"> <strong>提示!</strong>选择系统保存过的文件，如果没有合适的文件，请先上传。</div>
                    <form class="form-horizontal">
                        <table class="responsive table table-bordered">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>文件类别</th>
                                <th>文件名(从服务器选择已经上传的文件)</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>烧录软件</td>
                                <td> <input type="text" id="url" value="" /> <a class="btn" id="insertfile" >选择文件</a>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>下载软件</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>软件下载工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>校准综测工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>写号工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>信息检查工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>包装工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>打印工具</td>
                                <td><input />
                                    <a class="btn">选择文件</a></td>
                                <td><a class="btn green">下载</a></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- END 软件信息-->
    <!--生产信息 -->
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption"> <i class="icon-reorder"></i>生产信息<span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">生产工序</label>

                                <!-- Multiple Checkboxes -->
                                <div class="controls">
                                    <!-- Inline Checkboxes -->
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="SMT">
                                        SMT </label>
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="升级">
                                        升级 </label>
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="装配">
                                        装配 </label>
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="测试">
                                        测试 </label>
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="包装">
                                        包装 </label>
                                    <label class="checkbox inline">
                                        <input type="checkbox" value="其他">
                                        其他 </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">生产技术状态</label>
                                <div class="controls">
                                    <!-- Inline Radios -->
                                    <label class="radio inline">
                                        <input type="radio" value="实验版" name="pro_tech_state" checked="checked">
                                        实验版 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="预测试" name="pro_tech_state">
                                        预测试 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="中试" name="pro_tech_state">
                                        中试 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="批量" name="pro_tech_state">
                                        批量 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="重工" name="pro_tech_state">
                                        重工 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="其他" name="pro_tech_state">
                                        其他 </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">是否返工生产</label>
                                <div class="controls">
                                    <!-- Inline Radios -->
                                    <label class="radio inline">
                                        <input type="radio" value="否" name="is_back_pro" checked="checked">
                                        否 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="是" name="is_back_pro">
                                        是 </label>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">返工原因</label>
                                <div class="controls">
                                    <input type="text" placeholder="原因/或者返工流程" class="input-xlarge span8">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Text input-->
                                <label class="control-label" for="input01">变更信息</label>
                                <div class="controls">
                                    <input type="text" placeholder="" class="input-xlarge span8">
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">是否复检</label>
                                <div class="controls">
                                    <!-- Inline Radios -->
                                    <label class="radio inline">
                                        <input type="radio" value="否" name="is_jc" checked="checked">
                                        否 </label>
                                    <label class="radio inline">
                                        <input type="radio" value="是" name="is_jc">
                                        是 </label>
                                </div>
                            </div>
                            <div class="control-group">

                                <!-- Textarea -->
                                <label class="control-label">生产注意</label>
                                <div class="controls">
                                    <div class="textarea">
                                        <textarea type="" class=" span9" rows="7" > </textarea>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <div class="form-actions ">
                            <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption"> <i class="icon-reorder"></i>处理环节<span class="step-title"></span> </div>
                    <div class="tools hidden-phone"> <a href="javascript:;" class="collapse"></a> <a href="#portlet-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                </div>
                <div class="portlet-body">
                    <form class="form-horizontal">
                        <table class="responsive table table-bordered">
                            <thead>
                            <tr>
                                <th>处理类别</th>
                                <th>处理人</th>
                                <th>处理结果</th>
                                <th>备注</th>
                                <th>退回给</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>配置文件</td>
                                <td><a class="btn">lix</a></td>
                                <td class=""><select class="">
                                    <option value="">未处理</option>
                                    <option value="">同意</option>
                                    <option value="">不同意</option>
                                </select></td>
                                <td><input value="" class="input"/></td>
                                <td><input value="" placeholder="输入要退回的用户邮箱"/></td>
                                <td><a class="btn blue">确定</a></td>
                            </tr>
                            <tr>
                                <td>生产技术</td>
                                <td><a class="btn">lix</a></td>
                                <td class=""><select class="">
                                    <option value="">未处理</option>
                                    <option value="">同意</option>
                                    <option value="">不同意</option>
                                </select></td>
                                <td><input value="" class="input"/></td>
                                <td><input value="" placeholder="输入要退回的用户邮箱"/></td>
                                <td><a class="btn blue">确定</a></td>
                            </tr>
                            <tr>
                                <td>软件经理</td>
                                <td><a class="btn">lix</a></td>
                                <td class=""><select class="">
                                    <option value="">未处理</option>
                                    <option value="">同意</option>
                                    <option value="">不同意</option>
                                </select></td>
                                <td><input value="" class="input"/></td>
                                <td><input value="" placeholder="输入要退回的用户邮箱"/></td>
                                <td><a class="btn blue">确定</a></td>
                            </tr>
                            <tr>
                                <td>项目经理</td>
                                <td><a class="btn">lix</a></td>
                                <td class=""><select class="">
                                    <option value="">未处理</option>
                                    <option value="">同意</option>
                                    <option value="">不同意</option>
                                </select></td>
                                <td><input value="" class="input"/></td>
                                <td><input value="" placeholder="输入要退回的用户邮箱"/></td>
                                <td><a class="btn blue">确定</a></td>
                            </tr>
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

    <!-- END PAGE -->

</div>
<%@include file="inc/footer.jsp"%>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="/js/bootstrap-fileupload.js"></script>
<script src="/js/script/my.js"></script>
<!-- END CONTAINER -->
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

    });

</script>
</body>

<!-- END BODY -->

</html>