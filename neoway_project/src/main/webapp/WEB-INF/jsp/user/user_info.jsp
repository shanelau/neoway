<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<%@include file="../inc/taglib.jsp" %>
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>有方生产数据系统</title>
    <base href="<%=basePath%>">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <%@include file="../inc/import.jsp" %>
    <!-- END GLOBAL MANDATORY STYLES -->
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
    <div class="container-fluid">

        <!-- BEGIN PAGE HEADER-->

        <div class="row-fluid">

            <div class="span12">

                <!-- BEGIN STYLE CUSTOMIZER -->

                <!-- END BEGIN STYLE CUSTOMIZER -->

                <!-- BEGIN PAGE TITLE & BREADCRUMB-->

                <h3 class="page-title">

                    个人信息 <small></small>  <span class="text-error controls">${msg}</span>

                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-home"></i>

                        <a href="index">主页</a>

                        <i class="icon-angle-right"></i>

                    </li>



                    <li><a href="#">个人信息管理</a></li>

                </ul>

                <!-- END PAGE TITLE & BREADCRUMB-->

            </div>

        </div>

        <!-- END PAGE HEADER-->

        <!-- BEGIN PAGE CONTENT-->
        <div class="row-fluid">

            <div class="span12">
                <div class="alert alert-success"><button class="close" data-dismiss="alert"></button>
                    <strong>提示!</strong> 请尽快填写个人用户信息，以方便其他用户查找您的信息！
                </div></div></div>

        <div class="row-fluid">

            <div class="span6 portlet box ">



                <form class="form-horizontal" action="user/update" method="post">
                    <fieldset>
                        <div class="">
                            <legend class="">个人信息</legend>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >用户名</label>
                            <div class="controls">
                                <input type="text" placeholder="登录账号" class="input-xlarge" readonly="true" name="userName" value="${currUser.userName}">
                                <input type="text" name="userId" class="hidden" style="width: 2px;" value="${currUser.userId}"/>
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">邮箱</label>
                            <div class="controls">
                                <input type="text" placeholder="可以用来登录和找回密码" class="input-xlarge" name="email" value="${currUser.email}">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">真实姓名</label>
                            <div class="controls">
                                <input type="text" placeholder="中文名/英文名" class="input-xlarge" name="trueName" value="${currUser.trueName}">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">部门科室</label>
                            <div class="controls">
                                <input type="text" placeholder="部门和科室信息" class="input-xlarge" name="dept" value="${currUser.dept}">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">手机号码</label>
                            <div class="controls">
                                <input type="text" placeholder="手机号码或者短号" class="input-xlarge phone" name="phone" value="${currUser.phone}">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label"></label>

                            <!-- Button -->
                            <div class="controls">
                                <button class="btn btn-primary green">提交</button>   <button class="btn btn-warning blue">重置</button>
                            </div>
                        </div>

                    </fieldset>
                </form>


            </div>
            <div class="span6 box">

                <form class="form-horizontal" method="post" action="user/user_password" name="update_password">
                    <fieldset>
                        <div id="legend" class="">
                            <legend class="">修改密码</legend>
                        </div>
                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >当前密码</label>
                            <div class="controls">
                                <input type="password" placeholder="请输入现在的密码" class="input-xlarge" name="curr_password">
                                <p class="help-block"></p>
                            </div>
                        </div><div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >新的密码</label>
                        <div class="controls">
                            <input type="password" placeholder="数字+英文组合" class="input-xlarge" name="new_password">
                            <p class="help-block"></p>
                        </div>
                    </div>



                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label">确认密码</label>
                            <div class="controls">
                                <input type="password" placeholder="请再输入一次新密码" class="input-xlarge" name="confim_password">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label"></label>

                            <!-- Button -->
                            <div class="controls">
                                <button class="btn btn-success green">确认修改</button>  <button class="btn btn-success blue">取消修改</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

            </div>

        </div>


        <!-- END PAGE CONTENT-->

    </div>



<!-- BEGIN PAGE CONTAINER-->

</div>

<!-- END PAGE CONTAINER-->

</div>

<!-- END PAGE -->

<!-- END PAGE -->
<%@include file="../inc/footer.jsp"%>
<script src="js/script/my.js"></script>
<!-- END CONTAINER -->
<script>

    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins


    });
    (function(){
        $(document).ready(function(){
            $("ul.page-sidebar-menu li").removeClass("active");
            $("ul.page-sidebar-menu li.user_info").addClass("active");
        });
    })($);

</script>
<script type="text/javascript">
    (function(){
        $(document).ready(function(){
            $("form[name='update_password']").submit(function(){
                var currPassword=$("input[name='curr_password']").val();
                var newPassword=$("input[name='new_password']").val();
                var confimPassword=$("input[name='confim_password']").val();
                if(currPassword == "" || newPassword == "" || confimPassword == ""){
                    alert("密码不能为空");
                    return false;
                }
                if(newPassword != confimPassword){
                    alert("新密码和确认密码不相等");
                    return false;
                }
            });
        });
    })($);

</script>

</body>

<!-- END BODY -->

</html>