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


	<div class="container">
	<div class="dkorpa" style=" margin-left: 85%; margin-bottom: 1%;">  
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    -webkit-animation-name: fadeIn; /* Fade in the background */
    -webkit-animation-duration: 0.4s;
    animation-name: fadeIn;
    animation-duration: 0.4s
}

/* Modal Content */


/* The Close Button */


/* Add Animation */
@-webkit-keyframes slideIn {
    from {bottom: -300px; opacity: 0} 
    to {bottom: 0; opacity: 1}
}

@keyframes slideIn {
    from {bottom: -300px; opacity: 0}
    to {bottom: 0; opacity: 1}
}

@-webkit-keyframes fadeIn {
    from {opacity: 0} 
    to {opacity: 1}
}

@keyframes fadeIn {
    from {opacity: 0} 
    to {opacity: 1}
}
</style>

<!-- Trigger/Open The Modal -->
<button id="myBtn" class="btn btn-primary btn-lg btn-block">Korpa</button>
    
<!-- The Modal -->
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content" style="margin:6% 20% 0% 20%">
    <div class="modal-header" style="background-color:#95b9d8">
      <span class="close">&times;</span>
      <h3>Korpa</h3>
    </div>
    <div class="modal-body">
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
    		<c:forEach var="stavka" items="${listaStavki }">
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
    <form action="/ShopWEB/ObrisiIzKorpeServlet" method="post">
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
						<p></p>
						<p></p>
						<h3 style="text-align:right;">Iznos vase kupovine je: ${ukupnaCena } rsd</h3>
						
					
    <div style="margin-left:70%">
      <button type="submit" id="button"class="btn btn-primary btn-lg btn-block login-button" >Potvrdi</button>
      </div>
      </form>

    </div>
</div>
    </div>
    <div class="modal-footer" style="background-color:#95b9d8">
      
    </div>
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>


        
	</div>
		<div class="row">
			<div class="well">
				<div class="list-group">


					<c:forEach var="stvar" items="${listaStvari }">
						<c:set var="sumaOcena" value="${0}" />
						<c:set var="brojOcena" value="${0}" />
						<c:forEach var="ocenaa" items="${stvar.ocenaStvars}">
							<c:set var="sumaOcena" value="${sumaOcena + ocenaa.ocena}" />
							<c:set var="brojOcena" value="${brojOcena + 1}" />
						</c:forEach>
						<c:choose>
    								<c:when test="${brojOcena=='0'}">
         								<c:set var="brojOcenaDeljenje" value='1'  />
        							<br />
    								</c:when>    
    								<c:otherwise>
    									<c:set var="brojOcenaDeljenje" value="${brojOcena }"  />
       									 <br />
    								</c:otherwise>
    								</c:choose>
						
						
						<a href="#" class="list-group-item">
							<div class="media col-md-3">
								<figure class="pull-left"> <img
									style="height: 60%; width: 60%"
									class="media-object img-rounded img-responsive"
									src="${stvar.slika }" alt="placehold.it/350x250"> </figure>
							</div>
							<div class="col-md-6">
								<h4 class="list-group-item-heading">${stvar.naziv }</h4>
								<p></p>
								<p class="list-group-item-text">${stvar.opis }</p>
							</div>
							<div class="col-md-3 text-center">
								<h3>
									Cena: <small>${stvar.cena } rsd</small>
								</h3>
								<form action="/ShopWEB/KupovinaServlet" method="post">
								<input name="odabir" type="hidden" value="${stvar.idStvari }">
								<button type="submit" class="btn btn-primary btn-lg btn-block">Dodaj
									u korpu</button>
									</form>
								<h4>
									${brojOcena } <small> votes </small>
								</h4>
								<div class="stars">
								
									<span class="<c:choose>
    											<c:when test="${sumaOcena/brojOcenaDeljenje>'0'}">
        											glyphicon glyphicon-star 
        											<br />
    											</c:when>    
   												 <c:otherwise>
        											glyphicon glyphicon-star-empty 
        											<br />
    											</c:otherwise>
												</c:choose>"></span>
									<span class="<c:choose>
    											<c:when test="${sumaOcena/brojOcenaDeljenje>'1'}">
        											glyphicon glyphicon-star 
        											<br />
    											</c:when>    
   												 <c:otherwise>
        											glyphicon glyphicon-star-empty 
        											<br />
    											</c:otherwise>
												</c:choose>"></span>
									<span class="<c:choose>
    											<c:when test="${sumaOcena/brojOcenaDeljenje>'2'}">
        											glyphicon glyphicon-star 
        											<br />
    											</c:when>    
   												 <c:otherwise>
        											glyphicon glyphicon-star-empty 
        											<br />
    											</c:otherwise>
												</c:choose>"></span>
									<span class="<c:choose>
    											<c:when test="${sumaOcena/brojOcenaDeljenje>'3'}">
        											glyphicon glyphicon-star 
        											<br />
    											</c:when>    
   												 <c:otherwise>
        											glyphicon glyphicon-star-empty 
        											<br />
    											</c:otherwise>
												</c:choose>"></span>
									<span class="<c:choose>
    											<c:when test="${sumaOcena/brojOcenaDeljenje>'4'}">
        											glyphicon glyphicon-star 
        											<br />
    											</c:when>    
   												 <c:otherwise>
        											glyphicon glyphicon-star-empty 
        											<br />
    											</c:otherwise>
												</c:choose>"></span>
								</div>


								<p>
									Average ${sumaOcena / brojOcena} <small> / </small> 5
								</p>
							</div>
						</a>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

</body>
</html>