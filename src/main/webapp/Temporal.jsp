<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BoringShop | Login</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="css/login.css" media="screen" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<!--<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,500;1,400&display=swap"
	rel="stylesheet">-->
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="login.js"></script>
<!--Incorporo al proyecto javascript -->


</head>
<body>
<div class="fondologin">
	<div class="container">
		<div class="p-5 row vh-80 justify-content-center align-items-center">

			<div class="abs-center text-center justify-content-center align-items-center">
				<form class="border p-3 form rounded">
					<img class="droplogo" src="./images/Logo.png" alt="BoringShop"
					class="center-block" width="190" height="170"/>
					<!--<h2 class="text-center subtitulo">La manera sencilla de
						comprar.</h2> -->
					<div class="form-group">
						<input type="text" class="form-control text-center" id="usuario"
							placeholder="Ingrese usuario">
					</div>
					<div class="form-group">
						 <input type="password"
							id="clave" class="form-control text-center" placeholder="Ingrese contrase�a">
					</div>
					<button type="submit" id="btn_Enviaru"
						class="btn btn-outline-dark text-white">Entrar</button>
				</form>
			</div>
		</div>
	</div>

	<div class="copyright" align="center">
		<p>Copyright &copy; 2021</p>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>