
$('document').ready(function()
{
/* ----------------------------- vehiclemovement.html-> "Edit" button logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleMovement,status)
			{
				$('#idEdit').val(vehicleMovement.id);
				$('#vehicleidEdit').val(vehicleMovement.vehicleid);
				$('#locationid1Edit').val(vehicleMovement.locationid1);
				$('#locationid2Edit').val(vehicleMovement.locationid2);
			
				var date1 = vehicleMovement.date1.substr(0,10);
				var date2 = vehicleMovement.date2.substr(0,10);
				$('#date1Edit').val(date1);
				$('#date2Edit').val(date2);
				
				$('#remarksEdit').val(vehicleMovement.remarks);
        		
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- vehiclemovement.html-> "Edit" button logic END -------------------------------------- */



/* ----------------------------- vehiclemovement.html-> "View" button logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleMovement,status)
			{
       			$('#idView').val(vehicleMovement.id);
				$('#vehicleidView').val(vehicleMovement.vehicleid);
				$('#locationid1View').val(vehicleMovement.locationid1);
				$('#locationid2View').val(vehicleMovement.locationid2);
			
				var date1 = vehicleMovement.date1.substr(0,10);
				var date2 = vehicleMovement.date2.substr(0,10);
				$('#date1View').val(date1);
				$('#date2View').val(date2);
				
				
				$('#remarksView').val(vehicleMovement.remarks);
        	}
		);
        $('#viewModal').modal();
    });
/* ----------------------------- vehiclemovement.html-> "View" button logic END -------------------------------------- */

   
/* ----------------------------- vehiclemovement.html-> "Delete" button logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- vehiclemovement.html-> "Delete" button logic END -------------------------------------- */   	    
});

/*
1. Under vehiclemovement.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
