
$('document').ready(function()
{
/* ----------------------------- client.html-> "Edit" icon logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(c,status)
			{
				$('#idEdit').val(c.id);
       			$('#nameEdit').val(c.name);
       			$('#detailsEdit').val(c.details);
       			$('#websiteEdit').val(c.website);
        		$('#addressEdit').val(c.address);
        		$('#emailEdit').val(c.email);
       			$('#countryEdit').val(c.countryid);  			
       			$('#stateEdit').val(c.stateid);
       			$('#cityEdit').val(c.city);
       			$('#phoneEdit').val(c.phone);
       			$('#mobileEdit').val(c.mobile);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- client.html-> "Edit" icon logic END -------------------------------------- */




/* ----------------------------- client.html-> "View" icom logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(c,status)
			{
				$('#idView').val(c.id);
       			$('#nameView').val(c.name);
       			$('#detailsView').val(c.details);
       			$('#websiteView').val(c.website);
        		$('#addressView').val(c.address);
        		$('#emailView').val(c.email);
       			$('#countryView').val(c.countryid);  			
       			$('#stateView').val(c.stateid);
       			$('#cityView').val(c.city);
       			$('#phoneView').val(c.phone);
       			$('#mobileView').val(c.mobile);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- client.html-> "View" icon logic END -------------------------------------- */


   
/* ----------------------------- client.html-> "Delete" icon logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- client.html-> "Delete" icon logic END -------------------------------------- */   	    
});

/*
1. Under client.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
