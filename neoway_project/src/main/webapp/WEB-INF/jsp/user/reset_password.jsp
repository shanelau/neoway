<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String userName = request.getParameter("userName");
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>重置密码</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="image/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="image/assets/bootstrap/css/style-metro.css">
    <link rel="stylesheet" href="image/assets/css/style.css">
    <link rel="stylesheet" href="image/assets/bootstrap/css/font-awesome.min.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="image/assets/ico/favicon.ico">
</head>

<body>

<!-- Header -->
<div class="container">
    <div class="header row">
        <div class="logo span4">
            <h1><a href="">Neoway</a> <span>.</span></h1>
        </div>
        <div class="call-us span8">
            <p>Tel: <span>0039 123 45 789</span> | Email: <span>kissliux</span></p>
        </div>
    </div>
</div>


<!-- Content -->
<div class="container">
    <div class="row">
        <div class="span12 subscribe ">
            <h3>重置密码</h3>

            <p class="tip">如果非本人操作,请直接关闭本页面:</p>
            <div class="success-message"></div>
            <div class="error-message"></div>
            <div style="margin: 0 auto; width:512px;">
                <form class="form-horizontal" action="user/reset_pass" method="post" name="reset_pass_form">
                    <fieldset>
                        <div class="control-group">
                            <!-- Text input-->
                            <label class="control-label">用户名</label>
                            <div class="controls">
                                <input type="text" placeholder="" class="input-xlarge" name="userName" value="<%=userName%>" readonly="true"/>
                            </div>
                        </div>

                        <div class="control-group">
                            <!-- Text input-->
                            <label class="control-label" >新密码</label>
                            <div class="controls">
                                <input type="password" placeholder="" class="input-xlarge" name="password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Text input-->
                            <label class="control-label">确认密码</label>
                            <div class="controls">
                                <input type="password" placeholder="" class="input-xlarge" name="passwordConfirm"/>
                            </div>
                        </div>

                    </fieldset>

                <button type="submit" class="btn advice" style="margin-left: 120px;margin-right: 20px;">提交</button>
                <a class="green" href="index">重新登录</a>
            </form>

            </div>
        </div>
    </div>
</div>

<!-- Javascript -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $("form[name='reset_pass_form']").submit(function(){
        var name = $("input[name='userName']").val();
        var pass1 =  $("input[name='password']").val();
        var confirmPass = $("input[name='passwordConfirm']").val();
        if(name=='' || pass1=='' || confirmPass == ''){
            $("div .error-message").html("密码项不能为空.");
            $("div .error-message").fadeIn();
            return false;
        }
        if(pass1 != confirmPass){
            $("div .error-message").html("两次输入的密码不相等.");
            $("div .error-message").fadeIn();
            return false;
        }
        $("div .error-message").html("");
        $.post(
                'user/reset_password',
                {'userName':name,'password':pass1,'passwordConfirm':confirmPass},
                function(data){
                    if(data.success == 'true'){
                        $("div .success-message").html(data.msg);
                        $("div .error-message").fadeIn();
                        setTimeout(function(){
                            location.href="login";
                        },3000);
                    }else{
                        $("div .error-message").html(data.msg);
                        $("div .error-message").fadeIn();
                    }
                },
                'json'
        );
        return false;
    });

</script>


</body>
</html>
