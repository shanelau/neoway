<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>

    <script type="text/javascript">
        (function(){
           var jsonTest =  function (){
                $.post(
                   "jsonTest",
                    { tag:"tag123"},
                     function(data) {
                        alert(data.applyList.length);
                    }
                ,"json");
            }
            $(document).ready(function(){
                $("#btn1").bind("click",function(){

                    jsonTest();
                }) ;
            }) ;
        })($);
    </script>

</head>
<body>
<input type="button" value="点击" id="btn1">
<form id="tplForm" method="post"  action="/config_upload" enctype="multipart/form-data">
    <input name="username" value="aa" type="text"/>
    <input class="" type="file" value="选择文件" name="file"/>
    <input class="" type="file" value="选择文件" name="file2"/>
    <input type="submit" value=" 提交">
</form>
</body>
</html>