<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Coron-login</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets\img\favicon.png">

<!-- all css here -->
<link rel="stylesheet" href="assets\css\bootstrap.min.css">
<link rel="stylesheet" href="assets\css\plugin.css">
<link rel="stylesheet" href="assets\css\bundle.css">
<link rel="stylesheet" href="assets\css\style.css">
<link rel="stylesheet" href="assets\css\responsive.css">
<script src="assets\js\vendor\modernizr-2.8.3.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
	<!-- Add your site or application content here -->

	<!--pos page start-->
	<div class="pos_page">
		<div class="container">
			<!--pos page inner-->
			<div class="pos_page_inner">
				<!--header area -->
				<div class="header_area">

					<%@include file="./layouts/header.jsp"%>

					<!--breadcrumbs area start-->
					<div class="breadcrumbs_area">
						<div class="row">
							<div class="col-12">
								<div class="breadcrumb_content">
									<ul>
										<li><a href="index.html">home</a></li>
										<li><i class="fa fa-angle-right"></i></li>
										<li>login</li>
									</ul>

								</div>
							</div>
						</div>
					</div>
					<!--breadcrumbs area end-->

					<!-- customer login start -->
					<div class="customer_login">
						<div class="row">
							<!--login area start-->
							<div class="col-lg-6 col-md-6">
								<div class="account_form">
									<h2>Recover Password</h2>
									<form action="ForgotServlet" id="forgot" method="POST">
										<p>
											<label>Username <span>*</span></label> <input
												type="text" name="userName">
										</p>
										<p>
											<label>Email <span>*</span></label> <input
												type="text" name="email">
										</p>
										<div class="g-recaptcha" data-sitekey="6LdfjcwgAAAAAM9iAtcvFmbKryl3XnTvt7kbamIA"></div>
										<p id="error" style="color:red"></p>
										<%
											String checking = (String) session.getAttribute("checking");
											String smg = (String) session.getAttribute("smg");
											if("error".equals(checking)){ %>
												<p style="color:red"><%= smg %></p>
										<%	}
										%>
										<div class="login_submit">
											<button type="submit">Confirm</button>
											</label> <a href="login.jsp">Click here to login</a>				
										</div>
									</form>
									
									<script>
                                            window.onload = function(){
                                                let isValid = false;
                                                const form = document.getElementById("forgot");
                                                const error = document.getElementById("error");
                                                form.addEventListener("submit",function(event){
                                                    event.preventDefault();
                                                    const response = grecaptcha.getResponse();
                                                    if(response){
                                                        form.submit();
                                                    }else{
                                                        error.innerHTML = 'Please, check Recaptcha';
                                                    }
                                                });
                                            }
                                        </script>
								</div>
							</div>
							<!--login area start-->

							

							
					</div>
				</div>
				<!-- customer login end -->

			</div>
			<!--pos page inner end-->
		</div>
	</div>
	<!--pos page end-->


	<%@include file="./layouts/footer.jsp"%>




	<!-- all js here -->
	<script src="assets\js\vendor\jquery-1.12.0.min.js"></script>
	<script src="assets\js\popper.js"></script>
	<script src="assets\js\bootstrap.min.js"></script>
	<script src="assets\js\ajax-mail.js"></script>
	<script src="assets\js\plugins.js"></script>
	<script src="assets\js\main.js"></script>
</body>
</html>
