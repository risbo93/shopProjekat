<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" type="text/css" href="index2.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script>
	function myFunction() {
		var x = document.getElementById("Demo");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}

	jQuery(document).ready(
			function(e) {
				function t(t) {
					e(t).bind("click", function(t) {
						t.preventDefault();
						e(this).parent().fadeOut()
					})
				}
				e(".dropdown-toggle").click(
						function() {
							var t = e(this).parents(".button-dropdown")
									.children(".dropdown-menu").is(":hidden");
							e(".button-dropdown .dropdown-menu").hide();
							e(".button-dropdown .dropdown-toggle").removeClass(
									"active");
							if (t) {
								e(this).parents(".button-dropdown").children(
										".dropdown-menu").toggle().parents(
										".button-dropdown").children(
										".dropdown-toggle").addClass("active")
							}
						});
				e(document).bind("click", function(t) {
					var n = e(t.target);
					if (!n.parents().hasClass("button-dropdown"))
						e(".button-dropdown .dropdown-menu").hide();
				});
				e(document).bind(
						"click",
						function(t) {
							var n = e(t.target);
							if (!n.parents().hasClass("button-dropdown"))
								e(".button-dropdown .dropdown-toggle")
										.removeClass("active");
						})
			});
</script>
<title>Index</title>

</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				style="font-size: 200%; margin: 4px 4px 4px 9px;" href="#">Web
				Store</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
				<li><form accept-charset="UTF-8"
						action="/ShopWEB/IndexServlet" method="get">
						<button class="dugme" type="submit">Home</button>
					</form></li>
					<li><form accept-charset="UTF-8"
						action="/ShopWEB/KupovinaServlet" method="get">
						<button class="dugme" type="submit">Kupovina</button>
					</form></li>
				<li class="button-dropdown"><a href="javascript:void(0)"
					class="dropdown-toggle"> Kategorije <span>▼</span>
				</a>
					<ul class="dropdown-menu">
						
						<c:forEach var="kategorija" items="${listaKategorija }">
						<li>
						<form  action="/ShopWEB/KupovinaServlet" method="get">
                		<input name="odabranaKategorija" type="hidden" value="${kategorija }"> 
						<button type="submit" class="btn btn-primary btn-lb btn-block">${kategorija }</button>
						</form></li>
						</c:forEach>
					</ul></li>

				<li>
					<div class="search">
						<form class="navbar-form navbar-left" role="search" id="searchForm" action="/ShopWEB/KupovinaServlet" method="get">
							<div class="form-group">
								<input name="searchKategorija" type="text" class="form-control" placeholder="Pretraga">
							</div>
							<button type="submit" class="btn btn-default">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</form>
					</div>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${ulogovanaOsoba == null }">
						<li class="dropdown">
							<div class="w3-dropdown-click">
								<button onclick="myFunction()" class="dropbtn">Login</button>
								<div id="Demo"
									class="w3-dropdown-content w3-bar-block w3-animate-zoom"
									style="right: 0">
									<div class="panel-body">
										<form accept-charset="UTF-8" action="/ShopWEB/IndexServlet"
											method="post">
											<fieldset>
												<div class="form-group">
													<input class="form-control" placeholder="username"
														name="username" type="text">
												</div>
												<div class="form-group">
													<input class="form-control" placeholder="password"
														name="password" type="password" value="">
												</div>
												<button class="btn btn-lg btn-success btn-block"
													type="submit">Login</button>
												<p></p>
												<p style="font-size: 12px;">${poruka }</p>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</li>
						<li>
							<form accept-charset="UTF-8" action="/ShopWEB/RegisterServlet"
								method="get">
								<button class="registracijaDugme">Register</button>
							</form>
						</li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${ulogovanaOsoba != null }">
						<li><a class="navbar-brand"
							style="font-size: 130%; margin: 4px 4px 4px 9px;" href="#">Dobrodosli,
								${ulogovanaOsoba.ime }</a></li>
						<li>
							<form accept-charset="UTF-8" action="/ShopWEB/LogoutServlet"
								method="get">
								<button class="dropbtn" type="submit">Logout</button>
							</form>
						</li>
					</c:when>
				</c:choose>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


	<article>
	<div class="item-wrapper">
		<figure>
		<div class="image"
			style="background-image: url(https://cross-sportswear.com/wp-content/uploads/puff_menswear_ss18.jpg);"></div>
		<div class="lighting"></div>
		</figure>
		<div class="item-content">
			<h1>Men's Fashion</h1>
			<p>Veliki izbor muske odece i obuce</p>
		</div>
	</div>
	</article>
	<article>
	<div class="item-wrapper">
		<figure>
		<div class="image"
			style="background-image: url(https://cdn.shopify.com/s/files/1/0832/5243/files/Jess_Crop_Top_Landing_Page_2000x.jpg?v=1531348562);"></div>
		<div class="lighting"></div>
		</figure>
		<div class="item-content">
			<h1>Veliki Popusti</h1>
			<p>Izaberite vasu idealnu letnju kombinaciju</p>
		</div>
	</div>
	</article>
	<article>
	<div class="item-wrapper">
		<figure>
		<div class="image"
			style="background-image: url(http://www.gojanovic.com/images/slider/1.jpg);"></div>
		<div class="lighting"></div>
		</figure>
		<div class="item-content">
			<h1>Home & Garden</h1>
			<p>Opremite vas stan po najnovijim standardima i ustedite novac</p>
		</div>
	</div>
	</article>
	<script>
		var articles = $('article > .item-wrapper'), lightingRgb = '255,255,255';

		articles
				.mousemove(function(e) {
					var current = $(this), x = current.width() - e.offsetX * 2, y = current
							.height()
							- e.offsetY * 2, rx = -x / 30, ry = y / 24, deg = Math
							.atan2(y, x)
							* (180 / Math.PI) + 45;
					current.css({
						"transform" : "scale(1.05) rotateY(" + rx
								+ "deg) rotateX(" + ry + "deg)"
					});
					$('figure > .lighting', this).css(
							'background',
							'linear-gradient(' + deg + 'deg, rgba('
									+ lightingRgb + ',0.32) 0%, rgba('
									+ lightingRgb + ',0) 100%)');
				});

		articles.on({
			'mouseenter' : function() {
				var current = $(this);
				current.addClass('enter ease').removeClass("leave");
				setTimeout(function() {
					current.removeClass('ease');
				}, 280);
			},
			'mouseleave' : function() {
				var current = $(this);
				current.css({
					"transform" : "rotate(0)"
				});
				current.removeClass('enter').addClass("leave");
				$('figure > .lighting', this).removeAttr('style');
			}
		});
	</script>
</body>
</html>