
$('document').ready(function()
{
/* ----------------------------- vehiclemake.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(common,status)
			{
       			$('#idEdit').val(common.id);
       			$('#descriptionEdit').val(common.description);			
       			$('#detailsEdit').val(common.details);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- vehiclemake.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- vehiclemake.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(common,status)
			{
       			$('#idView').val(common.id);
       			$('#descriptionView').val(common.description); 			
       			$('#detailsView').val(common.details);
       			$('#createdbyView').val(common.createdby);
       			$('#createddateView').val(common.createddate.substr(0,19).replace("T", " ")); 			
       			$('#lastmodifiedbyView').val(common.lastmodifiedby);
       			$('#lastmodifieddateView').val(common.lastmodifieddate.substr(0,19).replace("T", " ")); 	
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- vehiclemake.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- vehiclemake.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- vehiclemake.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
