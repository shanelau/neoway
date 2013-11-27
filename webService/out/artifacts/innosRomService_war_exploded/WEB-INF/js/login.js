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
            pass_div.removeClass("has-error").addClass("has-success");
        }

        $(this).ajaxSubmit({
            success:function(data){
                if(data.status=="OK"){
                    setTimeout(function(){
                        location.href="index";
                    },0);
                }else{
                    alert(data.message);
                }
            }
        });
        return false;
    });
    //登陆界面结束


    //注册界面
    $(".register-form").submit(function(){
        var username = $(this).find("input[name='username']").val();
        var email = $(this).find("input[name='email']").val();
        var password = $(this).find("input[name='password']").val();
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入一个有效用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入一个有效的密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 请输入有一个有效的邮箱.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        $(this).ajaxSubmit({
            success:function(data){
                if(data.status=='FAIL'){
                    $(".error-message").html(data.message);
                    $(".error-message").css("visibility","visible");

                }else{
                    setTimeout(function(){
                        location.href="login";
                    },3000);
                    alert(data.message+",3秒后跳转到登录界面");
                }
            }
        });
        return false;
    });




























});