<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>错误页面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <link href="css/error.css" rel="stylesheet" type="text/css"/>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-500-full-page">

<div class="row-fluid">

    <div class="span12 page-500">

        <div class=" number">

            404

        </div>

        <div class=" details">

            <h3>哇哦, 咱们出了点小问题.</h3>

            <p>

                我们正在尽力抢修!<br/>

                请等会再来访问,或者您反问的页面不存在.<br/><br/>
                ${exception.printStackTrace()}
            </p>


        </div>
        <p><a href="javascript:void(0);" onclick="history.go(-1)">返回刚才页面</a><br/><br/></p>

    </div>

</div>

</body>

<!-- END BODY -->

</html>