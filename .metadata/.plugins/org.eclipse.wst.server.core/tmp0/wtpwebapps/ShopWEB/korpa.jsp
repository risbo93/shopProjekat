<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" type="text/css" href="modal.css">
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
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
					<li><form accept-charset="UTF-8"
						action="/ShopWEB/ONamaServlet" method="get">
						<button class="dugme" type="submit">O nama</button>
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


	
<button type="submit" class="btn btn-primary btn-lg btn-block">Nazad na kupovinu</button>
         <div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table  class="table table-striped custab">
    <thead>
        <tr>
            <th>Naziv</th>
            <th>Kategorija</th>
            <th>Cena</th>
            <th>Kolicina</th>
            <th class="text-center">Akcija</th>
        </tr>
    </thead>
    		<c:forEach var="stavka" items="${ulogovanaOsoba.stavkas }">
            <tr>
                <th>${stavka.stvari.naziv }</th>
            	<th>${stavka.stvari.kategorija }</th>
           	 	<th>${stavka.stvari.cena }</th>
            	<th>${stavka.kolicina }</th>
                <td class="text-center"> <form  action="/ShopWEB/ObrisiIzKorpeServlet" method="post">
                <input name="odabirBrisanja" type="hidden" value="${stavka.idStavka }"> 
                <button type="submit" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Ukloni</button>
                </form>
                </td>
            </tr>
            </c:forEach>
    </table>
    <h4>Odaberite nacin dostave:</h4>
    <p></p>
    <div class="cols-sm-10">
							<div class="input-group">
								<select name="odabranaKS" class="form-control">
									<c:forEach var="dostava" items="${listaDostava }">
										<option value="${dostava.idDostava }">${dostava.naziv }</option>
									</c:forEach>
								</select> 
							</div>
						</div>
						<p></p>

    </div>
</div>
</body>
</html>