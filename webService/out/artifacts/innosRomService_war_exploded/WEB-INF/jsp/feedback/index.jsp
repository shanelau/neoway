<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="part/header.jsp" %>
<title>用户反馈</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="part/inc_css.jsp"%>
<!--数据表格-->
<link rel="stylesheet" type="text/css" href="<c:url value='js/datatable/css/jquery.dataTables.css'/>" />
<!--[if IE]>
 <link rel="stylesheet" type="text/css" href="<c:url value='css/index-ie.css'/>">
<![endif]-->
<!-- my css-->
<link rel="stylesheet" href="<c:url value='css/index.css'/>">
</head>

<body>
<%@include file="part/head_menu.jsp"%>

<div class="container bs-docs-container">
  <div class="row">
    <div class="col-md-2">
      <div class="bs-sidebar hidden-print affix" role="complementary">
        <ul class="nav bs-sidenav status_ul">
          <li class="active"> <a href="javascript:void(0);" value="">全部反馈</a> </li>
            <c:forEach var="statusModel" items="${statusList}">
                <li class=""> <a href="javascript:void(0);" value="${statusModel.statusId}">${statusModel.statusName}</a> </li>
            </c:forEach>
          </li>
        </ul>
      </div>
    </div>
    <div class="col-md-10" role="main">
      <div id="less" class="bs-docs-section">
        <div class="page-header">
          <h1>反馈列表</h1>     
        </div>
        <form class="form-horizontal">
            <div class="form-group fb_type_choose">
             	 <label class="control-label fb_lable_text col-lg-2"><p class="text-danger">反馈类型</p></label>
                    <div class="col-lg-3">
                    <select name="fb_type" class="form-control ">
                      <option value="">全部</option>
                        <c:forEach var="fbType" items="${typeList}">
                            <option value="${fbType.typeId}">${fbType.typeName}</option>
                        </c:forEach>
                  </select>
                  </div>
                <a class="btn btn-info btn-lg pull-right" target="_blank" href="feedback/multipleReply">批量回复</a>
              </div>

      </form>
      
      	<table id="tb_fb_index"  class="table-striped table table-hover table-responsive" >
		</table>
      </div>
    </div>
 
 </div>




</div>

<%@include file="part/footer.jsp"%>


<%@include file="part/inc_js.jsp"%>
<script src="<c:url value='js/datatable/js/jquery.dataTables.js'/>"></script>
<script src="<c:url value='js/moment.min.js'/>"></script>
<script src="<c:url value='js/lang/zh-cn.js'/>"></script>
<script src="<c:url value='js/my-fb-dataTable.js'/>"></script>
 
 <script>
	(function(){
        $(document).ready(function() {
             $("header li[name='feedback']").addClass("active");

        });
	})($);
</script>
</body>
</html>