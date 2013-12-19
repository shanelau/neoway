/********地图开始**********/
var title = "您的手机位置";
//获取marker标记
var getMarker = function(map,poi,searchInfoWindow){
	var marker = new BMap.Marker(poi); //创建marker对象
	marker.addEventListener("click", function(e){
		searchInfoWindow.open(marker);
	})
	map.addOverlay(marker); //在地图中添加marker
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	return marker;
}
//根据位置获取 infoWindow
var getMyGeo = function(map,poi){
		// 创建地理编码实例
	var myGeo = new BMap.Geocoder();
	myGeo.getLocation(poi, function(result){
		if (result){
			map.setCenter(poi);
			var content="<h5>"+result.address+"<h6>经纬度:"+poi.lng + "," + poi.lat;;
	
	  		//创建检索信息窗口对象
			 var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
				title  : title,      //标题
				width  : 290,             //宽度
				height : 55,              //高度
				panel  : "panel",         //检索结果面板
				enableAutoPan : true,     //自动平移
                searchTypes :[
                     BMAPLIB_TAB_SEARCH   //周边检索
                ]
			});
			var marker = getMarker(map,poi,searchInfoWindow);
			searchInfoWindow.open(marker); //在marker上打开检索信息串口
		}
	});
}

    //地图开始
	var pointX = 116.397428;
	var pointY = 39.915;
	
  	var map = new BMap.Map('allmap');
    var poi = new BMap.Point(pointX,pointY);
    map.centerAndZoom(poi, 13);

	map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP],anchor: BMAP_ANCHOR_TOP_RIGHT}));    //左上角，默认地图控件
	map.addControl(new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT}));   // 右下
	//getMyGeo(map,poi);

/********地图结束**********/

/********按钮操作开始**********/
(function(){
		$(document).ready(function(e) {
            var imei = $("input[name='imei']").val();
            var locationTask;  //定时获取位置的任务
            var requestCount;//请求次数
            moment.lang('zh_cn');
            initDevice();   //设备选择
            //获取最近一次定位的数据
            if(imei != ""){
                $.post(
                   "findphone/getLastLocation",
                   {"imei":imei},
                    function(data){
                         if(!data.phoneLog.pointX=="0" && !data.phoneLog.pointY=="0"){
                             updateMap(data.phoneLog.pointX,data.phoneLog.pointY,data.phoneLog.logTime);
                         }
                        if(data.status == true){
                            $("#phone_online_status").text("在线");
                        }
                    }
                );
            }

            /****设备选择开始**/
            function initDevice(){
                var phoneNumber = $("#phoneNumber").text();
                if(phoneNumber == ""){          //没有设备或者多个设备
                    if($("input.phoneNull").val() == "true"){       //没有绑定设备
                        $("#message_Body").text(" 您的账户还没有绑定任何的设备,请先在设备上绑定云账号!");
                        $("#modal_Message").modal();
                    }else{        //有多个设备,进行选择
                        $("#choosePhone").modal();
                    }

                }
            }
            //多个设备进行选择
            $(document).on("click","input.btn_imei_choose" ,function(){
                var value = $(this).val();
                $("input[name='imei']").val(value);
                $("#choosePhone").modal('hide');
            })
            $(document).on("click","button.choosePhone",function(){
                $("#choosePhone").modal();
            });
           /****设备选择结束**/

            function getlocation(){
               requestCount++;
               if(requestCount > 10){
                   clearInterval(locationTask);
                   $("#phone_online_status").text("无应答");
               }
                $.post(
                    "findphone/getlocation",
                    {'imei':imei},
                    function(data){
                        if(data.status == 'OK'){
                           $("#phone_online_status").text("在线");    //获取到地理位置了,更新该在线
                           updateMap(data.message.pointX,data.message.pointY,data.message.logTime);
                           clearInterval(locationTask);
                        }
                    }
                );
            }
            //点击定位后 获取地理位置信息
            $("#control .position").bind("click",function(){
                $("#message_Body").text("您的手机应答可能需要几分钟,请耐心等待!");
                $("#modal_Message").modal();
                locationTask = window.setInterval(function(){
                    getlocation();
                }, 10000);       //10秒钟请求一次 位置
            });
            //系统自动获取地理位置
            setTimeout(function(){ getlocation();},5000);
            setTimeout(function(){ getlocation();},20000);
            function updateMap(x,y,logTime){    //更新title 和地图
                var time = moment.unix(logTime/1000).fromNow();
                title = time +":您的手机位置";
                map.clearOverlays();
                var pointX = parseFloat(x);
                var pointY = parseFloat(y);
                var min = pointX<pointY?pointX:pointY;
                var max = pointX<pointY?pointY:pointX;
                console.log(max+"  "+min);
                var poi = new BMap.Point(max,min); //真实经纬度转成百度坐标
               // BMap.Convertor.translate(poi,0,function(point){   //使用百度定位sdk,则不在需要 坐标转换
                    getMyGeo(map,poi);
               // });
                //更新面板
                $("#phone_operation_info").text(" 于"+time+"定位");
            }
            /*********位置操作结束************/
            /*********声音操作开始************/
            //发声操作
            function sendMotion(motion,status){
                $.post(
                    "findphone/"+motion,
                    {'imei':imei
                    ,"status":status},
                    function(data){
                    }
                );
            }
            $("#btn_open_voice").bind("click",function(){
                sendMotion("voice","open");
            })
            /*********声音操作开始************/
            /*********擦除操作开始************/
            $("#clean").bind("click",function(){
                $("#message_Body").html("<div class='del-div'><p>这个操作将彻底删除您手机上的所有数据！</p>" +
                    "<p>删除数据的同时，您也将失去对这台手机的控制权！</p></div>");
                $("#modal_Message").modal();
                $("#modal_Message button.submit").bind("click",function(){
                    sendMotion("clean","open");
                });
            });
            /*********擦除操作结束************/
            /*********锁定操作结束************/
             $("#btn_lock_phone").bind("click",function(){
                  var pass = $("#lockPassword").val();
                 if(pass.length<8 || isNaN(pass)){
                    $("#lockPhoneModal div.form-group").addClass("has-error");
                 }else{
                     $("#lockPhoneModal").modal('hide');
                     $.post(
                         "findphone/lock",
                         {'imei':imei,
                           "pass":pass},
                         function(data){
                         }
                     );
                 }
             });
            /*********锁定操作结束************/
        });
})($);