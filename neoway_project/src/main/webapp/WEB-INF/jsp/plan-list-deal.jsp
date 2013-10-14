<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp"%>


<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<title>Metronic | Data Tables - Managed Tables</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css" href="/css/select2_metro.css" />
<link rel="stylesheet" href="/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="/image/favicon.ico" />
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->

<%@include file="inc/top.jsp"%>

<!-- END HEADER --> 

<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid"> 
  
  <!-- BEGIN SIDEBAR -->

    <%@include file="inc/leftmenu.jsp"%>
  
  <!-- END SIDEBAR --> 
  
  <!-- BEGIN PAGE -->
  
  <div class="page-content"> 
    
    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
    
    <div id="portlet-config" class="modal hide">
      <div class="modal-header">
        <button data-dismiss="modal" class="close" type="button"></button>
        <h3>portlet Settings</h3>
      </div>
      <div class="modal-body">
        <p>Here will be a configuration form</p>
      </div>
    </div>
    
    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM--> 
    
    <!-- BEGIN PAGE CONTAINER-->
    
    <div class="container-fluid"> 
      
      <!-- BEGIN PAGE HEADER-->
      
      <div class="row-fluid">
        <div class="span12"> 
          
          <!-- BEGIN STYLE CUSTOMIZER -->
          

          <!-- END BEGIN STYLE CUSTOMIZER -->
            <h3 class="page-title">等待处理计划单<small></small>  <span class="text-error controls">${requestScope.msg}</span></h3>
          <!-- BEGIN PAGE TITLE & BREADCRUMB-->
         <div class="space20"></div> 
          <ul class="breadcrumb">
            <li> <i class="icon-home"></i> <a href="index.jsp">主页</a> <i class="icon-angle-right"></i> </li>
            <li> <a href="#">模块计划单</a> <i class="icon-angle-right"></i> </li>
            <li><a href="#">待处理计划单</a></li>
          </ul>
          
          <!-- END PAGE TITLE & BREADCRUMB--> 
          
        </div>
      </div>
      
      <!-- END PAGE HEADER--> 
      
      <!-- BEGIN PAGE CONTENT-->
      
      <div class="row-fluid">
        <div class="space12 responsive" data-tablet="span12 fix-offset">
          
          <!-- BEGIN EXAMPLE TABLE PORTLET-->
          
          <div class="portlet box green">
            <div class="portlet-title">
              <div class="caption"><i class="icon-user"></i>待处理计划单</div>

            </div>
            <div class="portlet-body">
              <table class="table table-striped table-bordered table-hover" id="sample_2">
                <thead>
                  <tr>
                    <th>序号</th>
                    <th>计划单代号</th>
                    <th class="hidden-480">创建建时间</th>
                      <th>型号</th>
                      <th>生产总数</th>
                      <th>上一次处理人</th>
                      <th>处理意见</th>
                      <th>等待处理人</th>
                      <th class="hidden-480">操作</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="model" items="${dealList}" varStatus="s">
                    <tr>
                    <td>${s.index}</td>
                    <td><input type="text" name="proPlanId" value="${model.proPlanId}" class="hidden" style="width: 1px;"/>  ${model.moduleProId}</td>
                    <td>${model.proCreateDate}</td>
                    <td>${model.mkType}</td>
                    <td>${model.proceCount}</td>
                    <td><a href="#" class="btn" rel="popoverTop" data-content="邮箱:${model.lastUser.email}" title="手机:${model.lastUser.phone}" data-original-title="Popover on top">${model.lastUser.userName}</a></td>
                    <td> <a href="#" class="btn " rel="popoverTop" data-content="${model.dealAdvice}" data-original-title="处理意见：">点击查看</a></td>
                    <td><a href="#" class="btn" rel="popoverTop" data-content="邮箱:${model.dealUser.email}" title="手机:${model.dealUser.phone}" data-original-title="Popover on top">${model.dealUser.userName}</a></td>
                    <td><c:if test="${model.dealUser.userName == currUser.userName}"><a href="/plan/module-plan-editor?moduleId=${model.moduleProId}" class="btn blue"><i class="icon-pencil"></i>编辑</a>  </c:if>
                        <a href="/plan/module-plan-editor?moduleId=${model.moduleProId}&is_view=module_plan_view" class="btn green"><i class="icon-star"></i>预览</a>
                      <c:if test="${model.planState == 1 && model.dealUser.userName == currUser.userName}"> <shiro:hasRole name="plan_create"><a href="/plan/delete?moduleId=${model.proPlanId}" class="btn red"><i class="icon-trash"></i> 删除</a></shiro:hasRole>    </c:if>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          
          <!-- END EXAMPLE TABLE PORTLET--> 
          
        </div>
      </div>
      
      <!-- END PAGE CONTENT--> 
      
    </div>
    
    <!-- END PAGE CONTAINER--> 
    
  </div>
  
  <!-- END PAGE --> 
  
</div>
<%@include file="inc/footer.jsp"%>

<!-- BEGIN PAGE LEVEL PLUGINS --> 

<script type="text/javascript" src="/js/select2.min.js"></script>
<script type="text/javascript" src="/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="/js/DT_bootstrap.js"></script>

<!-- END PAGE LEVEL PLUGINS --> 

<!-- BEGIN PAGE LEVEL SCRIPTS --> 

<script src="/js/table-managed.js"></script>
<script>

		jQuery(document).ready(function() {       

		   App.init();

		   TableManaged.init();

		});

</script>
</body>

<!-- END BODY -->

</html>