<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="part/header.jsp" %>
<title>主页</title>
<%@include file="part/inc_css.jsp"%>

<!--[if IE]>
<link rel="stylesheet" type="text/css" href="<c:url value='css/index-ie.css'/>">
<![endif]-->
<!-- my css-->
<link rel="stylesheet" href="<c:url value='css/common.css'/>">
<link rel="stylesheet" href="<c:url value='css/index.css'/>">
    
  </head>

<body>
<%@include file="part/head_menu.jsp"%>
	    <div class="container">
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Making life better!</h1>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Safari bug warning!</h2>
          <p class="text-danger">为保证界面正常显示,建议使用chrom浏览器</p>
          <p>Donec id elit non mi porta gravida at eget metus.  massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-lg-4">
          <h2>添加反馈</h2>
          <p>您在论坛或者售后工作,有用户反馈了信息?在这里添加到系统</p>   <p><a class="btn btn-primary" href="feedback/addPage" role="button">点击我 &raquo;</a></p>
        </div>
      </div>
        </div>
<%@include file="part/footer.jsp"%>
        <%@include file="part/inc_js.jsp"%>
        <script>
            (function(){
                $(document).ready(function() {
                    $("header li[name='index']").addClass("active");

                });
            })($);
        </script>
  </body>
</html>