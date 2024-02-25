
$('document').ready(function()
{
/* ----------------------------- State.html-> "Edit" icon logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(state,status)
			{
       			$('#idEdit').val(state.id);
        		$('#capitalEdit').val(state.capital);
        		$('#codeEdit').val(state.code);
       			$('#countryidEdit').val(state.countryid);
       			$('#detailsEdit').val(state.details);
        		$('#nameEdit').val(state.name);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- State.html-> "Edit" icon logic END -------------------------------------- */




/* ----------------------------- State.html-> "View" icom logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(state,status)
			{
       			$('#idView').val(state.id);
        		$('#capitalView').val(state.capital);
        		$('#codeView').val(state.code);
       			$('#countryidView').val(state.countryid);
       			$('#detailsView').val(state.details);
        		$('#nameView').val(state.name);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- State.html-> "View" icon logic END -------------------------------------- */


   
/* ----------------------------- State.html-> "Delete" icon logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- State.html-> "Delete" icon logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
