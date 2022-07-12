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
        <title>Shop Coin - Cart Page</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets\img\favicon.png">
		
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
                                                <li>cart page</li>
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
                                        <%
                                        	String id = (String) request.getAttribute("CoinID");
                                        	int coinID = Integer.parseInt(id);
                                        	CoinDAO daoCoin = new CoinDAO();
                                        	Coin coinInfor = daoCoin.getInforCoinByID(coinID);
                                        %>
                                            <div class="account_form">
                                                <h2>Buy Coin </h2>
                                                <form action="ConfirmBuyCoin" method="POST">
                                                	<p> 
                                                    <b>Coin ID: </b><%= coinInfor.getCoinID() %>
                                                    <input name="coinID" value="<%= coinInfor.getCoinID() %>" type="hidden">
                                                     </p>
                                                    <p> 
                                                    <input  name="coinName" value="<%= coinInfor.getCoinName() %>" type="hidden">
                                                    <b>Coin Name: </b><%= coinInfor.getCoinName() %>
                                                     </p>
                                                     <p >   
                                                     	<input name="price" value="<%= coinInfor.getPrice() %>" type="hidden">
                                                        <b>Price: </b><%= coinInfor.getPrice() %>
                                                     </p>  
                                                     <input type="number" id="quantity" name="quantity" min="1"><br>	
                                                     <%
														String checkingConfirm = (String) session.getAttribute("checkingConfirm");
														String msgConfirm = (String) session.getAttribute("msgConfirm");
														if("error".equals(checkingConfirm)){ %>
															<p style="color:red"><%= msgConfirm %></p>	
													<%	}
													%>
                                                    <div class="login_submit">
                                                        <button type="submit">Confirm</button>
                                                    </div>
                                                </form>
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
