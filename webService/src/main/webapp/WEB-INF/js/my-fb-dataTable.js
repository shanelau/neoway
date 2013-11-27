
var img_open_path="images/details_open.png";
var img_close_path="images/details_close.png";

/* Formating function for row details  展示反馈详细信息*/
function fnFormatDetails ( oTable, nTr )
{
	var aData = oTable.fnGetData( nTr );
	
	var sDetail_img_log = "<div class='panel panel-primary'><div class='panel-heading'>反馈信息详细</div>"+
	"<div class='panel-body'><div class='row'><div class='col-sm-4'><a href="+aData.imgPath+" target='_blank'  title='点击查看详细'>"+
	"<img src="+aData.imgPath+" class='detail_img' ></a></div>"+
	"<div class='col-sm-8'><iframe src="+aData.logPath+" class='detail_log'></iframe></div></div></div></div>";
	 
	return sDetail_img_log;
}
/*显示回复框,可以直接推送消息*/
function fnGetReplyInput(oTable, nTr ){
	var aData = oTable.fnGetData( nTr );
	var sReplyInput = "  <form class='form-inline pull-right col-lg-9' role='form'>"+
	"<div class='form-group col-lg-9'>"+
	"<label class='sr-only' for='exampleInputEmail2'>输入信息,直接答复用户</label>"+
	"<textarea class='form-control' rows='3' name='content' required></textarea><input type='text' class='hidden' name='fbId' value="+aData.fbId+"></div>"+
	"<button  class='btn btn-danger btn_reply_submit'>提交</button></form>";

    var  answerStr="";
	$.ajax({
        type:'post',
		url:'feedback/answer/getByfbId',
        data:{'fbId':aData.fbId},
        async:false,
		success:function(data){
            var objData = eval(data);
            $.each(objData, function (index, item) {
                var answer ="<blockquote class='clearfix col-lg-9'><p>"+item.content+"</p>  <small>"+moment.unix(item.replyTime/1000).fromNow()+"</small></blockquote>"
                answerStr+=answer;
            });
            return answerStr;
        },
        dataType:'json'
	});
	return sReplyInput+answerStr;
}


	function detail_init(oTable){
		var this_Tr;
    	//详细信息按钮
		$(document).on('click',"#tb_fb_index tbody td img", function () {
			
        	var nTr = $(this).parents('tr')[0];
			if ( oTable.fnIsOpen(nTr) )
			{
				this.src =img_open_path;
				oTable.fnClose( nTr );
			}
			else
			{
				this.src = img_close_path;
				oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
			}   
		});
		
				
		//打开回复窗口按钮
		$(document).on('click','#tb_fb_index tbody td .btn_reply',function(){
			var nTr = $(this).parents('tr')[0];
			this_Tr = nTr;
			var trImg = $(this).parent().parent().children().children("img");
			if ( oTable.fnIsOpen(nTr) )
			{
				if(trImg.attr("src")==img_close_path){
					trImg.attr("src",img_open_path);
					oTable.fnOpen( nTr, fnGetReplyInput(oTable, nTr), 'details');
				}else{
					oTable.fnClose( nTr );
				}
			}
			else
			{
				oTable.fnOpen( nTr, fnGetReplyInput(oTable, nTr), 'details' );
			} 
		});
		//回复提交按钮
		$(document).on('click','#tb_fb_index tbody form .btn_reply_submit',function(){
			var reply_form = $(this).parent("form");
			reply_form.submit(
				function() { 
      			 $(this).ajaxSubmit({
					'type':'post',
					'url':'feedback/answer/add',
					'success':function(data){
						if ( oTable.fnIsOpen(this_Tr) )
						{
							oTable.fnClose( this_Tr );
						}
					}		 
				});
				 return false;
				}
			);
			
		})
}


$(document).ready(function() {
	//格式化时间
	moment.lang('zh_cn');	
	
	var oTable = $('#tb_fb_index').dataTable({
		
		"bProcessing": true,
		"bServerSide": true,	
		"sAjaxSource": "feedback/list",
		"fnServerData": function ( sSource, aoData, fnCallback ) {
			$.ajax( {
				"dataType":'json', 
				"type": "post", 
				"url": sSource,
				"jsonp": "callback",  
				"data": aoData, 
				"success": fnCallback
			});
		},
		"aoColumns": [
			{"sTitle":"","mDataProp":null,"sDefaultContent":"","bSortable": false,"sWidth":"10%",
			"mRender":function ( data, type, full ) {				  
					if(full.imgPath == null && full.logPath==null){
						 return null;
					}else{
						return "<img src="+img_open_path+">";
					}
				  }
			},
			{"sTitle":"","mDataProp":"imgPath","bVisible":false },
			{"sTitle":"","mDataProp":"logPath","bVisible":false },
			{"sTitle":"编号","mDataProp": "fbId","sWidth":"10%"},
			{"sTitle":"内容","mDataProp": "content","sWidth":"30%"}
			,
			{"sTitle":"版本","mDataProp": "version","sWidth":"10%"},
			{"sTitle":"联系","mDataProp": "contact","sWidth":"10%"},
			
			{"sTitle":"时间","mDataProp": "fbDate","sWidth":"10%",
				
				  "mRender": function ( data, type, full ) {				  
					return moment.unix(data/1000).fromNow();
				  }
			},
			{"sTitle":"操作",
				"mDataProp": null,
				"sDefaultContent": "<a class='btn btn-primary btn-sm btn_reply'><span class='glyphicon glyphicon-edit'></span></a><a class='btn btn-default btn-sm'>BUG</a>",
				"bSortable": false,"sWidth":"14%"
			} 
		],
		"aaSorting": [[3, 'desc']],
		
			"oLanguage": {
				"sProcessing":   "处理中...",
				"sLengthMenu":   "显示 _MENU_ 项结果",
				"sZeroRecords":  "没有匹配结果",
				"sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				"sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
				"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
				"sInfoPostFix":  "",
				"sSearch":       "搜索:",
				"sUrl":          "",
				"oPaginate": {
					"sFirst":    "首页",
					"sPrevious": "上页",
					"sNext":     "下页",
					"sLast":     "末页"
			}
		}
	 } );
	 
	 detail_init(oTable);
	 
	 
	 $("select[name='fb_type']").change(function(){
		 oTable.fnFilter($(this).val(), 0 ); 
	});
	$(".status_ul li a").bind("click",function(){
        $(".status_ul li").removeClass("active");
        $(this).parent("li").addClass("active");
		oTable.fnFilter($(this).attr("value"), 1 );
	});
	
});	