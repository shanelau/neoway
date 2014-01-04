$(document).ready(function() {
    $("header li[name='fota']").addClass("active");
    //格式化时间
    moment.lang('zh_cn');
    var versionId = $("input[name='versionId']").val();
    var oTable = $('#tb_fota_version_upload').dataTable({

        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "fota/file/list/"+versionId,
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
            {"sTitle":"编号","mDataProp": "fileId","sWidth":"5%"},
            {"sTitle":"当前版本号","mDataProp": "fotaVersionByVersionId.versionName","sWidth":"10%","asSorting": [ "desc" ]},
            {"sTitle":"文件名","mDataProp": "fileName","sWidth":"10%"},
            {"sTitle":"大小","mDataProp": "size","sWidth":"10%"},
            {"sTitle":"上传时间","mDataProp": "fileDate","sWidth":"10%",
                "mRender": function ( data, type, full ) {
                    return moment.unix(data/1000).fromNow();
                }
            },
            {"sTitle":"操作","mDataProp": "url","sWidth":"10%",
                "mRender": function ( data, type, full ) {

                    return "<a class='btn btn-default btn-sm btn_send_version_file_test' title='推送测试'><span class='glyphicon glyphicon-send'> 推送测试</span></a>"+
                    "<a class='btn btn-primary btn-sm btn_send_version_file' title='推送升级'><span class='glyphicon glyphicon-send'></span></a>" +
                        "<a class='btn btn-default btn-sm btn_delete_version_file' title='删除'><span class='glyphicon glyphicon-trash'></a>"+
                        "<a class='btn btn-default btn-sm btn_upload_version_file' target='_blank' title='下载'  href='"+data+"'><span class='glyphicon glyphicon glyphicon-cloud-download'></a>";
                }
            }
        ],
        "aaSorting": [[ 0, "asc" ]],
        "oLanguage": {
            "sUrl": "js/datatable/lang/dataTables.german.txt"
        }

    } );
    //添加一个品牌
    function fnClickAddRow() {
        $("form[name='form_add_version_file']").ajaxSubmit(
            function(data){
                if(data.status){
                    oTable.fnAddData(data.obj);
                    $("#addVersionFileModal").modal('hide');
                }else{
                    alert(data.obj);
                }
                $("#btn_add_version_file").button('reset');
                return false;
            });
    }
    $("#btn_add_version_file").bind("click",function(){
        $("#btn_add_version_file").button('loading');
        fnClickAddRow();
    });
    $("select[name='startVersionId']").bind("focus",function(){
        //console.info("focus...");
        var select = $(this);

        $.post(
            "fota/version/lessList/"+versionId,
            function(data){
                var objData = eval(data);
                var html = "";
                $.each(objData, function (index, item) {
                      html += "<option value="+item.versionId+">"+item.versionName+"</option>"
                });
                select.html("");
                select.append(html);
            }
        );

    });
   //删除一个品牌
    $(document).on("click","#tb_fota_version_upload tr td .btn_delete_version_file",function(){
        var tr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(tr);
        $.post(
            "fota/file/delete/"+sData.fileId,
            function(data){
                if(data != null){
                    oTable.fnDeleteRow(tr);
                }
            }
        );
    });
    //推送
    $(document).on("click","#tb_fota_version tr td .btn_send_version_file_test",function(){
        var currentTr = $(this).parents("tr")[0];
        var sData = oTable.fnGetData(currentTr);
        send(sData.fileId);
    });
    function send(fileId,object){
        $.post(
            "fota/file/send/"+fileId,
            {"range":object},
            function(data){
                alert(data.obj);
            }
        );
    }


});