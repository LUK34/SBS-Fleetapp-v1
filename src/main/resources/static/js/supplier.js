
$('document').ready(function()
{
/* ----------------------------- supplier.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(s,status)
			{
				$('#idEdit').val(s.id);
       			$('#nameEdit').val(s.name);
       			$('#websiteEdit').val(s.website);			
       			$('#emailEdit').val(s.email);
				$('#cityEdit').val(s.city);
				$('#phoneEdit').val(s.phone);	
				$('#addressEdit').val(s.address);
       			$('#mobileEdit').val(s.mobile);			
				$('#countryidEdit').val(s.countryid);
				$('#stateidEdit').val(s.stateid);
				$('#detailsEdit').val(s.details);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- supplier.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- supplier.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(s,status)
			{
				$('#idView').val(s.id);
       			$('#nameView').val(s.name);
       			$('#websiteView').val(s.website);			
       			$('#emailView').val(s.email);
				$('#cityView').val(s.city);
				$('#phoneView').val(s.phone);
				$('#addressView').val(s.address);
       			$('#mobileView').val(s.mobile);			
				$('#countryidView').val(s.countryid);
				$('#stateidView').val(s.stateid);
				$('#detailsView').val(s.details);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- supplier.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- supplier.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- supplier.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
