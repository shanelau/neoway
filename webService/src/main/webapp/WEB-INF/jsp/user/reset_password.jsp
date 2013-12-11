<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>JSR云上的生活--重置密码</title>
<%@include file="../part/inc_css.jsp"%>
<!-- my css-->
<link rel="stylesheet" href="<c:url value='css/login.css'/>">

<!--[if IE]>
<link rel="stylesheet" type="text/css" href="<c:url value='css/login-ie.css'/>">
<![endif]-->

</head>

<body class="register_body">
<section class="register">
  <header>
    <div class="container"> <a href="#">
      <h1 class="hide-clip">重置密码</h1>
      <s class="icon sp-logo"></s></a> </div>
  </header>
  <div class="container">
    <div class="inner">
    <div class="message">
            <div class="success-message alert alert-success "></div>
            <div class="error-message alert alert-danger "></div>
    	</div>
      <form class="form-horizontal" role="form" name="reset_pass_form">
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >用户名</label>
          <div class="col-sm-4">
            <input placeholder="" name="userName" class="form-control" type="text" required value="${userName}" readonly>
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >密码</label>
          <div class="col-sm-4">
            <input placeholder="六位以上的数字和字母" name="password" class="form-control" type="password" required>
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >确认密码</label>
          <div class="col-sm-4">
            <input placeholder="请再次输入密码"  name="passwordConfirm"class="form-control" type="password" required>
            <p class="help-block"></p>
          </div>
        </div>

        
         <div class="form-group">
            <div class="col-sm-12">
              <button type="submit" class="btn btn-success btn-lg" data-loading-text="正在加载...">提交</button>
                <a href="login" class="btn btn-primary btn-lg  col-xs-offset-1">返回登录</a>
            </div>
  		</div>
        
      </form>
    </div>
  </div>
  <footer class="">
    <div class="copyright">
      <p class="copyright_link"> <a href="#" target="_blank">反馈建议</a> | <a href="#" target="_blank">反馈建议</a> | <a href="#" target="_blank">反馈建议</a> | <a href="#" target="_blank">反馈建议</a> | <a href="#" target="_blank">反馈建议</a> | <a href="#" target="_blank">反馈建议</a> </p>
      <p class="copyright_en">Copyright © 2005 - 2013 JSR.<a target="_blank" href="#">All Rights Reserved.</a></p>
      <p class="copyright_cn">JSR公司 <a href="#" target="_blank">版权所有</a> <a href="#" target="_blank">粤网文[2011]0483-070号</a> </p>
    </div>
  </footer>
</section>

<%@include file="../part/inc_js.jsp"%>
<!--my js-->
<script src="<c:url value='js/login.js'/>" type="text/javascript"></script>
<script>
    $("form[name='reset_pass_form']").submit(function(){
        var name = $("input[name='userName']").val();
        var pass1 =  $("input[name='password']").val();
        var confirmPass = $("input[name='passwordConfirm']").val();
        if(name=='' || pass1=='' || confirmPass == ''){
            $("div.error-message").html("密码项不能为空.");
            $("div.error-message").css("visibility","visible");
            return false;
        }
        if(pass1 != confirmPass){
            $("div.error-message").html("两次输入的密码不相等.");
            $("div.error-message").css("visibility","visible");
            return false;
        }
        $("div .error-message").html("");
        $("form button[type='submit']").button("loading");
        $.post(
                'user/reset_password',
                {'userName':name,'password':pass1,'passwordConfirm':confirmPass},
                function(data){
                    if(data.status == 'OK'){
                        $("div.success-message").html(data.message);
                        $("div.success-message").css("visibility","visible");
                        setTimeout(function(){
                            location.href="login";
                        },3000);
                    }else{
                        $("div.error-message").html(data.message);
                        $("div.error-message").css("visibility","visible");
                        $("form button[type='submit']").button("reset");
                    }
                },
                'json'
        );
        return false;
    });

</script>

</body>
</html>