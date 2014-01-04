$(document).ready(function() {
    //格式化时间
   // moment.lang('zh_cn');

    var oTable = $('#tb_fota_imei').dataTable({

        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "fota/imei/list",
        "bSort": false,
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
            {"sTitle":"IMEI号","mDataProp": "imei","sWidth":"10%"},
            {"sTitle":"添加时间","mDataProp": "imeiDate","sWidth":"10%",
                "mRender":function(data,type,full){
                    return moment.unix(data/1000).fromNow();
                }
            },
            {"sTitle":"操作","mDataProp": null,"sWidth":"10%",
                "sDefaultContent": "<a class='btn btn-default btn-sm btn_delete_imei'><span class='glyphicon glyphicon-trash'></a>"
            }
        ],
        "aaSorting": [[ 0, "asc" ]],
        "oLanguage": {
            "sUrl": "js/datatable/lang/dataTables.german.txt"
        }

    } );
    //添加一个品牌
    function fnClickAddRow() {
        $("form[name='form_add_imei']").ajaxSubmit(
            function(data){
                if(data !=null){
                    oTable.fnAddData(data);
                    $("#addImeiModal").modal('hide');
                    window.location = "fota/imei/index";
                }else{
                    alert("提交失败！");
                }
                return false;
            });
    }
    $("#btn_add_imei").bind("click",function(){
        fnClickAddRow();
    });
   //删除一个品牌
    $(document).on("click","#tb_fota_imei tr td .btn_delete_imei",function(){
        var tr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(tr);
        $.post(
            "fota/imei/delete/"+sData.imei,
            function(data){
                if(data != null){
                    oTable.fnDeleteRow(tr);
                }
            }
        );


    });
});