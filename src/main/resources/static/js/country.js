
$('document').ready(function()
{
/* ----------------------------- Country.html-> "Edit" button logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(country,status)
			{
       			$('#idEdit').val(country.id);
        		$('#descriptionEdit').val(country.description);
        		$('#capitalEdit').val(country.capital);
       			$('#codeEdit').val(country.code);
       			$('#continentEdit').val(country.continent);
        		$('#nationalityEdit').val(country.nationality);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- Country.html-> "Edit" button logic END -------------------------------------- */



/* ----------------------------- Country.html-> "View" button logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(country,status)
			{
       			$('#idView').val(country.id);
        		$('#descriptionView').val(country.description);
        		$('#capitalView').val(country.capital);
       			$('#codeView').val(country.code);
       			$('#continentView').val(country.continent);
        		$('#nationalityView').val(country.nationality);
        	}
		);
        $('#viewModal').modal();
    });
/* ----------------------------- Country.html-> "View" button logic END -------------------------------------- */

   
/* ----------------------------- Country.html-> "Delete" button logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- Country.html-> "Delete" button logic END -------------------------------------- */   	    
});

/*
1. Under country.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
