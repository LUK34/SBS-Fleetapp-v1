
$('document').ready(function()
{
/* ----------------------------- vehiclema.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(v,status)
			{
       			$('#idEdit').val(v.id);
				$('#vehicleidEdit').val(v.vehicleid);
				$('#remarksEdit').val(v.remarks);
				$('#supplieridEdit').val(v.supplierid);
				$('#priceEdit').val(v.price);
				
				
				//Create a date variable and extract only the date part of the fiedl
				var sd = v.startdate.substr(0,10);
				var ed = v.enddate.substr(0,10);
			
				$('#startdateEdit').val(sd);
				$('#enddateEdit').val(ed);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- vehiclema.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- vehiclema.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(v,status)
			{
       			$('#idView').val(v.id);
				$('#vehicleidView').val(v.vehicleid);
				$('#remarksView').val(v.remarks);
				$('#supplieridView').val(v.supplierid);
				$('#priceView').val(v.price);
				
				
				//Create a date variable and extract only the date part of the fiedl
				var sd = v.startdate.substr(0,10);
				var ed = v.enddate.substr(0,10);
			
				$('#startdateView').val(sd);
				$('#enddateView').val(ed);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- vehiclema.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- vehiclema.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- vehiclema.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
