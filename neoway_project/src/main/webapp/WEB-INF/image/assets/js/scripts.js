
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $('.coming-soon').backstretch([
      "image/assets/img/backgrounds/subway.jpg"
    , "image/assets/img/backgrounds/sunset.jpg"
    , "image/assets/img/backgrounds/1.jpg"
    ], {duration: 3000, fade: 750});	
	 /*
        Form validation
    */
	 $('.login-form').submit(function(){
        $(this).find("label[for='username']").html('用户名');
        $(this).find("label[for='password']").html('密码');

        var username = $(this).find('input#login_username').val();
        var password = $(this).find('input#login_password').val();
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入一个有效用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入一个正确的密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
    });
	
		$('.register-form').submit(function(){
        $(this).find("label[for='username']").html('用户名');
        $(this).find("label[for='email']").html('邮箱');
        $(this).find("label[for='password']").html('密码');
        var username = $(this).find('input#username').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
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
    });
		$('.forget-form').submit(function(){
			$(this).find("label[for='email']").html('邮箱');	
			$(this).find("label[for='email']").append("<span style='display:none' class='red'> - 请输入有一个有效的邮箱.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
		});


	/* switch form
	*/
			$('#forget-password').click(function () {
	            $('.login-form').hide();
	            $('.forget-form').show();
	        });

	        $('#back-btn').click(function () {
	            $('.login-form').show();
	            $('.forget-form').hide();
	        });
			
			$('#register-btn').click(function () {
	            $('.login-form').hide();
	            $('.register-form').show();
	        });

	        $('#register-back-btn').click(function () {
	            $('.login-form').show();
	            $('.register-form').hide();
	        });

    /*
        Tooltips
    */
    $('.social a.facebook').tooltip();
    $('.social a.twitter').tooltip();
    $('.social a.dribbble').tooltip();
    $('.social a.googleplus').tooltip();
    $('.social a.pinterest').tooltip();
    $('.social a.flickr').tooltip();

    /*
        Subscription form
    */
    $('.success-message').hide();
    $('.error-message').hide();

    $('.subscribe form').submit(function() {
        var postdata = $('.subscribe form').serialize();
        $.ajax({
            type: 'POST',
            url: 'assets/sendmail.php',
            data: postdata,
            dataType: 'json',
            success: function(json) {
                if(json.valid == 0) {
                    $('.success-message').hide();
                    $('.error-message').hide();
                    $('.error-message').html(json.message);
                    $('.error-message').fadeIn();
                }
                else {
                    $('.error-message').hide();
                    $('.success-message').hide();
                    $('.subscribe form').hide();
                    $('.success-message').html(json.message);
                    $('.success-message').fadeIn();
                }
            }
        });
        return false;
    });

});

