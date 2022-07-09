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
        <title>Coron-checkout</title>
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
                                            <li>checkout</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->


                        <!--Checkout page section-->
                        <div class="Checkout_section">
                            <div class="row">
                                   <div class="col-12">
                                   </div>
                                </div>
                            <div class="checkout_form">
                                    <div class="row">
                                        <%
                                        float amount = (float) session.getAttribute("amount");
                                   		double DepositVND = (double) amount * 22000;
										String email = (String) session.getAttribute("AccountName");
										AccountDetailDAO detailDAO = new AccountDetailDAO();
										AccountDetail detail = detailDAO.getDetailByEmail(email);
										%>
                                        <div class="col-lg-6 col-md-6">
                                            <form action="#">    
                                                <h3>Your Deposit</h3> 
                                                <div class="order_table table-responsive mb-30">
                                                    <table>
                                                      
                                                        <tbody>
                                                            <tr>
                                                                <td><p><b>Deposit ID: </b></p></td>
                                                            </tr>
                                                            <tr>
                                                                <td><p><b>Account Name:<%= detail.getAccountName() %> </b></p></td>
                                                            </tr>
                                                            <tr>
                                                                <td><p><b>Amount USDT: <%= amount %></b></p></td>  
                                                            </tr>
                                                            <tr>
                                                                <td><p><b>Deposit VND: <%= DepositVND %></b></p></td>
                                                            </tr>
                                                        </tbody>
                                                        <tfoot>
                                                            <tr>
                                                                <th>Cart Subtotal</th>
                                                                <td>$215.00</td>
                                                            </tr>
                                                            <tr>
                                                                <th>Shipping</th>
                                                                <td><strong>$5.00</strong></td>
                                                            </tr>
                                                            <tr class="order_total">
                                                                <th>Order Total</th>
                                                                <td><strong>$220.00</strong></td>
                                                            </tr>
                                                        </tfoot>
                                                    </table>     
                                                </div>
                                                
                                            </form>         
                                        </div>
                                    </div> 
                                </div>        
                        </div>
                        <!--Checkout page section end-->

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
