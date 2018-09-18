<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DocApp</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">


  <!-- Stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
  <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/DocApps.css">
  
  
  <!-- Scripts -->
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/custom.js"></script>
  <script src="contactform/contactform.js"></script>
</head>


<body>
	<%@ include file="NavbarPaciente.jsp"%>
	<div class="cuerpo">
		<div class="container">
			<div class="row">
				<div class="col-md-12 titulo">
					<h1>Paciente ${paciente.nombre}</h1>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-6 datos">
					<h2>INFORMACIÓN</h2>
<p>D.N.I: ${paciente.dni}</p>
<p>Nombre: ${paciente.nombre}</p>
<p>Apellido 1: ${paciente.apellido1}</p>
<p>Apellido 2: ${paciente.apellido2}</p>
<p>Fecha de Nacimiento: ${paciente.nacimiento}</p>
<p>Domicilio: ${paciente.domicilio}</p>
<p>Teléfono 1: ${paciente.tfno1}</p>
<p>Teléfono 2: ${paciente.tfno2}</p>
<p>Email: ${paciente.mail}</p>
<a href="ResetPassword.jsp"> Cambiar contraseña</a>
<a href="ModificarPacienteSec.jsp">Modificar Perfil</a>
	</div>
				<div class="col-md-6 citas">
					<h2>Ver historial citas</h2>

					<table class="tablaCitas table table-stripped table-bordered">
						<tr>
			<th>Fecha</th>
			<th>Hora de Inicio</th>
		<!-- 	<th>Hora de Fin</th> -->
		<!--	<th>Paciente</th>-->
			<th>Médico</th>
		<!--	<th>Estado</th>-->
			<th>Comentarios</th>
		<!--	<th>Acción</th>-->
		</tr>

		<c:forEach items="${cita_list}" var="citai">
			<tr>
				<td>
				<fmt:formatDate pattern = "dd-MM-yyyy" value ="${citai.fechaCita }"/>
				</td>
				<td>${citai.horaInicio}</td>
			<!-- 	<td>${citai.horaFinal}</td> -->
			<!--	<td>${citai.paciente.nombre} ${citai.paciente.apellido1} ${citai.paciente.apellido2}</td>-->
				<td>${citai.medico.nombre} ${citai.medico.apellido1}</td>
			<!-- 	<td>${citai.status}</td> -->
				<td>${citai.comentarios}</td>
			<!--	<td>
				<c:if test="${citai.status} == 1">
				<button type="submit">Modificar Cita</button>
				</c:if>
				</td>-->
			</tr>
		</c:forEach>
	</table>
</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<%@ include file="FormLogout.jsp"%>
				</div>
			</div>
		</div>
	</div>
<%@ include file="Footer.jsp"%>
</body>
</html>
