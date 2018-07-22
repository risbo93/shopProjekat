<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="register.css">
<script src="register.js"></script>
<title>Registruj se</title>
</head>
<body>
<div class="container">

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<h2 class="stroke">Registrujte Nalog <small class="boja">Besplatan Web Shop.</small></h2>
			<form action="/ShopWEB/IndexServlet" method="get">
			<button class="btn btn-primary" type="submit">Nazad</button>
			</form>
			<form action="/ShopWEB/RegisterServlet" method="post">
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="ime" id="ime" class="form-control input-lg" placeholder="Ime" tabindex="1">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="prezime" id="prezime" class="form-control input-lg" placeholder="Prezime" tabindex="2">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="text" name="username" id="username" class="form-control input-lg" placeholder="Username" tabindex="6">
			</div>
			<div class="form-group">
				<input type="text" name="drzava" id="drzava" class="form-control input-lg" placeholder="Drzava" tabindex="3">
			</div>
			<div class="form-group">
				<input type="text" name="grad" id="grad" class="form-control input-lg" placeholder="Grad" tabindex="4">
			</div>
			<div class="form-group">
				<input type="text" name="ulica" id="ulica" class="form-control input-lg" placeholder="Ulica" tabindex="5">
			</div>
			<div class="form-group">
				<input type="text" name="godine" id="godine" class="form-control input-lg" placeholder="Godine" tabindex="7">
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="8">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="passwordConfirm" id="passwordConfirm" class="form-control input-lg" placeholder="Potvrdi Password" tabindex="6">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">Slazem se</button>
                        <input type="checkbox" name="slazemSe" id="t_and_c" class="hidden" value="1">
					</span>
				</div>
				<div class="col-xs-8 col-sm-9 col-md-9">
					<p class="boja"> Kada kliknete na <strong class="label label-primary">Register</strong>, prihvatate uslove ovoga sajta.</p>
				</div>
				<h4 class="boja"> ${poruka }</h4>
			</div>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				
			</form>
				<div class="col-xs-12 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Sign in</a></div>
			</div>
	</div>
</div>
</div>

</body>
</html>