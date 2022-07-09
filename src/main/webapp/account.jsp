<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Context.*"%>
<%@page import="DAO.*"%>
<%@page import="Controller.*"%>
<%@page import="Entity.*"%>
<%
if (session.getAttribute("AccountName") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Coron-my account</title>
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


				<!--breadcrumbs area start-->
				<div class="breadcrumbs_area">
					<div class="row">
						<div class="col-12">
							<div class="breadcrumb_content">
								<ul>
									<li><a href="index.jsp">home</a></li>
									<li><i class="fa fa-angle-right"></i></li>
									<li>my account</li>
								</ul>

							</div>
						</div>
					</div>
				</div>
				<!--breadcrumbs area end-->

				<!-- Start Maincontent  -->
				<section class="main_content_area">
					<div class="account_dashboard">
						<div class="row">
							<div class="col-sm-12 col-md-3 col-lg-3">
								<!-- Nav tabs -->
								<div class="dashboard_tab_button">
									<ul role="tablist" class="nav flex-column dashboard-list">
										<li><a href="#dashboard" data-toggle="tab"
											class="nav-link active">Dashboard</a></li>
										<li><a href="#orders" data-toggle="tab" class="nav-link">Orders</a></li>
										<li><a href="#downloads" data-toggle="tab"
											class="nav-link">Downloads</a></li>
										<li><a href="#address" data-toggle="tab" class="nav-link">Account
												Detail</a></li>
										<li><a href="#account-details" data-toggle="tab"
											class="nav-link">Payment Infor</a></li>
										<li><a href="LogoutServlet" class="nav-link">logout</a></li>
									</ul>
								</div>
							</div>
							<div class="col-sm-12 col-md-9 col-lg-9">
								<!-- Tab panes -->
								<div class="tab-content dashboard_content">
									<div class="tab-pane fade show active" id="dashboard">
										<h3>Dashboard</h3>
										<p>
											From your account dashboard. you can easily check &amp; view
											your <a href="#">recent orders</a>, manage your <a href="#">shipping
												and billing addresses</a> and <a href="#">Edit your password
												and account details.</a>
										</p>
									</div>
									<div class="tab-pane fade" id="orders">
										<h3>Orders</h3>
										<div class="coron_table table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th>Order</th>
														<th>Date</th>
														<th>Status</th>
														<th>Total</th>
														<th>Actions</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>1</td>
														<td>May 10, 2018</td>
														<td><span class="success">Completed</span></td>
														<td>$25.00 for 1 item</td>
														<td><a href="cart.html" class="view">view</a></td>
													</tr>
													<tr>
														<td>2</td>
														<td>May 10, 2018</td>
														<td>Processing</td>
														<td>$17.00 for 1 item</td>
														<td><a href="cart.html" class="view">view</a></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane fade" id="downloads">
										<h3>Downloads</h3>
										<div class="coron_table table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th>Product</th>
														<th>Downloads</th>
														<th>Expires</th>
														<th>Download</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Shopnovilla - Free Real Estate PSD Template</td>
														<td>May 10, 2018</td>
														<td><span class="danger">Expired</span></td>
														<td><a href="#" class="view">Click Here To
																Download Your File</a></td>
													</tr>
													<tr>
														<td>Organic - ecommerce html template</td>
														<td>Sep 11, 2018</td>
														<td>Never</td>
														<td><a href="#" class="view">Click Here To
																Download Your File</a></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane" id="address">
										<%
										String email = (String) session.getAttribute("AccountName");
										AccountDetailDAO detailDAO = new AccountDetailDAO();
										AccountDetail detail = detailDAO.getDetailByEmail(email);
										%>
										<h4 class="billing-address">Account Detail</h4>
										<p>
											<b>Name: </b><%=detail.getUserName()%></p>
										<p>
											<b>Account: </b><%=detail.getAccountName()%></p>
										<p>
											<b>Balance: </b> $<%=detail.getBalance()%>USDT
										</p>
									</div>
									<div class="tab-pane fade" id="account-details">
										<h3>Payment Infor</h3>
										<div class="login">
											<div class="login_form_container">
												<div class="account_login_form">
													<form action="#" method="POST" >
														<label style="color:red">Account Name: <%= detail.getAccountName() %></label><br>
														<label>Bank Name</label> 
														<select name="bankID">
														<%
															BankDAO daoBank = new BankDAO();
															List<Bank> listBank = daoBank.getAllBank();
															if(!listBank.isEmpty()){
																for(Bank b:listBank){ %>
																	<option value="<%= b.getBankID() %>"><%= b.getBankName() %></option>
														<%		}
															}
														%>
														</select>
														<br>
														<label>Account Number</label> 
														<input type="text" name="email-name">
														<div class="login_submit">
															<button type="submit">Update</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- End Maincontent  -->
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
