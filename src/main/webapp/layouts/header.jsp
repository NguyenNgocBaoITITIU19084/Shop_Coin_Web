<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="Context.*" %>
<%@page import="DAO.*" %>
<%@page import="Controller.*" %>
<%@page import="Entity.*" %>
<!--header area -->
<div class="header_area">
	<!--header top-->
	<div class="header_top">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6">
				<div class="switcher"></div>
			</div>
			<%
				if (session.getAttribute("AccountName") != null) {
			%>
			<div class="col-lg-6 col-md-6">
				<div class="header_links">
					<ul>
						<li><a href="contact.html" title="Contact">Contact</a></li>
						
						<li><a href="account.jsp" title="My account">Dash Board</a></li>
						
						<li><a href="LogoutServlet" title="Login">Logout</a></li>
					</ul>
				</div>
			</div>
			<%} %>
			<%
			if (session.getAttribute("AdminController") != null) { %>
			
			<div class="col-lg-6 col-md-6">
				<div class="header_links">
					<ul>
						<li><a href="LogoutServlet" title="Login">Logout</a></li>
					</ul>
				</div>
			</div>
			<% } %>
			
		</div>
	</div>
	<!--header top end-->

	<!--header middel-->
	<div class="header_middel">
		<div class="row align-items-center">
			<div class="col-lg-3 col-md-3">
				<div class="logo">
					<a href="index.html"><img src="assets\img\logo\logo.jpg.png"
						alt=""></a>
				</div>
			</div>
			<%if (session.getAttribute("AccountName") != null) { %>
			<div class="col-lg-9 col-md-9">
				<div class="header_right_info">
					<div class="search_bar">
						<form action="#">
							<input placeholder="Search..." type="text">
							<button type="submit">
								<i class="fa fa-search"></i>
							</button>
						</form>
					</div>
					<% 
						String email = (String) session.getAttribute("AccountName");
						AccountDetailDAO daoDetail = new AccountDetailDAO();
						AccountDetail detail = daoDetail.getDetailByEmail(email);
					%>
						<p> Hi, <%= detail.getAccountName() %> - <%= detail.getBalance() %>USDT</p>
				</div>
			</div>
			<% } %>
		</div>
	</div>
	<!--header middel end-->
	<div class="header_bottom">
		<div class="row">
			<div class="col-12">
				<div class="main_menu_inner">
					<div class="main_menu d-none d-lg-block">
						<nav>
							<ul>
								<li class="active"><a href="index.html">Home</a>
								<li><a href="contact.html">contact us</a></li>

							</ul>
						</nav>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<!--header end -->