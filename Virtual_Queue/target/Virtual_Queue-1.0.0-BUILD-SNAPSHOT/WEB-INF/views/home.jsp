<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Virtual Queue</title>



<link href="<c:url value="/resources/css/bootstrap.min.css" /> "rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" /> "rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-table.css" /> "rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/styles.css" />"rel="stylesheet" type="text/css" />


<script type="text/javascript"src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/bootstrap-table.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/bootstrapValidator.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/jquery.cookie.js" />"></script>


</head>
<body>

	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">

			<a href="#" class="navbar-brand"> Welcome to the Venue! </a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">

					<li class="active"><a href="#"> Home </a></li>
					<li><a href="#register" data-toggle="modal"> Register </a></li>
					<li><a href="#login" data-toggle="modal"> Login </a></li>
					<li><a href="#rides" data-toggle="modal"> Rides </a></li>
					<li><a href="#account" data-toggle="modal"> MyAccount </a></li>
					<li class = "dropdown"><a href="#" class= "dropdown-toggle" data-toggle="dropdown" > Admin <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
            			<li><a href="#admin" data-toggle="modal">Login</a></li>
            			<li><a href="#search" data-toggle="modal">Search</a></li>
					</ul>
					
					</li>

				</ul>

			</div>

		</div>

	</div>

	<div class="container-fluid">

		<div class="row">

			<div class="col-lg-12">

				<div class="panel-default">

					<div class="panel-body">

						<divclass "page-header">
								<h4> Venue Website <small>| Senior Project </small></h4>
						
							</div>
							
							<img class = "featuredImg" src= "<c:url value="/resources/img/universal.jpg" />" width = "100%"/>
					
					
						</div>
						
					</div>
			
				</div>
			
				
			
			</div>
		
		
		</div>

	<div class="container-fluid">

		<div class="row">

			<div class="col-md-4">

				<h3>
					<a href="#"> Guardians of the Galaxy Ride</a>
				</h3>
				<p>This ride is "Coming Soon", and it will make you feel like you are living in a world
					where you can travel the entire universe and save it from villains.
					Enjoy the infinite and interactive experiences with your family and
					friends. Consider the fact that you need to be at least 47" to be
					on this amazing ride.</p>
				<a href="#" class="btn btn default">Select</a>

			</div>

			<div class="col-md-4">

				<h3>
					<a href="#"> A Holiday Celebration Event</a>
				</h3>
				<p>Come to the venue to celebrate together this amazing time of
					the year, where is all about sharing love, and having fun. Bring
					your family and friends to enjoy a wonderful time. Celebrate with
					incredible clowns, amazing marching bands, and much more.</p>
				<a href="#" class="btn btn default">Select</a>

			</div>

			<div class="col-md-4">

				<h3>
					<a href="#"> Live Music</a>
				</h3>
				<p>We offer a variety of live music for everyone to enjoy. No
					matter in what part of the park you are, we will make you feel the
					music. Or you can just to the live music area and sing along with
					the wonderful singers and enjoy the performance.</p>
				<a href="#" class="btn btn default">Select</a>

			</div>



		</div>

	</div>

	<div class="navbar navbar-default navbar-fixed-bottom">

		<div class="container-fluid">
			<p class=navbar-textpull-left">Virtual Queue | Senior Project</p>
		</div>

	</div>



	<div class="modal fade" id="login" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id = "loginForm">
							 
					<div class="modal-header">
						<h4>Venue Park Login Form</h4>
					</div>							
					
					<div class="error hide" id="idError">Invalid Credentials. Please, Try Again</div>
					


					<div class="modal-body">

						<div class="form-group">
							<label for="login-username" class="col-lg-2 control-label">Username:</label>
							<div class="col-lg-10">
								<input name = "userName" type="email" class="form-control" id="login-name"
									placeholder="user@example.com">
							</div>
						</div>

						<div class="form-group">
							<label for="login-password" class="col-lg-2 control-label">Password:</label>
							<div class="col-lg-10">
								<input name = "password" type="password" class="form-control" id="login-password"
									placeholder="" >
							</div>
						</div>

						<div class="form-group">
							<label for="login-code" class="col-lg-2 control-label">Code:</label>
							<div class="col-lg-10">
								<input name = "code" type="code" class="form-control" id="login-code"
									placeholder="ABC123456">
							</div>
						</div>

					</div>

					<div class="modal-footer">

						<div class="col-md-2">						
							<button type="submit" value= "Send" class="btn btn-info pull-left " id = "submit">Login</button>
						</div>

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-Login" >Cancel</button>
						</div>

						<div class="col-md-4">
							<li><a href="#reset" data-toggle="modal" id = "forgotPasswordForward" >Forgot Password</a></li>
						</div>

						<div class="col-md-4">
							<li><a href="#register" data-toggle="modal" id = "createAccountForward" >Create Account</a></li>
						</div>


					</div>
			</div>
			</form>
		</div>

	</div> 
	

	<div class="modal fade" id="register" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id = "registerForm" >
					<div class="modal-header">
						<h4>Theme Park Register Form</h4>
					</div>

					<div class="modal-body">
					 
						<div class="form-group">

							<label for="register-name" class="col-lg-2 control-label">Name:</label>
							<div class="col-lg-10">
								<input name= "firstName" type="text" class="form-control" id="register-name"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="register-lastName" class="col-lg-2 control-label">Last
								Name:</label>
							<div class="col-lg-10">
								<input name= "lastName"type="text" class="form-control" id="register-lastName"
									placeholder="">
							</div>

						</div>


						<div class="form-group">

							<label for="register-password" class="col-lg-2 control-label">Password:</label>
							<div class="col-lg-10">
								<input name= "password" type="password" class="form-control" id="register-password"
									placeholder="">
							</div>

						</div>
						
						<div class="form-group">

							<label for="register-email" class="col-lg-2 control-label">Email:</label>
							<div class="col-lg-10">
								<input name= "email" type="text" class="form-control" id="register-email"
									placeholder="user@example.com">
							</div>

						</div>

						<div class="form-group">

							<label for="register-secQuestion" class="col-lg-2 control-label">Security
								Question:</label>
							<div class="col-lg-10">
								<select name= "securityQuestion" class="form-control id = "register-secQuestion" placeholder="">
									<option value="one">One</option>
									<option value="two">Two</option>
									<option value="three">Three</option>
									<option value="four">Four</option>
									<option value="five">Five</option>
								</select>
							</div>

						</div>

						<div class="form-group">

							<label for="register-secAnswer" class="col-lg-2 control-label">Security
								Answer:</label>
							<div class="col-lg-10">
								<input name = "securityAnswer" type="text" class="form-control" id="register-secAnswer"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="register-cell" class="col-lg-2 control-label">Phone
								Number:</label>
							<div class="col-lg-10">
								<input name = "phoneNumber" type="text" class="form-control" id="register-cell"
									placeholder="">
							</div>

						</div>
						
						<div class="form-group">

							<label for="register-age" class="col-lg-2 control-label">Age:</label>
							<div class="col-lg-10">
								<input name= "age" type="text" class="form-control" id="register-age"
									placeholder="">
							</div>

						</div>

					</div>

							<div class="modal-footer">

								<div class="col-md-2">
									<button type="submit" value="Send"
										class="btn btn-info pull-left" id="submit">Submit</button>
								</div>


								<div class="col-md-2">
									<button type="button" class="btn btn-info pull-left "
										data-dismiss="modal" id="register_cancel" >Cancel</button>
								</div>

								<div id="personFormResponse" class="green"></div>

							</div>
						
						</form>
		
		</div>
</div>
	</div>

	<div class="modal fade" id="reset" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id = "resetPasswordForm" >
					<div class="modal-header">
						<h4>Reset Password Form</h4>
					</div>

					<div class="modal-body">


						<div class="form-group">

							<label for="reset-username" class="col-lg-2 control-label">Username:</label>
							<div class="col-lg-10">
								<input name= "userName" type="email" class="form-control" id="reset-usernameReset"
									placeholder="user@example.com">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-secQuestion" class="col-lg-2 control-label">Security
								Question:</label>
							<div class="col-lg-10">
								<select name = "securityQuestion" class="form-control" id ="reset-secQuestionReset" placeholder ="">

									<option value="one">One</option>
									<option value="two">Two</option>
									<option value="three">Three</option>
									<option value="four">Four</option>
									<option value="five">Five</option>
								</select>
							</div>

						</div>

						<div class="form-group">

							<label for="reset-secAnswer" class="col-lg-2 control-label">Security
								Answer:</label>
							<div class="col-lg-10">
								<input name = "securityAnswer" type="text" class="form-control" id="reset-secAnswerReset"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-password" class="col-lg-2 control-label">New
								Password:</label>
							<div class="col-lg-10">
								<input name = "newPassword" type="password" class="form-control" id="reset-newPasswordReset"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-password" class="col-lg-2 control-label">Confirm
								Password:</label>
							<div class="col-lg-10">
								<input name= "confirmNewPassword" type="password" class="form-control" id="reset-confirmNewPassword"
									placeholder="">
							</div>

						</div>

					</div>
					<div class="modal-footer">

						<div class="col-md-2">
							<button type="submit" value= "Send" class="btn btn-info pull-left" id = "submit-reset">Submit</button>
						</div>


						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id ="reset_cancel" >Cancel</button>
						</div>



					</div>
			</div>
			</form>
		</div>

	</div>




<div class="modal fade" id="account" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id="accountForm">
					
		
		<div class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">

			<a href="#" class="navbar-brand"> My Account </a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">

					<li class="active"><a href="#"> Home </a></li>
					<li><a href="#rides" data-toggle="modal"> Rides </a></li>					
					<li><a href="#logout" data-toggle="modal" id="logout"><span class="glyphicon glyphicon-off"></span> Logout </a></li>

				</ul>

			</div>

		</div>

	</div> 
 
<div class="modal-body">
<div class="table-responsive">   
       <table data-toggle="table" id="table-rides"  >
         <thead>
           <tr>
             
           </tr>
         </thead>
         <tbody id = "tbodyRidesTable">
           
           
         </tbody>
       </table>
      </div>

</div>

						<div class="modal-footer">

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-myAccount" >Cancel</button>
						</div>
						
						<div class="col-md-2">						
							<button type="submit" value= "Send" class="btn btn-info pull-left " id = "submit">Change Password</button>
						</div>



					</div>
			</div>
			</form>
		</div>

	</div>

	<div class="modal fade" id="rides" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<h4>Venue Available Activities</h4>
					</div>

					<div class="modal-body">
						<div class="form-group">

							<label for="rides-name" class="col-lg-2 control-label">Rides:</label>
							<div class="row">
								<div class="col-md-6">
									<div class="input-group">
										<select class="form-control" id = "rides-name"  placeholder =" " name ="ride-list"> </select>

										
										
										<div class="input-group-btn ">
											<button type="button" class="btn btn-info pull-left " id="Select-Ride">Select
												Ride</button>
										</div>

										<div class="col-md-2">
											<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-addride">Cancel</button>
										</div>

									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
							</div>
							<!-- /div row -->

						</div>

					</div>
			</div>
			</form>
		</div>

	</div>
		
<div class="modal fade" id="admin" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id = "adminForm">
							 
					<div class="modal-header">
						<h4>Venue Park Admin Login Form</h4>
					</div>							
					
					<div class="error hide" id="idError">Invalid Credentials. Please, Try Again</div>
					


					<div class="modal-body">

						<div class="form-group">
							<label for="admin-username" class="col-lg-2 control-label">Username:</label>
							<div class="col-lg-10">
								<input name = "userName" type="email" class="form-control" id="admin-name"
									placeholder="user@example.com">
							</div>
						</div>

						<div class="form-group">
							<label for="admin-password" class="col-lg-2 control-label">Password:</label>
							<div class="col-lg-10">
								<input name = "password" type="password" class="form-control" id="admin-password"
									placeholder="" >
							</div>
						</div>

					</div>

					<div class="modal-footer">

						<div class="col-md-2">						
							<button type="submit" value= "Send" class="btn btn-info pull-left " id = "submit">Login</button>
						</div>

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-loginAdmin" >Cancel</button>
						</div>



					</div>
			</div>
			</form>
		</div>

	</div>



<div class="modal fade" id="search" role="dialog" data-backdrop="static" data-keyboard="false">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" id="adminForm">
				
							
				<div class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">

			<a href="#" class="navbar-brand"> Admin Search Form </a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">

					<li class="active"><a href="#"> Home </a></li>					
					<li><a href="#logout" data-toggle="modal" id="logout"><span class="glyphicon glyphicon-off"></span> Logout </a></li>

				</ul>

			</div>

		</div>

	</div>	
					
					<div class="modal-body">

						<div class="table-responsive">  
											
						        
       <table data-toggle="table" id="table-admin" data-show-refresh="true" data-search="true" data-height="299">
         <thead>
           <tr>
             <th>#</th>
             <th>Name</th>
             <th>User Name</th>             
             <th>Operate</th>
           </tr>
         </thead>
         <tbody id = "tbodyAdminTable">
           
           
         </tbody>
       </table>
      </div>

</div>

						<div class="modal-footer">

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-search" >Cancel</button>
						</div>
						



					</div>
			</div>
			</form>
		</div>

	</div>





<!--  
javascript section
-->
<script type="text/javascript">

$(document).ready(function() {
	
	$.getJSON('${pageContext.request.contextPath}/ride/rides', function(result) {
		
		var optionsValues = '<select class="form-control" id = "rides-name"  placeholder =" " name ="ride-list">';
	
		$.each($.parseJSON(JSON.stringify(result)), function(idx, item) {
	        	optionsValues += '<option value="' + item.rideId + '">' + item.rName + '</option>';
		});	
		 
	    	optionsValues += '</select>';
	    	var options = $('#rides-name');
	    	options.replaceWith(optionsValues);
	    
	}); 
	
	 $('#loginForm').submit(function(e) {
		// will pass the form date using the jQuery serialize function
		$.post('${pageContext.request.contextPath}/login/signin', 
		    $(this).serialize()).done(
			function(response,textStatus,jqXHR) { 
		    
				alert('valid credentials');  
				
		    $('#login').modal('hide');
		    
			CleanLoginForm();
			
			$('#account').modal('show'); 
		
			CleanLoginForm();
			
			if(response != 'undefined'){
				
			    $.cookie("user_info", response);  
			
			} 
			
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('invalid credentials');	
			  $('#login').modal('show');
			  CleanLoginForm();	
  }); 
		e.preventDefault(); // prevent actual form submit and page reload 
	}); 
	
	  /*
	  reset form ajax post function
	  validations and page forwarding.
	  */	
	
	  $('#resetPasswordForm').submit(function(e) {
		// will pass the form date using the jQuery serialize function
		$.post('${pageContext.request.contextPath}/user/resetPassword', $(this).serialize(), function(response) {
			$('#personFormResponse').text(response);
			 
			if(response ==true){
				 alert('Your Password have been successfully changed');
			
			$('#reset').modal('hide');
			CleanResetPasswordForm();
			$('#login').modal('show');
			}else {
				
			  alert('Something went wrong :(. Please, Try Again');	
			  $('#registerForm').modal('show');
			 
			  CleanResetPasswordForm(); 
								
			}
			CleanResetPasswordForm();
		}); 	
		e.preventDefault(); // prevent actual form submit and page reload	
		});
  
		/*
  register form ajax post function
  validations and page forwarding.
  */	
	$('#registerForm').submit(function(e) {
		// will pass the form date using the jQuery serialize function
		$.post('${pageContext.request.contextPath}/user/add', $(this).serialize(), function(response) {
			$('#personFormResponse').text(response); 
			
			if(response ==true){
				 alert('You have been successfully register');
			
			$('#register').modal('hide');
			CleanRegisterForm();
			$('#login').modal('show');
			}else {
				
			  alert('You were not registered :(. Please, Try Again');	
			  $('#registerForm').modal('show');
			  CleanRegisterForm();
			}
			CleanRegisterForm();
		}); 
		e.preventDefault(); // prevent actual form submit and page reload
		}); 
	});  

$('#forgotPasswordForward').on('click', function () {
	CleanLoginForm();
	$('#login').modal('hide'); 
		});
		
$('#reset_cancel').on('click', function () {
	CleanResetPasswordForm();
		});

$('#register_cancel').on('click', function(){
	CleanRegisterForm();
});

$('#cancel-Login').on('click', function(){
	CleanLoginForm();
});

$('#cancel-loginAdmin').on('click', function(){
	CleanLoginAdminForm();
});

$('#createAccountForward').on('click', function () {
	CleanLoginForm();
	$('#login').modal('hide'); 
		});
	
// $('#login-password').on('click', function () {
  // $(this).attr('type', 'password'); 
// });

$(document).ready(function(){
  $(":password");
});


$('#logout').on('click', function () {
	 var user=$.cookie("user_info");
	 
	
	var uName=$.parseJSON(user);
	var userN= String(uName.user_name);
	
	 $.post('${pageContext.request.contextPath}/login/signout', 
		    {userName:userN}).done(
			function(response,textStatus,jqXHR) { 
				alert('You were successfuly logged out');
		    
			$('#account').modal('hide'); 
			    $.removeCookie("user_info");
			    location.reload();
			 
			
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to logout !!!!');	
  });  
	
	});
	
	
$('#Select-Ride').on('click', function () {
	var user=$.cookie("user_info");
	
	 
	if(typeof user ==='undefined'){
		alert("!!!Please, login first.")
		$('#rides').modal('hide');
		//CleanRegisterForm();
		$('#login').modal('show');
		return;
	}
	
	var uName=$.parseJSON(user); 
	var userN= String(uName.user_id);
	//alert(userN);
	var userId=String(uName.user_id);
	
	var rid=$("#rides-name").val(); 
	 
	var rideId=$("#rides-name").val();
	 
	$.post('${pageContext.request.contextPath}/ride/addUser', 
			{ "userid": userId, "rideid" : rid }).done(
			function(response,textStatus,jqXHR) { 
				if(response == false){
					
					alert('Sorry, you are unable to add ride !!!!');	
					return;
					
				}
				alert('You  successfuly Added this ride'); 
			
				$('#rides').modal('hide'); 
				//populateAccountTable();
				$('#account').modal('show');  
			    
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to add ride !!!!');	
      });  
}); 
	

function CleanLoginForm() {
$('#login-name').val('') ; 
$('#login-password').val('') ; 
$('#login-code').val('') ; 
};

function CleanLoginAdminForm(){
	$('#admin-name').val('') ; 
	$('#admin-password').val('') ;
};

function CleanRegisterForm() {
$('#register-name').val('') ;
$('#register-lastName').val('') ; 
$('#register-password').val('') ; 
$('#register-email').val('') ; 
$('#register-secQuestion').val('') ; 
$('#register-secAnswer').val('') ; 
$('#register-cell').val('') ; 
$('#register-age').val('') ; 
};

function CleanResetPasswordForm() {
	
	$('#reset-usernameReset').val('') ; 
	$('#reset-secQuestionReset').val('') ; 
	$('#reset-secAnswerReset').val('') ; 
	$('#reset-newPasswordReset').val('') ; 
	$('#reset-confirmNewPassword').val('') ;
	};

	
$('#registerForm').bootstrapValidator({
	message: 'This value is not valid',
	fields: {
		firstName: {
			message: 'The name is not valid',
			validators: {
			notEmpty: {
			message: 'The name field is required and cannot be empty'
			},
			regexp: {
			regexp: /^[a-z\s]+$/i,
			message: 'The name can consist of alphabetical characters and spaces onlys'
			},
			}
			},
			
		lastName: {
			message: 'The last name is not valid',
			validators: {
			notEmpty: {
			message: 'The last is required and cannot be empty'				},
			regexp: {
			regexp: /^[a-z\s]+$/i,
			message: 'Last name can consist of alphabetical characters and spaces only'
			},
			}
			},
				
		password: {
			validators: {
			notEmpty: {
			message: 'The password is required and cannot be empty'
			},			
			}
			},			
	
		email: {
			validators: {
			notEmpty: {
			message: 'The email address is required and cannot be empty'
			},
			emailAddress: {
			message: 'The input is not a valid email address'
			}
			}
			},			

		securityAnswer: {
			validators: {
			notEmpty: {
			message: 'The security Answer is required and cannot be empty'
			},
			}
			},
	
		phoneNumber: {
			
			message: 'The phone number is not valid',
			validators: {
			notEmpty: {
			message: 'The phone number is required and cannot be empty'
			},
			regexp: {
			regexp: /^[0-9]{10}$/,
			message: 'The phone number can only consists of 10 digits: Ex:3056757845'
				},
			
			}
			},	
			
		age: {
			message: 'The age is not valid',
			validators: {
			notEmpty: {
			message: 'The age is required and cannot be empty'
			},
			regexp: {
			regexp: /^[0-9]{1}[0-9]{1}$/,
			message: 'The age can only consists of numbers'
			},
			}
			},
				
	}
	});

	
	$('#loginForm').bootstrapValidator({
		message: 'This value is not valid',
		fields: {
			
			userName: {
				validators: {
				notEmpty: {
				message: 'The email address is required and cannot be empty'
				},
				emailAddress: {
				message: 'The input is not a valid email address'
				}
				}
				},
				
			password: {
				validators: {
				notEmpty: {
				message: 'The password is required and cannot be empty'
				},			
				}
				},									
		
			code: {
				
				message: 'The code is not valid',
				validators: {
				regexp: {
				regexp:  /^[a-zA-Z0-9]+$/,
				message: 'The code consists of numbers and/or letters only: Ex:1AB2'
					},
				
				}
				},					
					
		}
		});

	
	$('#adminForm').bootstrapValidator({
		message: 'This value is not valid',
		fields: {
			
			userName: {
				validators: {
				notEmpty: {
				message: 'The email address is required and cannot be empty'
				},
				emailAddress: {
				message: 'The input is not a valid email address'
				}
				}
				},
				
			password: {
				validators: {
				notEmpty: {
				message: 'The password is required and cannot be empty'
				},			
				}
				},									
												
		}
		});

/*
function populateAccountTable(){
	
	var user=$.cookie("user_info");
	//alert(user);
	 
	if(typeof user ==='undefined'){
		alert("!!!you need to login first.....")
		//$('#rides').modal('hide');
		//CleanRegisterForm();
		$('#login').modal('show');
		return;
	}
	
	var uName=$.parseJSON(user); 
	var userID= String(uName.user_id);
	//alert(userN);
	var userId=String(uName.user_id);
	$.post('${pageContext.request.contextPath}/ride/user/rides', {
		userid:userID
	  }, function(result) {
		  
		alert(JSON.stringify(result));
		$.each($.parseJSON(JSON.stringify(result)), function(idx, elem){
			$('table#table-rides TBODY').append('<tr><td>'+ idx +'</td><td>'+elem.rName+'</td><td>'+elem.interval +'</td><td class= ' + 'deleteThisrow'+ ' ><i class="glyphicon glyphicon-remove"></i></td></tr>');
			});
	}); 
	
};
*/

//new changes from here
//$(document).on('click', '.deleteThisrow', function() (in case the i cant delete last row added)



function operateFormatter(value, row, index) {
    return [
        '<a class="like" href="javascript:void(0)" title="Like">',
            '<i class="glyphicon glyphicon-heart"></i>',
        '</a>',
        '<a class="edit" href="javascript:void(0)" title="Edit">',
            '<i class="glyphicon glyphicon-edit"></i>',
        '</a>',
        '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
};


function deleteRideFromDB (ride_id) {

	var user=$.cookie("user_info");
	
	var uName=$.parseJSON(user); 
	var userID=String(uName.user_id);
	var data= JSON.stringify({ "userid": userID, "rideId" : 1 })

	/* 
	 $.post('${pageContext.request.contextPath}/ride/removeRideByUser', { "userid": 1, "rideId" : 1 }).done(
			function(response,textStatus,jqXHR) { 
				alert('Ride Removed');		
			 
			
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to remove ride !!!!');	
 }); 	
*/
jQuery.ajax(

		{

		url : '${pageContext.request.contextPath}/ride/removeRideByUser',

		type: 'POST',

		dataType : "json",

		data:{ "userid": 1, "rideId" : 1 },

		success:function(data) { alert(data); },

		error: function() {alert(data); }

		}

		);
};


window.operateEvents = {
        'click .like': function (e, value, row, index) {
            alert('You click like icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .edit': function (e, value, row, index) {
            alert('You click edit icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .remove': function (e, value, row, index) {
        	 alert('You click remove icon, row: ' + JSON.stringify(row));
        	 deleteRideFromDB();
             
        
       }
    }; 
   
/* 
$(document).on('click', '.deleterow', function(){	
	var $eraserow = $(this).parent('tr');
	    $eraserow.addClass("danger");
		$eraserow.fadeOut(100, function(){
	    $(this).remove();
	});});	
*/


$('#table-rides').bootstrapTable({
    method: 'get',
    url: '${pageContext.request.contextPath}/ride/user/rides/1',
    cache: false,
    height: 400,
    striped: true,
    pagination: true,
    pageSize: 50,
    pageList: [10, 25, 50, 100, 200],
    search: true,
    showToggle: true,
    showColumns: true,
    showRefresh: true,
    minimumCountColumns: 2,
    clickToSelect: true,

    columns: [{
        field: 'rName',
        title: 'Ride Name',
        align: 'right',
        valign: 'bottom',
        //sortable: true
    }, {
        field: 'interval',
        title: 'Waiting Time',
        class: 'deleterow',
        align: 'center',
        valign: 'middle'
        //sortable: true
        //,formatter: nameFormatter
    }, {
        field: 'price',
        title: 'Item Price',
        class: 'deleterow'
        //align: 'left',
        //valign: 'top',
        //sortable: true,
       // ,formatter: priceFormatter,
        //sorter: priceSorter
    }, {
        field: 'remove',
        title: 'Item Operate',
        align: 'center',
        valign: 'middle',
        class: 'deleterow',
       clickToSelect: false,
       formatter: operateFormatter,
       events: operateEvents
    }]
});




/*

$('#logout').on('click', function () {
	 var user=$.cookie("user_info");
	 
	
	var uName=$.parseJSON(user);
	var userN= String(uName.user_name);
	
	 $.post('${pageContext.request.contextPath}/login/signout', 
		    {userName:userN}).done(
			function(response,textStatus,jqXHR) { 
				alert('You were successfuly logged out');
		    
			$('#account').modal('hide'); 
			    $.removeCookie("user_info");
			    location.reload();
			 
			
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to logout !!!!');	
 });  
	
	});
	
*/





</script>



</body>
</html>
