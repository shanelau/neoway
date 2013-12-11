<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>JSR云上的生活</title>
<%@include file="../part/inc_css.jsp" %>
<!-- my css-->
<link rel="stylesheet" href="<c:url value='css/login.css'/>">

<!--[if IE]>
<link rel="stylesheet" type="text/css" href="<c:url value='css/login-ie.css'/>">
<![endif]-->

</head>

<body class="login">
<div class="container lay_wrap">
    <div class="lay_main clearfix">
        <div class="lay_inner">
            <div class="twocol hidden-xs">
                <a href="" title="Go Home" class="logo"><img src="images/LX.png" alt="jsr.rom.com"></a>
            </div>
            <div class="row login_msg">
                <div class="login_img hidden-xs col-md-5 col-md-offset-2">
                    <a class="" href="#"><span class="img_slogan "></span></a>
                </div>
                <div class="web_login col-xs-12 col-md-4 col-ls-4 ">
                    <div class="" id="web_login">
                        <div class="login_form">
                            <form class="form-signin login-form" action="user_login" method="post">
                                <h2 class="form-signin-heading text-center">账号登录</h2>

                                <div class="form-group" name="username">
                                    <label class="control-label"></label>
                                    <h5 class="ie_tip">账号</h5><input type="text" name="username" class="form-control"
                                                                     placeholder="账号" required autofocus>
                                </div>
                                <div class="form-group" name="password">
                                    <label class="control-label"></label>
                                    <h5 class="ie_tip">密码</h5><input type="password" name="password"  required
                                                                     class="form-control" placeholder="密码" >
                                </div>
                                <label class="checkbox">
                                    <input type="checkbox" class="remember_me" value="remember-me">
                                    Remember me </label>
                                <button class="btn btn-lg btn-primary btn-block" data-loading-text="正在加载..." type="submit">登录</button>
                            </form>
                        </div>
                        <div class="bottom" style="display: block; "><a href="javascript:void(0);" class="link"
                                                                        id="switch_forgetpwd">忘了密码？</a> <span
                                class="dotted">|</span> <a href="register" class="link" target="_blank">注册账号</a> <span
                                class="dotted">|</span> <a class="link" id="feedback_web" href="javascript:void(0);"
                                                           target="_blank">意见反馈</a></div>
                    </div>
                    <!--找回密码-->

                    <div class="web_pwd" id="web_pwd">
                        <div class="forget_form">
                            <form class="form-forget" action="user/i_forget_password" method="post">
                                <h2 class="form-signin-heading text-center">找回密码</h2>
                                <div class="form-group" name="username">
                                <h5 class="ie_tip">账号</h5>
                                    <input type="text" class="form-control" name="username" placeholder="请输入用户账号"
                                           required autofocus>
                                    </div>
                                <button class="btn btn-lg btn-block btn-success" type="submit" data-loading-text="正在加载...">一键找回</button>
                            </form>
                        </div>
                        <div class="bottom" id="bottom_web" style="display: block; ">
                            <a href="javascript:void(0);" class="link" id="switch_login">返回登录</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<%@include file="../part/inc_js.jsp" %>
<!--my js-->
<script src="<c:url value='js/login.js'/>" type="text/javascript"></script>
<script>
    (function () {
        $(document).ready(function () {

        });

    })($);
</script>

</body>
</html>