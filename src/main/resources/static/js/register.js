$('document').ready(function(){			
	var password = document.getElementById("password")
	var confirmPassword = document.getElementById("confirmpassword");
	
	function validatePassword(){
	  if(password.value != confirmPassword.value)
	   {
	    confirmPassword.setCustomValidity("Passwords Don't Match");
	  } 
	  else 
	  {
	    confirmPassword.setCustomValidity('');
	  }
	}	
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;		
});

/*
1.code:
function validatePassword(){
	  if(password.value != confirmPassword.value)
	   {
	    confirmPassword.setCustomValidity("Passwords Don't Match");
	  } 
	  else 
	  {
	    confirmPassword.setCustomValidity('');
	  }
The above code will confirm whether the password entered by the user and the confirm password are same or not
 
 2.code:
 password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;		
 
  The above code is used f the user changes the password again the application has to check again
 
 */