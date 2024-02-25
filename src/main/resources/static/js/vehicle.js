
$('document').ready(function()
{
/* ----------------------------- vehicle.html-> "EditButton" when this icon is clicked logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(v,status)
			{
       			$('#idEdit').val(v.id);
				$('#vehicletypeidEdit').val(v.vehicletypeid);
				$('#nameEdit').val(v.name);
				$('#vehiclenumberEdit').val(v.vehiclenumber);
				
				$('#registrationdateEdit').val(v.registrationdate);
				
				var rd = v.registrationdate.substr(0,10);
				$('#registrationdateEdit').val(rd);
       			
				$('#descriptionEdit').val(v.description);
				
				var ad = v.acquisitiondate.substr(0,10);
				$('#acquisitiondateEdit').val(ad);
				
				$('#vehiclemakeidEdit').val(v.vehiclemakeid);
				$('#vehiclemodelidEdit').val(v.vehiclemodelid);
				$('#locationidEdit').val(v.locationid);
				$('#powerEdit').val(v.power);
				$('#fuelcapacityEdit').val(v.fuelcapacity);
				$('#netweightEdit').val(v.netweight);
				$('#remarksEdit').val(v.remarks);
				$('#employeeidEdit').val(v.employeeid);
       			$('#vehiclestatusidEdit').val(v.vehiclestatusid);
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- vehicle.html-> "EditButton" when this icon is clicked logic END -------------------------------------- */




/* ----------------------------- vehicle.html-> "ViewButton" icon when this icon is clicked logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(v,status)
			{
       			$('#idView').val(v.id);
				$('#vehicletypeidView').val(v.vehicletypeid);
				$('#nameView').val(v.name);
				$('#vehiclenumberView').val(v.vehiclenumber);
				
				var rd = v.registrationdate.substr(0,10);
				$('#registrationdateView').val(rd);
				
				$('#descriptionView').val(v.description);
				
				var ad = v.acquisitiondate.substr(0,10);
				$('#acquisitiondateView').val(ad);
				
				$('#vehiclemakeidView').val(v.vehiclemakeid);
				$('#vehiclemodelidView').val(v.vehiclemodelid);
				$('#locationidView').val(v.locationid);
				$('#powerView').val(v.power);
				$('#fuelcapacityView').val(v.fuelcapacity);
				$('#netweightView').val(v.netweight);
				$('#remarksView').val(v.remarks);
				$('#employeeidView').val(v.employeeid);
       			$('#vehiclestatusidView').val(v.vehiclestatusid);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- vehicle.html-> "ViewButton" icon when this icon is clicked logic END -------------------------------------- */


   
/* ----------------------------- vehicle.html-> "DeleteButton" icon when this icon is clicked logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- vehicle.html-> "DeleteButton" icon when this icon is clicked logic END -------------------------------------- */   	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
