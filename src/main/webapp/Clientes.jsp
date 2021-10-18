<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.front.Clientes" %>

<%@page import="java.util.ArrayList"%>

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
<title>Creación de Cliente</title>
</head>
<body  style="background-color: transparent;">
	<div class="row">
		<div class="card col-md-4 text-white bg-dark mb-3">
			<div class="card-body">
				<h5 class="card-title">Clientes</h5>
				<h6 class="card-subtitle mb-2 text-muted">Módulo de gestión de clientes para la tienda Boringshop.</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Clientes"> <label>Cedula:</label>
							<input type="text" name="txtcedula" class="form-control"
								value="${clienteSeleccionado.getCedula_cliente()}">
						</div>
						<div class="form-group">
							<label>Nombre:</label> <input type="text" name="txtnombre"
								class="form-control"
								value="${clienteSeleccionado.getNombre_cliente()}">
						</div>
						<div class="form-group">
							<label>Email:</label> <input type="text" name="txtemail"
								class="form-control"
								value="${clienteSeleccionado.getEmail_cliente()}">
						</div>
						<div class="form-group">
							<label>Dirección:</label> <input type="text" name="txtdireccion"
								class="form-control"
								value="${clienteSeleccionado.getDireccion_cliente()}">
						</div>
						<div class="form-group">
							<label>Teléfono:</label> <input type="text" name="txttelefono"
								class="form-control"
								value="${clienteSeleccionado.getTelefono_cliente()}">
						</div>
						<div class="p-3" align="center">
							<input type="submit" class="btn-outline-dark text-white" name="accion"value="Agregar"> 
							<input type="submit" class="btn-outline-dark text-white" name="accion" value="Actualizar">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<table class="table table-dark table-hover text-center">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Cédula</th>
						<th scope="col">Nombre</th>
						<th scope="col">Email</th>
						<th scope="col">Dirección</th>
						<th scope="col">Teléfono</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<%
					ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("lista");
					for (Clientes cliente : lista) {
					%>
					<tr>
						<td><%=cliente.getCedula_cliente()%></td>
						<td><%=cliente.getNombre_cliente()%></td>
						<td><%=cliente.getEmail_cliente()%></td>
						<td><%=cliente.getDireccion_cliente()%></td>
						<td><%=cliente.getTelefono_cliente()%></td>
						<td><a class="btn btn-outline-warning text-white"
							href="Controlador?menu=Clientes&accion=Cargar&id=<%=cliente.getCedula_cliente()%>">Editar</a>
							<a class="btn btn-outline-danger text-white"
							href="Controlador?menu=Clientes&accion=Eliminar&id=<%=cliente.getCedula_cliente()%>">Eliminar</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
			crossorigin="anonymous"></script>
</body>
</html>

