$(document).ready(function() {
    //格式化时间
   // moment.lang('zh_cn');

    var oTable = $('#tb_fota_brand').dataTable({

        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "fota/brand/list",
      /*  "sDom":'T<"clear">lfrtip',
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
            {"sTitle":"编号","mDataProp": "brandId","sWidth":"10%"},
            {"sTitle":"品牌商","mDataProp": "brandName","sWidth":"10%"},
            {"sTitle":"oem","mDataProp": "oem","sWidth":"10%"},
            {"sTitle":"型号","mDataProp": "product","sWidth":"30%"},
            {"sTitle":"语言","mDataProp": "language","sWidth":"10%"},
            {"sTitle":"操作","mDataProp": null,"sWidth":"10%",
                "sDefaultContent": "<a class='btn btn-primary btn-sm btn_update_brand'><span class='glyphicon glyphicon-edit'></span></a><a class='btn btn-default btn-sm btn_delete_brand'><span class='glyphicon glyphicon-trash'></a>"
            }
        ],
        "aaSorting": [[ 0, "asc" ]],
        "oLanguage": {
            "sUrl": "js/datatable/lang/dataTables.german.txt"
        }

    } );
    //添加一个品牌
    function fnClickAddRow() {
        $("form[name='form_add_brand']").ajaxSubmit(
            function(data){
                if(data !=null){
                    oTable.fnAddData(data);
                    $("#addBrandModal").modal('hide');
                }else{
                    alert("提交失败！");
                }
                return false;
            });
    }
    $("#btn_add_brand").bind("click",function(){
        fnClickAddRow();
    });
   //删除一个品牌
    $(document).on("click","#tb_fota_brand tr td .btn_delete_brand",function(){
        var tr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(tr);
       // alert($.toJSON(sData));
        if(window.confirm("点击确定，将会删除,该型号下的所有软件版本")){
            $.post(
                "fota/brand/delete/"+sData.brandId,
                function(data){
                    if(data != null){
                        oTable.fnDeleteRow(tr);
                    }
                }
            );
        }

    });
    //更新一个品牌
    var currentTr;
    $(document).on("click","#tb_fota_brand tr td .btn_update_brand",function(){
        currentTr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(currentTr);
        $("#updateBrandModal input").val("");
        $("#updateBrandModal").modal("show");

        $("#updateBrandModal input[name='brandId']").val(sData.brandId);
        $("#updateBrandModal input[name='brandName']").val(sData.brandName);
        $("#updateBrandModal input[name='oem']").val(sData.oem);
        $("#updateBrandModal input[name='product']").val(sData.product);
        $("#updateBrandModal input[name='language']").val(sData.language);
    });
    $("#btn_update_brand").bind("click",function(){
        $("form[name='form_update_brand']").ajaxSubmit(function(data){
               if(data != null ){
                   oTable.fnUpdate(data,currentTr);
                   $("#updateBrandModal").modal("hide");
               }
        })  ;

    });


});