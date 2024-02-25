
$('document').ready(function()
{
/* ----------------------------- location.html-> "Edit" icon logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(location,status)
			{
       			$('#idEdit').val(location.id);
       			$('#descriptionEdit').val(location.description);
       			$('#cityEdit').val(location.city);
        		$('#addressEdit').val(location.address);
        		$('#countryEdit').val(location.countryid);
       			$('#stateEdit').val(location.stateid);  			
       			$('#detailsEdit').val(location.details);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- location.html-> "Edit" icon logic END -------------------------------------- */




/* ----------------------------- location.html-> "View" icom logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(location,status)
			{
       			$('#idView').val(location.id);
       			$('#descriptionView').val(location.description);
       			$('#cityView').val(location.city);
        		$('#addressView').val(location.address);
        		$('#countryView').val(location.countryid);
       			$('#stateView').val(location.stateid);  			
       			$('#detailsView').val(location.details);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- location.html-> "View" icon logic END -------------------------------------- */


   
/* ----------------------------- location.html-> "Delete" icon logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- location.html-> "Delete" icon logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
