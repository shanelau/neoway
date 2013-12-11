<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>批量回复用户反馈</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../part/inc_css.jsp"%>
<!--[if IE]>
 <link rel="stylesheet" type="text/css" href="<c:url value='css/index-ie.css'/>">
<![endif]-->
<!-- my css-->
<link rel="stylesheet" href="<c:url value='css/index.css'/>">
</head>

<body>
<%@include file="part/head_menu.jsp"%>

<div class="container ">


    <blockquote class="clearfix">
        <p class="text-success">点击提交后,信息会批量推送到手机</p>
    </blockquote>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">请填写下面的表格</h3>
        </div>
        <div class="panel-body">
            <p class="text-danger col-lg-offset-2">输入反馈编号(逗号隔开)或者输入范围.例如: 例如:1,2,3或者1 to 4</p>
            <form class="form-horizontal" name="multiReply_fb" role="form" method="post" action="feedback/answer/multiReply">


                <div class="form-group">
                    <label class="col-sm-2 control-label">反馈编号</label>
                    <div class="col-sm-10">
                        <textarea type="" class="col-sm-7"  rows="3" name="address" required> </textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">回复内容</label>
                    <div class="col-sm-10">
                        <textarea type="" class="col-sm-7"  rows="3" name="message" required> </textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-lg-3">
                        <button type="submit" class="btn btn-success btn-lg ">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</div>


</div>
<%@include file="part/footer.jsp"%>
<%@include file="../part/inc_js.jsp"%>
 <script>
	(function(){
        $(document).ready(function() {
            $("header li[name='feedback']").addClass("active");
            $("form[name='multiReply_fb']").submit(function(){

                $("form[name='multiReply_fb'] button[type='submit']").button("loading");
                $("form[name='multiReply_fb']").ajaxSubmit({
                    success:function(data){
                        $("form[name='multiReply_fb'] button[type='submit']").button("reset");
                        alert(data.message);
                    }
                });
                return false;
            });

        });
	})($);
</script>
</body>
</html>