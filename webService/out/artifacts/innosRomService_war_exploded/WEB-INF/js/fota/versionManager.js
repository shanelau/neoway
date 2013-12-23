$(document).ready(function() {
    //格式化时间
    moment.lang('zh_cn');

    var oTable = $('#tb_fota_version').dataTable({

        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "fota/version/list",
        /* "sDom":'T<"clear">lfrtip',
        "oTableTools": {
            "sSwfPath": "js/datatable/extra/tableTool/media/swf/copy_csv_xls_pdf.swf"
        },*/
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
            {"sTitle":"编号","mDataProp": "versionId","sWidth":"10%","asSorting": [ "desc" ]},
            {"sTitle":"型号名","mDataProp": "fotaBrandByBrandId.product","sWidth":"10%"},
            {"sTitle":"版本号","mDataProp": "versionName","sWidth":"20%"},
            {"sTitle":"版本描述","mDataProp": "versionDesc","sWidth":"20%"},
            {"sTitle":"发布日期","mDataProp": "versionDate","sWidth":"10%",
                "mRender": function ( data, type, full ) {
                    return moment.unix(data/1000).fromNow();
                }
            },
            {"sTitle":"操作","mDataProp": null,"sWidth":"20%",
                "sDefaultContent": "<a class='btn btn-primary btn-sm btn_update_version'><span class='glyphicon glyphicon-edit'></span></a>" +
                    "<a class='btn btn-default btn-sm btn_delete_version'><span class='glyphicon glyphicon-trash'></a>"+
                    "<a class='btn btn-default btn-sm btn_upload_version'><span class='glyphicon glyphicon-arrow-up'></a>"
            }
        ],
        "aaSorting": [[ 0, "asc" ]],
        "oLanguage": {
            "sUrl": "js/datatable/lang/dataTables.german.txt"
        }

    } );
    //添加一个品牌
    function fnClickAddRow() {
        $("form[name='form_add_version']").ajaxSubmit(
            function(data){
                if(data !=null){
                    oTable.fnAddData(data);
                    $("#addVersionModal").modal('hide');
                }else{
                    alert("提交失败！");
                }
                return false;
            });
    }
    $("#btn_add_version").bind("click",function(){
        fnClickAddRow();
    });
    $("select[name='brandId']").bind("focus",function(){
        //console.info("focus...");
        var select = $(this);
        $.post(
            "fota/brand/list",
            function(data){
                var objData = eval(data.aaData);
                var html = "";
                $.each(objData, function (index, item) {
                      html += "<option value="+item.brandId+">"+item.product+"</option>"
                });
                select.html("");
                select.append(html);
            }
        );

    });
   //删除一个品牌
    $(document).on("click","#tb_fota_version tr td .btn_delete_version",function(){
        var tr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(tr);
        $.post(
            "fota/version/delete/"+sData.versionId,
            function(data){
                if(data != null){
                    oTable.fnDeleteRow(tr);
                }
            }
        );
    });
    //更新一个品牌
    var currentTr;
    $(document).on("click","#tb_fota_version tr td .btn_update_version",function(){
        currentTr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(currentTr);
        $("#updateVersionModal input").val("");
        $("#updateVersionModal").modal("show");

        $("#updateVersionModal input[name='versionId']").val(sData.versionId);
        $("#updateVersionModal select[name='brandId']").html("");
        $("#updateVersionModal select[name='brandId']").append("<option value="+sData.fotaBrandByBrandId.brandId+" selected>"+sData.fotaBrandByBrandId.product+"</option>")
        $("#updateVersionModal input[name='versionName']").val(sData.versionName);
        $("#updateVersionModal input[name='versionDesc']").val(sData.versionDesc);
    });
    $("#btn_update_version").bind("click",function(){
        $("form[name='form_update_version']").ajaxSubmit(function(data){
               if(data != null ){
                   oTable.fnUpdate(data,currentTr);
                   $("#updateVersionModal").modal("hide");
               }
        })  ;

    });


});