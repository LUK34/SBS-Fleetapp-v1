
$('document').ready(function()
{
/* ----------------------------- employee.html-> "Edit" icon logic START -------------------------------------- */
$('table #editButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(employee,status)
			{
				$('#usernameEdit').val(employee.username);
				$('#idEdit').val(employee.id);
       			$('#titleEdit').val(employee.title);
       			$('#initalEdit').val(employee.inital);
       			$('#socialsecuritynumberEdit').val(employee.socialsecuritynumber);
       			$('#firstnameEdit').val(employee.firstname);
       			$('#lastnameEdit').val(employee.lastname);
       			$('#genderEdit').val(employee.gender);
       			$('#countryidEdit').val(employee.countryid);
       			$('#addressEdit').val(employee.address);
       			$('#stateidEdit').val(employee.stateid);
       			$('#cityEdit').val(employee.city);
       			$('#phoneEdit').val(employee.phone);
       			$('#mobileEdit').val(employee.mobile);
       			$('#maritalstatusEdit').val(employee.maritalstatus);
       			$('#emailEdit').val(employee.email);
       			$('#jobtitleidEdit').val(employee.jobtitleid);
       			$('#employeetypeidEdit').val(employee.employeetypeid);
       			
       			var dob = employee.dateofbirth.substr(0,10);
       			$('#dateofbirthEdit').val(dob);
       			
       			var hd = employee.hiredate.substr(0,10);
       			$('#hiredateEdit').val(hd);
       				
        	}
		);
        $('#editModal').modal();
    });
/* ----------------------------- employeee.html-> "Edit" icon logic END -------------------------------------- */




/* ----------------------------- employee.html-> "View" icom logic START -------------------------------------- */
$('table #viewButton').on('click',function(event)
   {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(employee,status)
			{
				$('#idView').val(employee.id);
       			$('#titleView').val(employee.title);
       			$('#initalView').val(employee.inital);
       			$('#socialsecuritynumberView').val(employee.socialsecuritynumber);
       			$('#firstnameView').val(employee.firstname);
       			$('#lastnameView').val(employee.lastname);
       			$('#genderView').val(employee.gender);
       			$('#countryidView').val(employee.countryid);
       			$('#addressView').val(employee.address);
       			
       			$('#stateidView').val(employee.stateid);
       			$('#cityView').val(employee.city);
       			$('#phoneView').val(employee.phone);
       			$('#mobileView').val(employee.mobile);
       			$('#maritalstatusView').val(employee.maritalstatus);
       			$('#emailView').val(employee.email);
       			$('#jobtitleidView').val(employee.jobtitleid);
       			$('#employeetypeidView').val(employee.employeetypeid);
       			
       			
       			var dob = employee.dateofbirth.substr(0,10);
       			$('#dateofbirthView').val(employee.dob);
       			
       			var hd = employee.hiredate.substr(0,10);
       			$('#hiredateView').val(hd);
        	}
		);
        $('#viewModal').modal();
    });

/* ----------------------------- employee.html-> "View" icon logic END -------------------------------------- */


   
/* ----------------------------- employee.html-> "Delete" icon logic START -------------------------------------- */   
$('table #deleteButton').on('click',function(event)
	{
    		event.preventDefault();
    		var href=$(this).attr('href');
			 $('#confirmDeleteButton').attr('href',href);
    		$('#deleteModal').modal();
	});	
/* ----------------------------- employee.html-> "Delete" icon logic END -------------------------------------- */   

/* ----------------------------- employee.html-> image icon click logic START -------------------------------------- */ 
$('.table #photoButton').on('click',function(event) {
   event.preventDefault();
   var href = $(this).attr('href');
   $('#photoModal #employeePhoto').attr('src', href);
   $('#photoModal').modal();		
});	

/* ----------------------------- employee.html-> image icon click logic END -------------------------------------- */ 

	    
});

/*
1. Under state.html .The above logic is for the following:
when the user clicks on edit button a modal called 'editModal' will appear.

2. The event.preventDefault(); will stop showing the JSON object when the user click s on the "Edit" button
*/
