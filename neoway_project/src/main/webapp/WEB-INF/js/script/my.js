$("a[rel=popover]")
	.popover({html:true})
	.click(function(e) {
	e.preventDefault()
})
  
	  //using js trigger
  $("a[rel=popoverTop]")
	.popover({placement: 'top'})
	.click(function(e) {
	  e.preventDefault()
   })
   $(".timepicker").datetimepicker({
	   language:'zh',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"

	});

$("input.users").autocomplete({

    source: function( request, response ) {
        //alert(softId)  ;
        $.ajax({
            url: "plan/geUsers",
            dataType: "json",
            data:{
                keyword:request.term
            },
            type:'post',
            success: function( data ) {
                response( $.map( data.userList, function( item ) {
                    return {
                        label: item.userName + " , " + item.email +(item.trueName==null?" ": (" , " + item.trueName)) +" " +(item.phone==null?" ":( " , " + item.trueName)),
                        value: item.userName
                    }
                }));
            }
        });
    },
    minLength:0,
    open: function() {
        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
    },
    close: function() {
        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
    }
});
