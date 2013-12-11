/********地图开始**********/

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
				title  : "您的手机位置",      //标题
				width  : 290,             //宽度
				height : 55,              //高度
				enableAutoPan : true,     //自动平移
				panel  : "panel",         //检索结果面板
				enableAutoPan : true     //自动平移
			
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

(function(){
		$(document).ready(function(e) {
            $("form[name='pointForm']").submit(function(){
				var x = $("input.pointX");
				var y = $("input.pointY");
				var poi = new BMap.Point(x.val(),y.val());
				BMap.Convertor.translate(poi,0,function(point){
					getMyGeo(map,point);
				});
				return false;
			});
			
			$("#control .position").bind("click",function(){
				var imei = $("input[name='imei']").val();
                getlocation(imei);
			});
            $("#control .voice").bind("click",function(){
                var imei = $("input[name='imei']").val();

                //getlocation(imei);
            });
            function getlocation(imei){
                $.post(
                    "findphone/getlocation",
                    {'imei':imei},
                    function(data){
                        if(data.status == 'OK'){
                            map.clearOverlays();
                            var poi = new BMap.Point(data.message.pointX,data.message.pointY); //真实经纬度转成百度坐标
                            BMap.Convertor.translate(poi,0,function(point){
                                getMyGeo(map,point);
                            });
                        }else{
                            alert(data.message);
                        }


                    }
                );
            }

            function voice(imei){
                $.post(
                    "findphone/voice",
                    {'imei':imei},
                    function(data){
                        if(data.status == 'OK'){
                           alert("send success");
                        }else{
                            alert(data.message);
                        }


                    }
                );
            }

			
			
        });
})($);