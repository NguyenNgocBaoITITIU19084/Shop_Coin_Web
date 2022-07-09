<!--header area -->
<div class="header_area">
	<!--header top-->
	<div class="header_top">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6">
				<div class="switcher"></div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="header_links">
					<ul>
						<li><a href="contact.html" title="Contact">Contact</a></li>
						<li><a href="wishlist.html" title="wishlist">My wishlist</a></li>
						<li><a href="account.jsp" title="My account">Dash Board</a></li>
						<li><a href="cart.html" title="My cart">My cart</a></li>
						<li><a href="LogoutServlet" title="Login">Logout</a></li>
					</ul>
				</div>
			</div>
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
					<% if (session.getAttribute("AccountName") != null) {
						String userName = (String) session.getAttribute("userName");
						float Balance = (float) session.getAttribute("Balance");
					%>
						<p> Hi, <%=userName%> - $<%=Balance %>USDT</p>
					<% } %>

				</div>
			</div>
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
									<div class="mega_menu jewelry">
										<div class="mega_items jewelry">
											<ul>
												<li><a href="index.html">Home 1</a></li>
												<li><a href="index-2.html">Home 2</a></li>
											</ul>
										</div>
									</div></li>
								<li><a href="shop.html">shop</a>
									<div class="mega_menu jewelry">
										<div class="mega_items jewelry">
											<ul>
												<li><a href="shop-list.html">shop list</a></li>
												<li><a href="shop-fullwidth.html">shop Full Width
														Grid</a></li>
												<li><a href="shop-fullwidth-list.html">shop Full
														Width list</a></li>
												<li><a href="shop-sidebar.html">shop Right Sidebar</a></li>
												<li><a href="shop-sidebar-list.html">shop list
														Right Sidebar</a></li>
												<li><a href="single-product.html">Product Details</a></li>
												<li><a href="single-product-sidebar.html">Product
														sidebar</a></li>
												<li><a href="single-product-video.html">Product
														Details video</a></li>
												<li><a href="single-product-gallery.html">Product
														Details Gallery</a></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#">women</a>
									<div class="mega_menu">
										<div class="mega_top fix">
											<div class="mega_items">
												<h3>
													<a href="#">Accessories</a>
												</h3>
												<ul>
													<li><a href="#">Cocktai</a></li>
													<li><a href="#">day</a></li>
													<li><a href="#">Evening</a></li>
													<li><a href="#">Sundresses</a></li>
													<li><a href="#">Belts</a></li>
													<li><a href="#">Sweets</a></li>
												</ul>
											</div>
											<div class="mega_items">
												<h3>
													<a href="#">HandBags</a>
												</h3>
												<ul>
													<li><a href="#">Accessories</a></li>
													<li><a href="#">Hats and Gloves</a></li>
													<li><a href="#">Lifestyle</a></li>
													<li><a href="#">Bras</a></li>
													<li><a href="#">Scarves</a></li>
													<li><a href="#">Small Leathers</a></li>
												</ul>
											</div>
											<div class="mega_items">
												<h3>
													<a href="#">Tops</a>
												</h3>
												<ul>
													<li><a href="#">Evening</a></li>
													<li><a href="#">Long Sleeved</a></li>
													<li><a href="#">Shrot Sleeved</a></li>
													<li><a href="#">Tanks and Camis</a></li>
													<li><a href="#">Sleeveless</a></li>
													<li><a href="#">Sleeveless</a></li>
												</ul>
											</div>
										</div>
										<div class="mega_bottom fix">
											<div class="mega_thumb">
												<a href="#"><img src="assets\img\banner\banner1.jpg"
													alt=""></a>
											</div>
											<div class="mega_thumb">
												<a href="#"><img src="assets\img\banner\banner2.jpg"
													alt=""></a>
											</div>
										</div>
									</div></li>
								<li><a href="#">men</a>
									<div class="mega_menu">
										<div class="mega_top fix">
											<div class="mega_items">
												<h3>
													<a href="#">Rings</a>
												</h3>
												<ul>
													<li><a href="#">Platinum Rings</a></li>
													<li><a href="#">Gold Ring</a></li>
													<li><a href="#">Silver Ring</a></li>
													<li><a href="#">Tungsten Ring</a></li>
													<li><a href="#">Sweets</a></li>
												</ul>
											</div>
											<div class="mega_items">
												<h3>
													<a href="#">Bands</a>
												</h3>
												<ul>
													<li><a href="#">Platinum Bands</a></li>
													<li><a href="#">Gold Bands</a></li>
													<li><a href="#">Silver Bands</a></li>
													<li><a href="#">Silver Bands</a></li>
													<li><a href="#">Sweets</a></li>
												</ul>
											</div>
											<div class="mega_items">
												<a href="#"><img src="assets\img\banner\banner3.jpg"
													alt=""></a>
											</div>
										</div>

									</div></li>
								<li><a href="#">pages</a>
									<div class="mega_menu">
										<div class="mega_top fix">
											<div class="mega_items">
												<h3>
													<a href="#">Column1</a>
												</h3>
												<ul>
													<li><a href="portfolio.html">Portfolio</a></li>
													<li><a href="portfolio-details.html">single
															portfolio </a></li>
													<li><a href="about.html">About Us </a></li>
													<li><a href="about-2.html">About Us 2</a></li>
													<li><a href="services.html">Service </a></li>
													<li><a href="my-account.html">my account </a></li>
												</ul>
											</div>
											<div class="mega_items">
												<h3>
													<a href="#">Column2</a>
												</h3>
												<ul>
													<li><a href="blog.html">Blog </a></li>
													<li><a href="blog-details.html">Blog Details </a></li>
													<li><a href="blog-fullwidth.html">Blog FullWidth</a></li>
													<li><a href="blog-sidebar.html">Blog Sidebar</a></li>
													<li><a href="faq.html">Frequently Questions</a></li>
													<li><a href="404.html">404</a></li>
												</ul>
											</div>
											<div class="mega_items">
												<h3>
													<a href="#">Column3</a>
												</h3>
												<ul>
													<li><a href="contact.html">Contact</a></li>
													<li><a href="cart.html">cart</a></li>
													<li><a href="checkout.html">Checkout </a></li>
													<li><a href="wishlist.html">Wishlist</a></li>
													<li><a href="login.html">Login</a></li>
												</ul>
											</div>
										</div>
									</div></li>

								<li><a href="blog.html">blog</a>
									<div class="mega_menu jewelry">
										<div class="mega_items jewelry">
											<ul>
												<li><a href="blog-details.html">blog details</a></li>
												<li><a href="blog-fullwidth.html">blog fullwidth</a></li>
												<li><a href="blog-sidebar.html">blog sidebar</a></li>
											</ul>
										</div>
									</div></li>
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