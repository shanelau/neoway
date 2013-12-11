<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>错误页面</title>
<%@include file="../part/inc_css.jsp"%>
<!-- END GLOBAL MANDATORY STYLES -->
<link href="css/error.css" rel="stylesheet" type="text/css"/>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-500-full-page">

<div class="row-fluid">

    <div class="span12 page-500">

        <div class=" number">

            401

        </div>

        <div class=" details">

            <h3>您没有权限访问该页面.</h3>

            <p>

                请联系管理员,请求提升权限!<br/>

              <br/><br/>

            </p>


        </div>
        <p><a href="index">返回主页</a> <span> | <span><a href="javascript:void(0);" onclick="history.go(-1)">返回刚才页面</a></p>

    </div>

</div>

</body>

<!-- END BODY -->

</html>