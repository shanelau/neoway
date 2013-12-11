jQuery(document).ready(function() {
	
	//登录界面和找回密码界面切换
	$("#switch_forgetpwd").bind("click",function(){
		$("#web_login").hide();
		$("#web_pwd").show().fadeIn();
	
	})
	$("#switch_login").bind("click",function(){
		$("#web_pwd").hide();
		$("#web_login").show().fadeIn();
	
	})
	//界面切换结束

    //登录界面开始
    $('.login-form').submit(function(){
        var username = $(this).find("input[name='username']").val();
        var password = $(this).find("input[name='password']").val();
        var user_div =  $(this).find("div[name='username']");
        var pass_div =  $(this).find("div[name='password']");
        if(username == '') {
            user_div.addClass("has-error");
            return false;
        }else{
            user_div.removeClass("has-error").addClass("has-success");
        }

        if(password == '') {
            pass_div.addClass("has-error");
            return false;
        }else{
            pass_div.removeClass("has-error");
        }
        $(".login-form button[type='submit']").button('loading');
        $(this).ajaxSubmit({
            success:function(data){
                $(".login-form button[type='submit']").button('reset');
                if(data.status=="OK"){
                        window.location=data.message;
                }else{
                    $(".login-form div[name='username']").removeClass("has-success").addClass("has-error");
                    $(".login-form div[name='username'] label.control-label").text(data.message);
                }
            }
        });

        return false;
    });
    //登陆界面结束

    //注册界面
     $(".register-form input[name='password']").bind("keyup",function(){
        if($(this).val().length>=6){
            $(this).next(".help-block").text("");
        }
     });
    $(".register-form").submit(function(){
        var username = $(this).find("input[name='username']").val();
        var email = $(this).find("input[name='email']").val();
        var password = $(this).find("input[name='password']");
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入一个有效用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password.val() == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入一个有效的密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        if(password.val().length<6){
            password.next(".help-block").text("密码长度至少大于6");
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 请输入有一个有效的邮箱.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        $(".register-form button[type='submit']").button('loading');
        $(this).ajaxSubmit({
            success:function(data){
                if(data.status=='FAIL'){
                    $(".register_tip").addClass("error-message").html(data.message);
                    $(".register_tip").css("visibility","visible");
                    $(".register-form button[type='submit']").button('reset');
                }else{
                    $(".register_tip").html(data.message+",5秒后跳转到登录界面");
                    $(".register_tip").removeClass("error-message").addClass("success-message");
                    $(".register_tip").css("visibility","visible");
                    setTimeout(function(){
                        location.href="login";
                    },5000);
                }
            }
        });

        return false;
    });

    //忘记密码
    $(".form-forget").submit(function(){
        var forgetInput = $(".form-forget input[name='username']");
        var user_div =  $(this).find("div[name='username']");
        if(forgetInput.val() == '') {
            user_div.addClass("has-error");
            return false;
        }else{
            user_div.removeClass("has-error").addClass("has-success");
        }
        $(".form-forget button[type='submit']").button('loading');
        $(this).ajaxSubmit({
           success:function(data){
               $(".form-forget button[type='submit']").button('reset');
               alert(data.message);
           }
       });

        return false;
    });




























});