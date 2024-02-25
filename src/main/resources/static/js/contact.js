
$('document').ready(function()
{
/* ----------------------------- contact.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(c,status)
			{
				$('#idEdit').val(c.id);
				$('#firstnameEdit').val(c.firstname);
				$('#lastnameEdit').val(c.lastname);	
				$('#phoneEdit').val(c.phone);			
				$('#emailEdit').val(c.email);
				$('#mobileEdit').val(c.mobile);
				$('#remarksEdit').val(c.remarks);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- contact.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- contact.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(c,status)
			{
				$('#idView').val(c.id);
       			$('#firstnameView').val(c.firstname);
				$('#lastnameView').val(c.lastname);	
				$('#phoneView').val(c.phone);			
				$('#emailView').val(c.email);
				$('#mobileView').val(c.mobile);
				$('#remarksView').val(c.remarks);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- contact.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- contact.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- contact.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
