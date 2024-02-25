
$('document').ready(function()
{
/* ----------------------------- vehiclemovement.html-> "Edit" button logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(v,status)
			{
				$('#idEdit').val(v.id);
				$('#vehicleidEdit').val(v.vehicleid);
				$('#clientidEdit').val(v.clientid);			
			
				var dn = v.datein.substr(0,10);
				var dout = v.dateout.substr(0,10);
				$('#dateinEdit').val(dn);
				$('#dateoutEdit').val(dout);
			
				$('#timeinEdit').val(v.timein);
				$('#timeoutEdit').val(v.timeout);
			
				$('#locationidEdit').val(v.locationid);
				$('#priceEdit').val(v.price);
				$('#remarksEdit').val(v.remarks);
				
        		
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
        $.get(href, function(v,status)
			{
       			$('#idView').val(v.id);
				$('#vehicleidView').val(v.vehicleid);
				$('#clientidView').val(v.clientid);			
			
				var dn = v.datein.substr(0,10);
				var dout = v.dateout.substr(0,10);
				$('#dateinView').val(dn);
				$('#dateoutView').val(dout);
			
				$('#timeinView').val(v.timein);
				$('#timeoutView').val(v.timeout);
			
				$('#locationidView').val(v.locationid);
				$('#priceView').val(v.price);
				$('#remarksView').val(v.remarks);
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
