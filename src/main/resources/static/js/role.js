
$('document').ready(function()
{
/* ----------------------------- role.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(role,status)
			{
       			$('#idEdit').val(role.id);
       			$('#descriptionEdit').val(role.description);			
       			$('#detailsEdit').val(role.details);
       			$('#createdbyView').val(role.createdby);
       			$('#createddateView').val(role.createddate.substr(0,19).replace("T", " ")); 			
       			$('#lastmodifiedbyView').val(role.lastmodifiedby);
       			$('#lastmodifieddateView').val(role.lastmodifieddate.substr(0,19).replace("T", " ")); 	
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- role.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- role.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(role,status)
			{
       			$('#idView').val(role.id);
       			$('#descriptionView').val(role.description); 			
       			$('#detailsView').val(role.details);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- role.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- role.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- role.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
