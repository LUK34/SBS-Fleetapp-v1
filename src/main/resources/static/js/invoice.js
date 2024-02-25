
$('document').ready(function()
{
/* ----------------------------- vehiclemaintenance.html-> "Edit" button logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(i,status)
			{
				$('#idEdit').val(i.id);
				$('#clientidEdit').val(i.clientid);			
			
				var ivd = i.invoicedate.substr(0,10);
				$('#invoicedateEdit').val(ivd);
				$('#invoicestatusidEdit').val(i.invoicestatusid);
				$('#remarksEdit').val(i.remarks);
        		
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- vehiclemaintenance.html-> "Edit" button logic END -------------------------------------- */



/* ----------------------------- vehiclemaintenance.html-> "View" button logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(i,status)
			{
				$('#idView').val(i.id);
				$('#clientidView').val(i.clientid);			
			
				var ivd = i.invoicedate.substr(0,10);
				$('#invoicedateView').val(ivd);
				$('#invoicestatusidView').val(i.invoicestatusid);
				$('#remarksView').val(i.remarks);
        	}
		);
        $('#viewModal').modal();
    });
/* ----------------------------- vehiclemaintenance.html-> "View" button logic END -------------------------------------- */

   
/* ----------------------------- vehiclemaintenance.html-> "Delete" button logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- vehiclemaintenance.html-> "Delete" button logic END -------------------------------------- */   	    
});

/*
1. Under vehiclemaintenance.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
