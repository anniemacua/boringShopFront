<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/principal.css"media="screen" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>BoringShop</title>
</head>
<body>
<div class="fondoprincipal">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="Controlador?menu=Principal">Home</a>
					</li>
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="Controlador?menu=Usuarios&accion=Listar" target="myFrame">Usuarios</a>
					</li>
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
					</li>
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="Controlador?menu=Proveedores&accion=Listar" target="myFrame">Proveedores</a>
					</li>
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="Controlador?menu=Productos&accion=Listar" target="myFrame">Productos</a>
					</li>
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="Controlador?menu=Ventas" target="myFrame">Ventas</a>
					</li>
					<li class="nav-item">
						<a style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="Controlador?menu=Reportes" target="myFrame">Reportes</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="dropdown">
			<button class="btn btn-outline-light dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">${usuario.getNombre_usuario()}</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<a class="dropdown-item" href="#"><img src="imagen/login.jpg"
					width="40" alt="40"></a> <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
				<a class="dropdown-item" href="#">${usuario.getEmail_usuario()}</a>
				<div class="dropdown-divider"></div>
				<form class="dropdown-item" method="POST" action="#">
					<button class="btn btn-danger center-block" type="submit"
						name="accion" value="Salir">Cerrar Sesion</button>
				</form>

			</div>
		</div>
	</nav>
	<div class="m-4" style="height: 550px;">
		<iframe allowtransparency="true" style="height: 100%; width: 100%; border: none" name="myFrame">
		
		</iframe>
	</div>
	<div class="copyright" align="center">
		<p>Copyright &copy; 2021</p>
	</div>
</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>

