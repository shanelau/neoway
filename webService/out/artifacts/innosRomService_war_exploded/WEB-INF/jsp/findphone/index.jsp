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


<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand hidden-sm" href="logout"><shiro:principal></shiro:principal></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="findphone/index" target="_blank">手机找回</a></li>
            </ul>
        </div>
    </div>
</div>

<section class="container center">
    <div id="allmap" class="col-lg-11"></div>
    <div id="control" class="col-lg-1">
               <input name="deviceSize" value="${phoneList.size()}" class="hidden">
        <c:choose>
            <c:when test="${phoneList == null || phoneList.size() == 0}">
                <a class="alert alert-error">本账号没有绑定任何设备.</a>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${phoneList.size() == 1}" >
                        <input type="text" name="imei" value="${phoneList.get(0).imeiNo}"/>
                        <input type="button" class="motion position btn btn-info" value="获取当前位置"/>
                        <input type="button " class="motion voice btn btn-success btn-small" value="发声"/>
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="imei" value="${phoneList.get(0).imeiNo}"/>
                        <button type="button" data-toggle="modal" class="choosePhone btn btn-info" data-target="#choosePhone">选择设备</button>
                    </c:otherwise>
                </c:choose>

            </c:otherwise>
        </c:choose>


    </div>
</section>

<!-- 模态 -->
<div class="modal fade " id="noPhoneFound">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">
                <h4>您的账户还没有绑定任何的设备,请先在设备上绑定云账号!</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-show="true" data-dismiss="modal">关闭</button>
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

<%@include file="../part/inc_js.jsp"%>
<script src="<c:url value='js/baidu-map.js'/>" type="text/javascript"></script>
<script type="text/javascript">
    (function(){
        $(document).ready(function(){
            if($("input[name='deviceSize']").val()==0){
                 $("#noPhoneFound").modal();
            }

        });
        $(document).on("click","input.btn_imei_choose" ,function(){
            var imei = $(this).val();
             var html =" <input type='text' name='imei' value='"+imei +"'/>"+
                     "<input type='button' class='motion position btn btn-info' value='获取当前位置'/>"+
                    "<input type='button ' class='motion voice btn btn-success btn-small' value='发声'/>  ";
             $("#control").append(html);
            $("#choosePhone").modal('hide');
        })
        $(document).on("click","button.choosePhone",function(){
            $("#choosePhone").modal();
        });

    })($);

</script>
</body>
</html>