<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>有方云登录</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="深圳市有方科技有限公司,模块生产数据追溯云系统,计划单">
    <meta name="author" content="liu.xing">

    <!-- CSS -->
    <link rel="stylesheet" href="image/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="image/assets/bootstrap/css/style-metro.css">
    <link rel="stylesheet" href="image/assets/css/style.css">
    <link rel="stylesheet" href="image/assets/bootstrap/css/font-awesome.min.css">
    <link rel="stylesheet" href="image/assets/css/showLoading.css"/>

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

<!-- Register and login -->
<div class="coming-soon">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="span7 hidden-480" >
                    <h2>有无限,方精彩</h2>
                    <p>愿景：成为全球最受尊敬的无线产品和服务提供商!</p>
                    <div class="space40"></div>
                    <h2>可以登录的账号</h2>
                    <p>管理员:admin   123</p>
                    <p>计划员:test   test</p>
                    <p>普通用户:test1   test1</p>
                    <p>普通用户:test2   test2</p>
                    <p>普通用户:test3   test3</p>
                    <p>普通用户:test4   test</p>
                </div>
                <div class="span5">
                    <div class="login_register span4">
                        <form action="login" method="post" class="login-form">
                            <h2><span class="red"><strong>有方云</strong></span></h2>

                            <div class="control-group">
                                <label for="username">用户名<span class="red">${error_info}${param.msg}</span>       </label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-user"></i>
                                        <input type="text" id="login_username" name="username" placeholder="用户名\邮箱\手机号">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="password">密码</label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-lock"></i>
                                        <input type="password" id="login_password" name="password" placeholder="密码">
                                    </div>
                                </div>
                            </div>
                            <button type="submit">登 录</button>
                            <div class="forget_register row-fluid">
                                <div class="row span6"><a href="javascript:;" class="" id="forget-password">忘记密码?</a> </div>
                                <div class="row span6"><a href="javascript:;" id="register-btn" class="">注 册</a> </div>
                            </div>
                        </form>
                        <form action="register" method="post" class="register-form">
                            <h2>注册账号</h2>
                            <div class="control-group">
                                <label for="username">用户名 <span class="red">${register_error_info}</span></label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-user"></i>
                                        <input type="text" id="username" name="username" placeholder="用户名\邮箱\手机号">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="password">密码</label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-lock"></i>
                                        <input type="password" id="password" name="password" placeholder="密码">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="email">邮箱</label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-envelope"></i>
                                        <input type="text" id="email" name="email" placeholder="输入常用邮箱">
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button id="register-back-btn" type="button" class="btn pull-left"> <i class="m-icon-swapleft"></i> 返 回 </button>
                                <button type="submit" id="register-submit-btn" class="btn green pull-right"> 注 册 <i class="m-icon-swapright m-icon-white"></i> </button>
                            </div>
                        </form>
                        <!-- BEGIN FORGOT PASSWORD FORM -->

                        <form class="form-vertical forget-form" action="user/i_forget_password" method="post">
                            <h2>找回 <span class="red"><strong>密码</strong></span></h2>
                            <div class="alert-success">
                                <button class="close" type="button">&times;</button>
                                <small>我们将发送邮件到您邮箱,点击邮件中的"链接"重设密码</small>
                            </div>
                            <div class="space40"></div>
                            <div class="control-group" style="margin-top: 47px;">
                                <label for="email">用户名</label>
                                <div class="controls">
                                    <div class="input-icon left"> <i class="icon-envelope"></i>
                                        <input  type="text" placeholder="输入用户名" name="userName" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="button" id="back-btn" class="btn pull-left"> <i class="m-icon-swapleft"></i> 返回 </button>
                                <button type="submit" class="btn green pull-right"> 提交 <i class="m-icon-swapright m-icon-white"></i> </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Content -->
<div class="container">
    <div class="row">
        <div class="span12 subscribe">
            <h3>持续改进 追求卓越</h3>
            <p class="tip">输入您的建议和意见,帮助我们做得更好:</p>
            <form class="form-inline" action="user_advice" method="post" name="advice">
                <input type="text" name="msg_advice" placeholder="倾听你想说的...">
                <button type="submit" class="btn advice">提交</button>
            </form>
            <div class="success-message"></div>
            <div class="error-message"></div>
        </div>
    </div>
    <div class="row">
        <div class="span12 social"> <a href="" class="facebook" rel="tooltip" data-placement="top" data-original-title="Facebook"></a> <a href="" class="twitter" rel="tooltip" data-placement="top" data-original-title="Twitter"></a> <a href="" class="dribbble" rel="tooltip" data-placement="top" data-original-title="Dribbble"></a> <a href="" class="googleplus" rel="tooltip" data-placement="top" data-original-title="Google Plus"></a> <a href="" class="pinterest" rel="tooltip" data-placement="top" data-original-title="Pinterest"></a> <a href="" class="flickr" rel="tooltip" data-placement="top" data-original-title="Flickr"></a> </div>
    </div>
</div>

<!-- Javascript -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!--[if lte IE 6]>
<script type="text/javascript" src="js/bootstrap-ie.js"></script>
<![endif]-->
<script src="js/jquery.backstretch.min.js"></script>
<script src="image/assets/js/scripts.js"></script>

<script src="image/assets/js/jquery.showLoading.js"></script>

</body>
</html>
