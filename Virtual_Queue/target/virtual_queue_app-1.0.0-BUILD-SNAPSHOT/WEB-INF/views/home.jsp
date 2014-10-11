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
<script type="text/javascript"src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script type="text/javascript"src="<c:url value="/resources/js/virtualQ.js" />"></script>



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

				<div class=panelpanel-default">

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



	<div class="modal fade" id="login" role="dialog">

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
							<li><a href=" ">Forgot Password</a></li>
						</div>

						<div class="col-md-4">
							<li><a href="#">Create Account</a></li>
						</div>


					</div>
			</div>
			</form>
		</div>

	</div> 
	<div class="modal fade" id="offers" role="dialog"> 
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
							<button type="button" class="btn btn-md btn-info pull-left ">Cancel</button>
						</div> 
					</div>
			</div>
			</form>
		</div> 
	</div> 

	<div class="modal fade" id="register" role="dialog">

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

					</div>
					<div class="modal-footer">

						<div class="col-md-2">
							<button type="submit" value= "Send" class="btn btn-info pull-left" id = "submit">Submit</button>
						</div>


						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left " data-dismiss = "modal" id = "cancel" onclick= "CleanRegisterForm()">Cancel</button>
						</div>

					<div id="personFormResponse" class="green"> </div>

					</div>
			</div>
			</form>
		
		</div>

	</div>

	<div class="modal fade" id="reset" role="dialog">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<h4>Reset Password Form</h4>
					</div>

					<div class="modal-body">


						<div class="form-group">

							<label for="reset-username" class="col-lg-2 control-label">Username:</label>
							<div class="col-lg-10">
								<input type="email" class="form-control" id="reset-username"
									placeholder="user@example.com">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-secQuestion" class="col-lg-2 control-label">Security
								Question:</label>
							<div class="col-lg-10">
								<select class="form-control id = "
									reset-secQuestion" placeholder="">

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
								<input type="text" class="form-control" id="reset-secAnswer"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-password" class="col-lg-2 control-label">New
								Password:</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="reset-password"
									placeholder="">
							</div>

						</div>

						<div class="form-group">

							<label for="reset-password" class="col-lg-2 control-label">Confirm
								Password:</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="reset-password"
									placeholder="">
							</div>

						</div>

					</div>
					<div class="modal-footer">

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left ">Submit</button>
						</div>

						<div class="col-md-2">
							<button type="button" class="btn btn-info pull-left ">Cancel</button>
						</div>



					</div>
			</div>
			</form>
		</div>

	</div>




<div class="modal fade" id="account" role="dialog">

		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<h4>My Account Page</h4>
					</div>

					<div class="modal-body">





						<table id="events-id2" data-url="data1.json" data-height="299"
							data-search="true">
							<thead>
								<tr>
									<th data-field="state" data-checkbox="true"></th>
									<th data-field="id" data-sortable="true">Item ID</th>
									<th data-field="name" data-sortable="true">Item Name</th>
									<th data-field="price" data-sortable="true">Item Price</th>
									<th data-field="operate" data-formatter="operateFormatter"
										data-events="operateEvents">Item Operate</th>
								</tr>
							</thead>
						</table>

</div>
			</div>
			</form>
		</div>

	</div>










	<div class="modal fade" id="rides" role="dialog">

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
										<select class="form-control id = " rides-name" placeholder="">

											<option value="one">Ride One</option>
											<option value="two">Ride Two</option>
											<option value="three">Ride Three</option>
											<option value="four">Ride Four</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
											<option value="five">Ride Five</option>
										</select>

										<div class="input-group-btn ">
											<button type="button" class="btn btn-info pull-left ">Select
												Ride</button>
										</div>

										<div class="col-md-2">
											<button type="button" class="btn btn-info pull-left ">Cancel</button>
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


</body>
</html>
