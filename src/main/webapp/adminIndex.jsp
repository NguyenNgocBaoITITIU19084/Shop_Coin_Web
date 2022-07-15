<%@page import="Context.*"%>
<%@page import="Controller.*"%>
<%@page import="DAO.*"%>
<%@page import="Entity.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if (session.getAttribute("AdminController") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shop Coin - Admin Controller Page</title>
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
</head>
<body>
	<!-- Add your site or application content here -->

	<!--pos page start-->
	<div class="pos_page">
		<div class="container">
			<!--pos page inner-->
			<div class="pos_page_inner">

				<%@include file="./layouts/header.jsp"%>


				<!--pos home section-->
				<div class="pos_home_section">
					<div class="row">
						<!--banner slider start-->
						<div class="col-12">
							<div class="banner_slider slider_two">
								<div class="slider_active owl-carousel">
									<div class="single_slider"
										style="background-image: url(assets/img/slider/slider_2.png)">
										<div class="slider_content">
											<div class="slider_content_inner">
												<h1>Wellcome to Admin Home Page</h1>
												<p>
													Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br>
													Cumque eligendi quia, ratione porro, nemo non.
												</p>

											</div>
										</div>
									</div>
									<div class="single_slider"
										style="background-image: url(assets/img/slider/slide_4.png)">
										<div class="slider_content">
											<div class="slider_content_inner">
												<h1>Clothing fashion for you</h1>
												<p>
													Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br>
													Cumque eligendi quia, ratione porro, nemo non.
												</p>

											</div>
										</div>
									</div>
									<div class="single_slider"
										style="background-image: url(assets/img/slider/slider_3.png)">
										<div class="slider_content">
											<div class="slider_content_inner">
												<h1>fashion for you</h1>
												<p>
													Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br>
													Cumque eligendi quia, ratione porro, nemo non.
												</p>

											</div>
										</div>
									</div>
								</div>
							</div>
							<!--banner slider start-->
						</div>
					</div>





					<!-- customer login start -->
					<div class="customer_login">
						<div class="row">
							

							<!--register area start-->
							<div class="col-lg-6 col-md-6">
								<div class="account_form register">
									<h2>Insert New Bank</h2>
									<form action="InsertBank" method="POST">
										<p>
											<label>New Bank Name <span>*</span></label> <input
												type="text" name="bank">
										</p>
										<%
											String checkingIBank = (String) session.getAttribute("checkingIBank");
											String smgIB = (String) session.getAttribute("smgIBank");
											if("errorBank".equals(checkingIBank)){ %>
												<p style="color:red;"><%= smgIB %></p>	
										<%	}
										%>
										<div class="login_submit">
											<button type="submit">Insert</button>
										</div>
									</form>
									<form action="DeleteBank" method="POST">
										<p>
											<label>Select Bank Name to Delete <span>*</span></label> 
											<select name="bankID">
												<%
													BankDAO daoBank = new BankDAO();
													List<Bank> listBank = daoBank.getAllBank();
													if(!listBank.isEmpty()){
														for(Bank b:listBank){ %>
															<option value="<%= b.getBankID() %>"><%= b.getBankName() %></option>
													<%	}
													}
												%>
													
											</select>
										</p>
										<%
											String checkingDBank = (String) session.getAttribute("checkingDBank");
											String smgDB = (String) session.getAttribute("smgDBank");
											if("errorBank".equals(checkingDBank)){ %>
												<p style="color:red;"><%= smgDB %></p>	
										<%	}
										%>
										<div class="login_submit">
											<button type="submit">Delete</button>
										</div>
									</form>
								</div>
								
								
								<div class="account_form register">
									<h2>Insert New Admin's Bank</h2>
									<form action="InsertAdminBank" method="POST">
										<p>
											<label>New Admin's Name: <span></span></label> <input
												type="text" name="adminName">
										</p>
										<label>Select Bank Name: <span></span></label> 
											<select name="bankID">
												<%
													if(!listBank.isEmpty()){
														for(Bank b:listBank){ %>
															<option value="<%= b.getBankID() %>"><%= b.getBankName() %></option>
													<%	}
													}
												%>
												</select>
										<%
											String checkingABank = (String) session.getAttribute("checkingABank");
											String smgABank = (String) session.getAttribute("smgABank");
											if("error".equals(checkingABank)){ %>
												<p style="color:red;"><%= smgABank %></p>	
										<%	}
										%>
										
										<div class="login_submit">
											<button type="submit">Insert</button>
										</div>
									</form>

									
								</div>
								
							</div>
							<!--register area end-->
						</div>
						<!--register area end-->
					</div>



				</div>
				<!--pos home section end-->
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
