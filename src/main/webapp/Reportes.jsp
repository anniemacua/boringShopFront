<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formularios.css"media="screen" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Reportes</title>
</head>
<body style="background-color: transparent;">
	<div class="row">
		<div class="col-md-5 seccion1">
			<form class="form-sign" method="get" action="Controlador">
				<div class="card">
					<div class="card-body text-white bg-dark mb-3">
						<div class="form-group">
							<h4>Seleccione el tipo de reporte:</h4>
						</div>
						<input type="hidden" name="menu" value="Reportes">
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex p-3" align="center">
								<input type="submit" name="accion" value="ReporteUsuarios" class="btn btn-outline-dark text-white"> 
								<input type="submit" name="accion" value="ReporteClientes" class="btn btn-outline-dark text-white"> 
								<input type="submit" name="accion" value="ReporteVentas" class="btn btn-outline-dark text-white">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-7 seccion2">
			<div class="card">
				<div class="card-body text-white bg-dark mb-3">
					<div class="form-group">
						<h4>Detalle del Reporte</h4>
					</div>
					<!-- <table class="table table-dark table-striped">-->
					<table class="table table-striped table-dark table-hover text-white">
						<c:if test="${opcion==1}">
							<thead>
								<tr>
									<th scope="col">Cedula</th>
									<th scope="col">Nombre</th>
									<th scope="col">Email</th>
									<th scope="col">Usuario</th>
									<th scope="col">Clave</th>
								</tr>
							</thead>
							<c:forEach var="lista" items="${lista}">
								<tbody>
									<tr>
										<td>${lista.getCedula_usuario()}</td>
										<td>${lista.getNombre_usuario()}</td>
										<td>${lista.getEmail_usuario()}</td>
										<td>${lista.getUsuario()}</td>
										<td>${lista.getClave()}</td>
									</tr>
							</c:forEach>
							</tbody>
						</c:if>
						<c:if test="${opcion==2}">
							<thead>
								<tr>
									<th scope="col">Cedula</th>
									<th scope="col">Nombre</th>
									<th scope="col">Email</th>
									<th scope="col">Direccion</th>
									<th scope="col">Telefono</th>
								</tr>
							</thead>
							<c:forEach var="lista" items="${lista}">
								<tbody>
									<tr>
										<td>${lista.getCedula_cliente()}</td>
										<td>${lista.getDireccion_cliente()}</td>
										<td>${lista.getEmail_cliente()}</td>
										<td>${lista.getNombre_cliente()}</td>
										<td>${lista.getTelefono_cliente()}</td>
									</tr>
							</c:forEach>
							</tbody>
						</c:if>
						<c:if test="${opcion==3}">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">codigo</th>
									<th scope="col">producto</th>
									<th scope="col">precio</th>
									<th scope="col">cantidad</th>
									<th scope="col">iva</th>
									<th scope="col">total</th>
								</tr>
							</thead>
							<c:forEach var="lista" items="${listaVentas}">
								<tbody>
									<tr>
										<th>${lista.getCodigo_detalle_venta()}</th>
										<th>${lista.getCodigo_producto()}</th>
										<th>${lista.getDescripcion_producto()}</th>
										<th>${lista.getPrecio_producto()}</th>
										<th>${lista.getCantidad_producto()}</th>
										<th>${lista.getValor_iva()}</th>
										<th>${lista.getValor_venta()}</th>
									</tr>
							</c:forEach>
							</tbody>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>