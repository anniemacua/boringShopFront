<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="./Codigos.js"></script>
<head>
<link rel="stylesheet" type="text/css" href="css/formularios.css"media="screen" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Productos</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row mt-5">
			<div class="col">
				<div class="card bg-transparent col-12 border-0">
					<div class="mb-3">
						<!-- Cargar archivo -->
						<form method="post" name="formulario"
							enctype="multipart/form-data">
							<div class="row">
								<div class="col-11">
									<input type="file" name="archivo" class="form-control"
										id="archivo">
								</div>
								<div class="col-1">
									<input type="submit" value="Procesar" name="Procesar"
										onclick="cargarArchivo(archivo)"
										class="btn btn-success aling-center">
								</div>
							</div>
							<input type="hidden" name="nombre" value=""> <input
								type="hidden" name="nombre2" value="">
						</form>
					</div>
				</div>
				<div class="container-fluid">
					<div class="row mt-5">
						<div class="col-12">
							<!-- VALIDACIONES -->
							<div class="card bg-transparent border-0">
								<c:choose>
									<c:when test="${error == 0}">
										<div class="card-body bg-danger rounded">
											<h5 class=text-center>Error: datos inv�lidos, Revise
												archivo plano</h5>
										</div>
									</c:when>
									<c:when test="${error == 1}">
										<div class="card-body bg-danger rounded">
											<h5 class=text-center>Error: no se seleccion� archivo
												para cargar</h5>
										</div>
									</c:when>
									<c:when test="${error == 2}">
										<div class="card-body bg-success rounded">
											<h5 class=text-center>Archivo Cargado Exitosamente</h5>
										</div>
									</c:when>
									<c:when test="${error == 3}">
										<div class="card-body bg-danger rounded">
											<h5 class=text-center>Error: formato de archivo inv�lido</h5>
										</div>
									</c:when>
									<c:when test="${error == 4}">
										<div class="card-body bg-danger rounded">
											<h5 class=text-center>Algunos registros no se cargaron:
												por favor revise si a�adio el nit en modulo proveedores</h5>
										</div>
									</c:when>
									<c:when test="${error == 5}">
										<div class="card-body bg-danger rounded">
											<h5 class=text-center>Algunos registros no se han
												cargado</h5>
											<h5 class=text-center>Los Productos se han cargado</h5>
											<c:if test="${registros2 != '' }">
												<h5 class=text-center>,los Productos con los codigos:
													"${registros2}" ya existen en la base de datos</h5>
											</c:if>
											<c:if test="${registros == ''}">
												<h5 class=text-center>,los demas registros se cargaron
													correctamente</h5>
											</c:if>
											<c:if test="${registros != ''}">
												<h5 class=text-center>,hay registros donde el proveedor
													no existe en base de datos porfavor verifique el modulo
													proveedores</h5>
												<h5 class=text-center>el proveedor ${registros} no
													existe</h5>
											</c:if>
										</div>
									</c:when>
								</c:choose>
							</div>
							<iframe name="null" style="display: none;"></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>