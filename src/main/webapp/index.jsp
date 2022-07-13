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
<title>Shop Coin - Index Page</title>
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
								</ul>

							</div>
						</div>
					</div>
				</div>
				<!--breadcrumbs area end-->

				<!--shopping cart area start -->
				<div class="shopping_cart_area">
					<form action="#">
						<div class="row">
							<div class="col-12">
								<div class="table_desc wishlist">
									<div class="cart_page table-responsive">
										<table>
											<thead>
												<tr>
													
													<th class="product_name">Coin</th>
													<th class="product-price">Price</th>
													<th class="product_total">Add To Cart</th>
												</tr>
											</thead>
											<tbody>
											<%
												getCoinInfor setupCoin = new getCoinInfor();
												setupCoin.getCoin();
												CoinDAO daoCoin = new CoinDAO();
												List<Coin> listCoin = daoCoin.getAllCoin();
												request.setAttribute("listCoin", listCoin);
												if(!listCoin.isEmpty()){
													for(Coin c:listCoin){ %>
														<tr>
															
															<td class="product_name"><a href="#"><%= c.getCoinName() %></a></td>
															<td class="product-price">$<%= c.getPrice() %></td>
															<td class="product_total"><a href="BuyCoin?CoinID=<%= c.getCoinID()%>">Buy Now</a></td>
														</tr>
												<%	}
												}
											%>
												
											</tbody>
										</table>
									</div>

								</div>
							</div>
						</div>

					</form>
					<div class="row">
						<div class="col-12">
							<div class="wishlist-share">
								<h4>Share on:</h4>
								<ul>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
									<li><a href="#"><i class="fa fa-vimeo"></i></a></li>
									<li><a href="#"><i class="fa fa-tumblr"></i></a></li>
									<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								</ul>
							</div>
						</div>
					</div>

				</div>
				<!--shopping cart area end -->

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
