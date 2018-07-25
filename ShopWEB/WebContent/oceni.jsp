<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" type="text/css" href="modal.css">
<link rel="stylesheet" type="text/css" href="oceni.css">
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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<style type="text/css">
a.list-group-item {
	height: auto;
	min-height: 220px;
}

a.list-group-item.active small {
	color: #fff;
}

.stars {
	margin: 20px auto 1px;
}
</style>
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

<title>Kupovina</title>

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
				<li><form accept-charset="UTF-8" action="/ShopWEB/IndexServlet"
						method="get">
						<button class="dugme" type="submit">Home</button>
					</form></li>
				<li><form accept-charset="UTF-8"
						action="/ShopWEB/KupovinaServlet" method="get">
						<button class="dugme" type="submit">Kupovina</button>
					</form></li>
				<li><form accept-charset="UTF-8" action="/ShopWEB/ONamaServlet"
						method="get">
						<button class="dugme" type="submit">O nama</button>
					</form></li>
				<li class="button-dropdown"><a href="javascript:void(0)"
					class="dropdown-toggle"> Kategorije <span>▼</span>
				</a>
					<ul class="dropdown-menu">
						<c:forEach var="kategorija" items="${listaKategorija }">
							<li>
								<form action="/ShopWEB/KupovinaServlet" method="get">
									<input name="odabranaKategorija" type="hidden"
										value="${kategorija }">
									<button type="submit" class="btn btn-primary btn-lb btn-block">${kategorija }</button>
								</form>
							</li>
						</c:forEach>
					</ul></li>

				<li>
					<div class="search">
						<form class="navbar-form navbar-left" role="search"
							id="searchForm" action="/ShopWEB/KupovinaServlet" method="get">
							<div class="form-group">
								<input name="searchKategorija" type="text" class="form-control"
									placeholder="Pretraga">
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
	<form action="/ShopWEB/PregledKomentaraServlet" method="get">
		<button class="dugme" style="margin-left: 75%; margin-bottom: 2%;">Nazad</button>
		<input name="odabir" type="hidden" value="${stvar.idStvari }">
	</form>
	<div class="container">
		<c:choose>
								<c:when test="${poruka2=='ulogujKorisnika'}">
									<div class="container">
										<div class="row">
											<div class="alert-group">
												<div class="alert alert-warning alert-dismissable">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true">×</button>
													<strong>Upozorenje!</strong> Morate biti ulogovani da bi
													ste ostavili komentar!
												</div>
											</div>
										</div>
									</div>
								</c:when>

								<c:when test="${poruka2=='faliKomentar'}">
									<div class="container">
										<div class="row">
											<div class="alert-group">
												<div class="alert alert-warning alert-dismissable">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true">×</button>
													<strong>Upozorenje!</strong> Niste uneli komentar.
												</div>
											</div>
										</div>
									</div>
								</c:when>

								<c:when test="${poruka2=='zvezda'}">
									<div class="container">
										<div class="row">
											<div class="alert-group">
												<div class="alert alert-warning alert-dismissable">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true">×</button>
													<strong>Upozorenje!</strong> Niste ocenili proizvod.
												</div>
											</div>
										</div>
									</div>
								</c:when>

								<c:when test="${poruka2=='uspesanKomentar'}">
									<div class="container">
										<div class="row">
											<div class="alert-group">
												<div class="alert alert-success alert-dismissable">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true">×</button>
													<strong>Cestitamo!</strong> Uspesno ste postavili ocenu i komentar.
												</div>
											</div>
										</div>
									</div>
								</c:when>

							</c:choose>
		<div class="row">
			<div class="well">
				<div class="list-group">

					<link rel="stylesheet"
						href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">
					<div class="container">
						<div class="row">

							<h2 style="text-align: center">
								<strong>Ocenite proizvod:</strong>
							</h2>
							<h3 style="text-align: center">${stvar.naziv }</h3>
							<img src="${stvar.slika }" class="center">

						</div>
						<form action="/ShopWEB/OceniServlet" method="post">
							<input name="odabir" type="hidden" value="${stvar.idStvari }">
							<link rel="stylesheet"
								href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
							<div class="stars" style="margin-left: 38%">
								<input class="star star-5" id="star-5" type="radio" name="star"
									value="5" /> <label class="star star-5" for="star-5"></label>
								<input class="star star-4" id="star-4" type="radio" name="star"
									value="4" /> <label class="star star-4" for="star-4"></label>
								<input class="star star-3" id="star-3" type="radio" name="star"
									value="3" /> <label class="star star-3" for="star-3"></label>
								<input class="star star-2" id="star-2" type="radio" name="star"
									value="2" /> <label class="star star-2" for="star-2"></label>
								<input class="star star-1" id="star-1" type="radio" name="star"
									value="1" /> <label class="star star-1" for="star-1"></label>

							</div>
							<div class="row">

								<div class="col-md-6">
									<div class="widget-area no-padding blank">
										<div class="status-upload">

											<textarea name="komentar" placeholder="Unesite vas komentar."
												rows="12" cols="120" style="margin-left: 22%"></textarea>

											<button type="submit" class="btn btn-success green"
												style="margin-left: 160%; margin-top: 3%;">
												<i class="fa fa-share"></i>Postavi
											</button>

										</div>
										<!-- Status Upload  -->
									</div>
									<!-- Widget Area -->
								</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
</body>
</html>