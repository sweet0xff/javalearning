<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-md-4 world">
					<ul >
						<li>
						<select class="in-drop">
							  <option>English</option>
							  <option>Japanese</option>
							  <option>French</option>
							</select></li>
						<li><select class="in-drop1">
							  <option>Dollar</option>
							  <option>Euro</option>
							  <option>Yen</option>
							</select>
						</li>
					</ul>
				</div>
				<div class="col-md-4 logo">
					<a href="index.html"><img src="images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-md-4 header-left">		
					<p class="log"><a href="account.html"  >Login</a>
						<span>or</span><a  href="account.html"  >Signup</a></p>
					<div class="cart box_1">
						<a href="checkout.html">
						<h3> <div class="total">
							<span class="simpleCart_total"></span></div>
							<img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-md-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
	<div class="col-md-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="index.html">Home</a></li>	
				      <li><a  href="#">Men</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>All Clothing</h4>
									<ul>
										<li><a href="products.html">Shirts</a></li>
										<li><a href="products.html">Sports Wear</a></li>
										<li><a href="products.html">Shorts</a></li>
										<li><a href="products.html">Suits & Blazers</a></li>
										<li><a href="products.html">Formal Shirts</a></li>
										<li><a href="products.html">Sweatpants</a></li>
										<li><a href="products.html">Swimwear</a></li>
										<li><a href="products.html">Trousers & Chinos</a></li>
										<li><a href="products.html">T-Shirts</a></li>
										<li><a href="products.html">Underwear & Socks</a></li>
										
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Footwear</h4>
									<ul>
										<li><a href="products.html">Formal Shoes</a></li>
										<li><a href="products.html">Boots</a></li>
										<li><a href="products.html">Sports Shoes</a></li>
										<li><a href="products.html">Casual Shoes</a></li>
										<li><a href="products.html">Running Shoes</a></li>
										<li><a href="products.html">Sneakers</a></li>
										<li><a href="products.html">Loafers</a></li>
										<li><a href="products.html">Slippers</a></li>
										<li><a href="products.html">Sandals</a></li>
										<li><a href="products.html">Flip-flops</a></li>
									
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Popular Brands</h4>
									<ul>
										<li><a href="products.html">Levis</a></li>
										<li><a href="products.html">Persol</a></li>
										<li><a href="products.html">Nike</a></li>
										<li><a href="products.html">Edwin</a></li>
										<li><a href="products.html">New Balance</a></li>
										<li><a href="products.html">Jack & Jones</a></li>
										<li><a href="products.html">Paul Smith</a></li>
										<li><a href="products.html">Ray-Ban</a></li>
										<li><a href="products.html">Wood Wood</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a  href="#">	Women</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>All Clothing</h4>
									<ul>
										<li><a href="products.html">Shirts & Tops</a></li>
										<li><a href="products.html">Sports Wear</a></li>
										<li><a href="products.html">Kurtas & Kurties</a></li>
										<li><a href="products.html">Suits & Blazers</a></li>
										<li><a href="products.html">Sarees</a></li>
										<li><a href="products.html">Sweatpants</a></li>
										<li><a href="products.html">Swimwear</a></li>
										<li><a href="products.html">Night-Suits</a></li>
										<li><a href="products.html">T-Shirts</a></li>
										<li><a href="products.html">Jeans</a></li>
										
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Footwear</h4>
									<ul>
										<li><a href="products.html">Heels</a></li>
										<li><a href="products.html">Flats</a></li>
										<li><a href="products.html">Sports Shoes</a></li>
										<li><a href="products.html">Casual Shoes</a></li>
										<li><a href="products.html">Running Shoes</a></li>
										<li><a href="products.html">Wedges</a></li>
										<li><a href="products.html">Boots</a></li>
										<li><a href="products.html">Pumps</a></li>
										<li><a href="products.html">Slippers</a></li>
										<li><a href="products.html">Flip-flops</a></li>
									
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Popular Brands</h4>
									<ul>
										<li><a href="products.html">Levis</a></li>
										<li><a href="products.html">Persol</a></li>
										<li><a href="products.html">Nike</a></li>
										<li><a href="products.html">Edwin</a></li>
										<li><a href="products.html">New Balance</a></li>
										<li><a href="products.html">Jack & Jones</a></li>
										<li><a href="products.html">Paul Smith</a></li>
										<li><a href="products.html">Ray-Ban</a></li>
										<li><a href="products.html">Wood Wood</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a  href="typo.html">Blog</a></li>				
				<li><a class="color6" href="contact.html">Conact</a></li>
			  </ul> 
			</div>
				<div class="col-md-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!---->		
		</div>
	</div>
</div>
<!--//header-->
<!---->
<div class="container">
	<div class="check-out">
		<h1>Checkout</h1>
    	    <table >
		  <tr>
			<th>Item</th>
			<th>Qty</th>		
			<th>Prices</th>
			<th>Delery Detials</th>
			<th>Subtotal</th>
		  </tr>
		  <tr>
			<td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>
			
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$100.00</td>
			<td>FREE SHIPPING</td>
			<td>$100.00</td>
		  </tr>
		  <tr>
		  <td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce1.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium ) </p>
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$200.00</td>
			<td>FREE SHIPPING</td>
			<td>$200.00</td>
		  </tr>
		  <tr>
		  <td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce2.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$150.00</td>
			<td>FREE SHIPPING</td>
			<td>$150.00</td>
		  </tr>
	</table>
	<a href="#" class=" to-buy">PROCEED TO BUY</a>
	<div class="clearfix"> </div>
    </div>
</div>
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-md-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus  dui. </li>
						<li>orci, ornareidquet</li>
						<li> ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
</html>