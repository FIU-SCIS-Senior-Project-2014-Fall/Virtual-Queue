<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Virtual Queue</title>



<link href="<c:url value="/resources/css/bootstrap.min.css" /> "rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" /> "rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/styles.css" />"rel="stylesheet" type="text/css" />


<script type="text/javascript"src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
					<li><a href="#offers" data-toggle="modal"> Special Offers
					</a></li>
					<li><a href="#reset" data-toggle="modal"> Contact Us </a></li>
					<li><a href="#account" data-toggle="modal"> MyAccount </a></li>

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
				<p>This ride will make you feel like you are living in a world
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
								<input name = "password" type="text" class="form-control" id="login-password"
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
	<div class="modal fade" id="offers" role="dialog" data-backdrop="static" data-keyboard="false"> 
		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<h4>Venue Add Activities</h4>
					</div>

					<div class="modal-body">
						<div class="form-group">

							<label for="register-secQuestion" class="col-lg-2 control-label">Choose
								Time of Activity: </label>
							<div class="col-lg-10">
								<select class="form-control id = "
									register-secQuestion" placeholder="">

									<option value="one">2:30</option>
									<option value="two">3:00</option>
									<option value="three">3:30</option>
									<option value="four">4:00</option>
									<option value="five">4:30</option>
								</select>
							</div>

						</div>
						<!-- /form-group -->

						<div class="form-group">

							<label for="reset-secQuestion" class="col-lg-2 control-label">Choose
								Time of Notification:</label>
							<div class="col-lg-10">
								<select class="form-control id = "
									reset-secQuestion" placeholder="">

									<option value="one">10</option>
									<option value="two">20</option>
									<option value="three">30</option>
									<option value="four">40</option>
									<option value="five">50</option>
								</select>
							</div>

						</div>
						<!-- /form-group -->

					</div>
					<!-- /modal-content -->

					<div class="modal-footer">
						<div class="col-md-2">
							<button type="button" class="btn btn-md btn-info pull-right ">Add</button>
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-md btn-info pull-left " >Cancel</button>
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
								<input name= "password" type="text" class="form-control" id="register-password"
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









						<div class="form-group">

							<label for="register-height" class="col-xs-2 control-label">Height:</label>
							<div class="col-xs-5">
								<div class="input-group number-spinner">
									<span class="input-group-btn">
										<button class="btn btn-default" data-dir="dwn" id="register-minus1">
											<span class="glyphicon glyphicon-minus" ></span>
										</button>
									</span> 
									<input name="height" type="text" class="form-control" value="1" id="register-height1"> <span
										class="input-group-btn">
										<button class="btn btn-default" data-dir="up" id="register-plus1">
											<span class="glyphicon glyphicon-plus" ></span>
										</button>
									</span>
								</div>
							</div>


							<div class="col-xs-5">
								<div class="input-group number-spinner">
									<span class="input-group-btn">
										<button class="btn btn-default" data-dir="dwn" id="register-minus2">
											<span class="glyphicon glyphicon-minus" ></span>
										</button>
									</span> <input name="height1" type="text"
										class="form-control text-left" value="2" id="register-height2">
									<span class="input-group-btn">
										<button class="btn btn-default" data-dir="up" id="register-plus2">
											<span class="glyphicon glyphicon-plus" ></span>
										</button>
									</span>
								</div>
							</div>


						</div>




						<div class="form-group">

							<label for="register-weight" class="col-xs-2 control-label">Weight:</label>

							<div class="col-xs-5">
								<div class="input-group number-spinner">
									<span class="input-group-btn">
										<button class="btn btn-default" data-dir="dwn" id= "register-weightMinus">
											<span class="glyphicon glyphicon-minus" id="register-weight"></span>
										</button>
									</span> <input name="weight" type="text"
										class="form-control text-left" value="2" id="register-weight">
									<span class="input-group-btn">
										<button class="btn btn-default" data-dir="up" id= "register-weightPlus">
											<span class="glyphicon glyphicon-plus" ></span>
										</button>
									</span>
								</div>
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
										data-dismiss="modal" id="cancel" >Cancel</button>
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
								<input name = "newPassword" type="text" class="form-control" id="reset-newPasswordReset"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-password" class="col-lg-2 control-label">Confirm
								Password:</label>
							<div class="col-lg-10">
								<input name= "confirmNewPassword" type="text" class="form-control" id="reset-confirmNewPassword"
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
				<form class="form-horizontal">
					
					<!--  
					<div class="modal-header">
						<h4>My Account Page</h4>
					</div>
					-->
					
		
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
       <table class="table table-striped table-bordered">
         <thead>
           <tr>
             <th>#</th>
             <th>Ride</th>
             <th>Time of Ride</th>
             <th>Operate</th>
           </tr>
         </thead>
         <tbody>
           <tr>
             <td>1</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i> </td>
           </tr>
           <tr>
             <td>2</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i> </td>
           </tr>
           <tr>
             <td>3</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i> </td>
           </tr>
           <tr>
             <td>4</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i> </td>
           </tr>
           <tr>
             <td>5</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i> </td>
           </tr>
           <tr>
             <td>6</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i>  </td>
           </tr>
           <tr>
             <td>7</td>
             <td></td>
             <td></td>
             <td><i class="glyphicon glyphicon-remove"></i></td>
           </tr>
           
         </tbody>
       </table>
      </div>

</div>

						<div class="modal-footer">

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel-Login" >Cancel</button>
						</div>
						
						<div class="col-md-2">						
							<button type="submit" value= "Send" class="btn btn-info pull-left " id = "submit">Forgot Password</button>
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
										<select class="form-control" id = "rides-name"  placeholder =" "> 
										</select>

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
		
</div>


<!--  
TODO:Add comments here.
javascript section
-->
<script type="text/javascript">

$(document).ready(function() {
	
	$.getJSON('${pageContext.request.contextPath}/ride/rides', function(result) {
		var optionsValues = '<select>';
	
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
	$('#reset-password').on('click', function () {
		   $(this).attr('type','password'); 
		}); 
$('#forgotPasswordForward').on('click', function () {
	CleanLoginForm();
	$('#login').modal('hide'); 
		});
		
$('#reset_cancel').on('click', function () {
	CleanResetPasswordForm();
		});


$('#createAccountForward').on('click', function () {
	CleanLoginForm();
	$('#login').modal('hide'); 
		});
	
$('#login-password').on('click', function () {
   $(this).attr('type', 'password'); 
});


$('#reset-newPasswordReset').on('click', function () {
	   $(this).attr('type', 'password'); 
	});

$('#reset-confirmNewPassword').on('click', function () {
	   $(this).attr('type', 'password'); 
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
	 //var user=$.cookie("user_info");
	
	//var uName=$.parseJSON(user);
//	var userN= String(uName.user_id);
	var userId=5;
	var rideId=1;
	var data =JSON.stringify({ "userid": userId, "rideid" : rideId });
	 
	alert(data);
	$.post('${pageContext.request.contextPath}/ride/addUser', 
			{ "userid": 1, "rideid" : 3 }).done(
			function(response,textStatus,jqXHR) { 
				alert('You  successfuly Added this ride'); 
			//$('#account').modal('hide');  
			   // location.reload();  
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to add ride !!!!');	
      });  
}); 
	
$('#logout').on('change', function () {
	
	var user=$.cookie("user_info"); 
	var uName=$.parseJSON(user);
	var userN= String(uName.user_name);
	
	 $.post('${pageContext.request.contextPath}/ride/rides', 
		    {userName:userN}).done(
		    		
			function(response,textStatus,jqXHR) { 
			
				alert('loading rides!!!!');
			
				$('#account').modal('hide'); 
			    $.removeCookie("user_info");
			    location.reload(); 
			}).fail(function(jqXHR, textStatus, errorThrown) 
				    {
			  alert('unable to load rides'); 
 });  
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
$('#register-age').val('') ;
$('#register-height').val('') ;
$('#register-weight').val('') ; 
}

function CleanResetPasswordForm() {
	
	$('#reset-usernameReset').val('') ; 
	$('#reset-secQuestionReset').val('') ; 
	$('#reset-secAnswerReset').val('') ; 
	$('#reset-newPasswordReset').val('') ; 
	$('#reset-confirmNewPassword').val('') ;
	}

$('#register-plus1').on('click', '.number-spinner button', function () {    
	var btn = $(this),
		oldValue = btn.closest('.number-spinner').find('input').val().trim(),
		newVal = 0;
	
	if (btn.attr('data-dir') == 'up') {
		newVal = parseInt(oldValue) + 1;
	} else {
		if (oldValue > 1) {
			newVal = parseInt(oldValue) - 1;
		} else {
			newVal = 1;
		}
	}
	btn.closest('.number-spinner').find('input').val(newVal);
});
 



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
			
		height: {
			message: 'The height is not valid',
			validators: {
			notEmpty: {
			message: 'The height is required and cannot be empty'
			},
			regexp: {
			regexp: /^[0-9]/,
			message: 'The height can only consists of numbers'
			},
			}
			},
			
		weight: {
			message: 'The weight is not valid',
			validators: {
			notEmpty: {
			message: 'The weight is required and cannot be empty'
			},
			regexp: {
			regexp: /^[0-9]$/,
			message: 'The weight can only consists of numbers'
			},
			}
			},
				
	}
	});








</script>



</body>
</html>
