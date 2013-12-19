<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../part/header.jsp" %>
<title>手机找回</title>
<%@include file="../part/inc_css.jsp"%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KbXxnIeyHBwxBC8KAn4RYgmd"></script>
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<link  rel="stylesheet"  href="<c:url value='css/findphone.css'/>"/>
</head>
<body>
<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">innos云</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="" class="navbar-brand">innos云</a>
        </div>
        <nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation" style="height: 1px;">
            <ul class="nav navbar-nav">
                <li>
                    <a href="../getting-started">手机找回</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right dropdown">
                <li>
                    <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown"><shiro:principal></shiro:principal><b class="caret"></b></a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="drop3">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</header>

<section class="container mapCenter">
    <div id="allmap" class="col-lg-11"></div>
    <div id="control" class="col-lg-1">
      <div class="find-phone-container">
            <div class="my-device">
                <div class="my-device-info">
                    <div class="device-name">${defaultPhone.phoneModel}</div>
                    <input type="text" class="hidden" value="${defaultPhone == null}" name="phoneNull">
                    <input type="text" class="hidden" value="${defaultPhone.imeiNo}" name="imei">
                    <p class="fpc-intro">
                        <em id="phoneNumber">${defaultPhone.phoneNo}</em>
                        <br/>
                        <span class="fpc-note-area" id="phone_view_log">
                            <span id="phone_online_status">离线</span>
                            <span id="phone_operation_info" class="fpc-note-area2" title=""></span>
                        </span>
                    </p></div></div>

            <div class="fp-icobtn clearfix">
                <input type="button" class="motion position btn btn-primary  btn-block" value="定位"/>
                <button type="button" class="btn btn-default btn-small" data-toggle="modal" data-target="#sendVoice">
                    <span class="glyphicon glyphicon-volume-up"></span> <span class="motion">发声</span>
                </button>
                <button type="button" class="btn btn-default btn-small" id="lock" data-toggle="modal" data-target="#lockPhoneModal">
                    <span class="glyphicon glyphicon-lock"></span> 锁定
                </button>
                <button type="button" class="btn btn-default btn-small" id="clean" >
                    <span class="glyphicon glyphicon-trash"></span> 擦除
                </button>
            </div>
        </div>
    </div>
</section>

<!-- 模态 -->
<div class="modal fade " id="modal_Message">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">
                <h4 id="message_Body"></h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger submit" data-show="true" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div class="modal fade " id="choosePhone">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">选择一个设备</h4>
            </div>
            <div class="modal-body">
                  <c:forEach items="${phoneList}" var="phoneInfo">
                      <input type='button' class='btn_imei_choose btn btn-primary' value="${phoneInfo.imeiNo}"/>
                  </c:forEach>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<div class="modal fade " id="sendVoice">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">发声</h4>
            </div>
            <div class="modal-body">
                <p>您的手机将会以最大音量发声。</p>
                <p class="pm-p">在这个过程中手机音量控制键无效，但解锁后声音将停止。</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="btn_open_voice" class="btn btn-success" data-dismiss="modal">发声</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<div class="modal fade " id="lockPhoneModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">手机锁定</h4>
            </div>
            <div class="modal-body">
                <h4>设置密码锁定您的手机，别人需要正确输入密码才能使用和查看您的手机。</h4>
                <div class="form-group">
                    <label class="control-label" for="lockPassword">8-16位数字</label>
                    <input type="text" id="lockPassword" class="col-lg-7" placeholder="请设置锁定密码:" maxlength="16" required="true"/>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="btn_lock_phone" class="btn btn-success">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<%@include file="../part/inc_js.jsp"%>
<script src="<c:url value='js/baidu-map.js'/>" type="text/javascript"></script>
<script src="<c:url value='js/moment.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='js/lang/zh-cn.js'/>" type="text/javascript"></script>
<script type="text/javascript">
</script>
</body>
</html>