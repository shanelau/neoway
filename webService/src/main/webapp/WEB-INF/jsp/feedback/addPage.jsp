<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>添加用户反馈</title>
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
        <p class="text-success">感谢您对我们工作的大力支持,我们会尽快处理您的反馈意见.</p>
    </blockquote>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">请填写下面的表格</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" name="add_fb_web" role="form" action="feedback/add" method="post" enctype="multipart/form-data">


                <div class="form-group">
                    <label class="col-sm-2 control-label">问题描述</label>
                    <div class="col-sm-10">
                        <textarea type="" class="col-sm-7"  rows="3" name="content" required> </textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">问题类型</label>
                    <div class="col-sm-10">
                        <c:forEach var="typeModel" items="${typeList}">
                            <label class="radio radio-inline">
                                <input type="radio" value="${typeModel.typeId}" name="typeId">
                                    ${typeModel.typeName}
                            </label>
                        </c:forEach>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">软件版本</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="version"  placeholder="可选">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">IMEI</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="phImei"  placeholder="可选">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="contact"  placeholder="可选，邮箱或者手机">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">上传图片(可选)</label>
                    <div class="col-sm-10">
                        <input class="input-file" name="imgPath" type="file" accept="image/*">
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
            $("form[name='add_fb_web']").submit(function(){

                $("form[name='add_fb_web'] button[type='submit']").button("loading");
                $("form[name='add_fb_web']").ajaxSubmit({
                    success:function(data){
                        $("form[name='add_fb_web'] button[type='submit']").button("reset");
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