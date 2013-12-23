<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>JSR云上的生活--注册</title>
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
      <h1 class="hide-clip">用户注册</h1>
      <s class="icon sp-logo"></s></a> </div>
  </header>
  <div class="container">
    <div class="inner">
        <div class="message">
            <div class="register_tip alert alert-danger "></div>
       </div>
       <form class="form-horizontal register-form" role="form" action="register" method="post">
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >用户名</label>
          <div class="col-sm-4">
            <input placeholder="" class="form-control" name="username" type="text" required autofocus>
            <p class="help-block"></p>
          </div>
        </div>
       
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >密码</label>
          <div class="col-sm-4">
            <input placeholder="六位以上的数字和字母" class="form-control" name="password" type="password" required>
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >邮箱</label>
          <div class="col-sm-4">
            <input placeholder="激活和找回密码" class="form-control" name="email" type="text" required>
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >真名</label>
          <div class="col-sm-4">
            <input placeholder="" class="form-control" type="text" name="trueName">
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >部门</label>
          <div class="col-sm-4">
            <input placeholder="" class="form-control" type="text" name="dept">
            <p class="help-block"></p>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2 col-sm-offset-2" >手机</label>
          <div class="col-sm-4">
            <input placeholder="" class="form-control" type="text" name="phone">
            <p class="help-block"></p>
          </div>
        </div>
        
         <div class="form-group">
            <div class="col-sm-12">
              <button type="submit" class="btn btn-success btn-lg">注册</button>
              <button type="reset" class="btn btn-danger btn-lg  col-xs-offset-1">重置</button>
            </div>
  		</div>
        
      </form>
    </div>
  </div>

</section>
<%@include file="../part/footer.jsp"%>
<%@include file="../part/inc_js.jsp"%>
<!--my js-->
<script src="<c:url value='js/login.js'/>" type="text/javascript"></script>
<script>
  (function(){
        $(document).ready(function() {


        });

    })($);
</script>

</body>
</html>