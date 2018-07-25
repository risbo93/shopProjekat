<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" type="text/css" href="index2.css">
<link rel="stylesheet" type="text/css" href="administracija.css">
<link rel="stylesheet" type="text/css" href="register.css">
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
<title>Dodaj proizvod</title>

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
							<form accept-charset="UTF-8" action="/ShopWEB/RegisterServlet" method="get">
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
<form action="/ShopWEB/CompanyAdminServlet" method="get">
		<button class="dugme" style="margin-left: 65%; margin-bottom: 2%; display:inline-block;">Nazad</button>
	</form>
	
	<c:choose>
    <c:when test="${poruka3=='trebaPopuniti'}">
<div class="container">
	<div class="row">
		<div class="alert-group">
            <div class="alert alert-warning alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Upozorenje!</strong>       Morate popuniti sve podatke o proizvodu!
            </div>
        </div>
	</div>
</div>
    </c:when>    
    
    <c:when test="${poruka3=='uspesno'}">
<div class="container">
	<div class="row">
		<div class="alert-group">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Dodato!</strong> Upesno dodat proizvod.
            </div>
        </div>
	</div>
</div>
    </c:when> 
    
     <c:when test="${poruka3=='neuspesno'}">
<div class="container">
	<div class="row">
		<div class="alert-group">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Neuspesno!</strong> Pogresno uneti podaci!
            </div>
        </div>
	</div>
</div>
    </c:when>   
    
          
    </c:choose>
	
<div class="container">
<div class="row">
		<div class="well">
					<div class="list-group">
				
									<hr class="colorgraph">
					<form action="/ShopWEB/DodajProizvodServlet" method="post">
									<h3>Dodajte proizvod:</h3>
					<hr class="colorgraph">
					<div class="form-group">
						<input type="text" name="naziv" id="naziv"
							class="form-control input-lg" placeholder="Naziv Proizvoda" tabindex="6">
					</div>
					
					<div class="form-group">
						<input type="text" name="slika" id="slika"
							class="form-control input-lg" placeholder="Unesite link slike" tabindex="6">
					</div>
					
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="cena" id="cena"
									class="form-control input-lg" placeholder="Cena"
									tabindex="8">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="kategorija"
									id="kategorija" class="form-control input-lg"
									placeholder="Kategorija" tabindex="6">
							</div>
						</div>
					</div>
					
					
											<textarea name="opis" placeholder="Unesite opis."
												rows="12" cols="100" ></textarea>
					<div class="row">
						<div class="col-xs-4 col-sm-3 col-md-3">
								
						</div>
						
					</div>
					<hr class="colorgraph">
					
					
					<div class="row">
						<div class="col-xs-12 col-md-6">
							<button type="submit" style="align:center; margin-left:53%"
								class="btn btn-primary btn-block btn-lg" tabindex="7">Potvrdi</button>
						</div>
						</div>
				</form>

		</div>
	</div>
</div>
</div>
</body>
</html>