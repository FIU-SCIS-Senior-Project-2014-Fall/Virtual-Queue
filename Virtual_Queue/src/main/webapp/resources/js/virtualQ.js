
		$(document).ready(function() {
				
			$('#loginForm').submit(function(e) {
				// will pass the form date using the jQuery serialize function
				$.post('${pageContext.request.contextPath}/login/signin', $(this).serialize(), function(response) {
					$('#personFormResponse').text(response);
				 //show and hide this modal					
					if(response ==true){
						 alert('valid credentials');
					
					$('#login').modal('hide');
					CleanLoginForm();
					$('#account').modal('show');
					}else {
						
					  alert('invalid credentials');	
					  $('#login').modal('show');
					  CleanLoginForm();				
					}
					CleanLoginForm();
				}); 
				e.preventDefault(); // prevent actual form submit and page reload
			
				
			});
			
			
			$('#registerForm').submit(function(e) {
				// will pass the form date using the jQuery serialize function
				$.post('${pageContext.request.contextPath}/user/add', $(this).serialize(), function(response) {
					$('#personFormResponse').text(response);
					
					if(response ==true){
						 alert('You have been successfully register');
					
					$('#registerForm').modal('hide');
					CleanRegisterForm();
					$('#account').modal('show');
					}else {
						
					  alert('You were not registered :(. Please, Try Again');	
					  $('#registerForm').modal('show');
					  CleanRegisterForm();
										
					}
					CleanRegisterForm();
				}); 	
					
				});
				
				e.preventDefault(); // prevent actual form submit and page reload
			});  					
				
			
		
	$('#login-password').on('click', function () {
		   $(this).attr('type', 'password'); 
		});
	
	
	$('#register-password').on('click', function () {
		   $(this).attr('type', 'password'); 
		});
		
	function CleanLoginForm() {
		$('#login-name').val('') ; 
		$('#login-password').val('') ; 
		$('#login-code').val('') ; 
	}
	
	function CleanRegisterForm() {
		$('#register-name').val('') ;
		$('#register-lastName').val('') ; 
		$('#register-password').val('') ; 
		$('#register-email').val('') ; 
		$('#register-secQuestion').val('') ; 
		$('#register-secAnswer').val('') ; 
		$('#register-cell').val('') ; 
	}
