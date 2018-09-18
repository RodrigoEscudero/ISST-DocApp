<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DocApp</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<!-- Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
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
					<h1>Solicitar Cita</h1>
					<p>${comova}</p>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 cita">
					<!-- 	<p>Especialidad Seleccionada: ${especialidad}</p>-->
					<form action="SolicitarCitaPacienteServlet">
						<input type="hidden" name="paciente_dni" value="${paciente.dni}"
							readonly /> <input type="hidden" name="estado" value="1"
							readonly /> <select name="especialidad">
							<option value="${especialidad}" disabled selected></option>
							<c:forEach items="${especialidades}" var="especialidadesi">
								<c:choose>
									<c:when test="${especialidadesi == especialidad}">
										<option value=${ especialidadesi} selected>${especialidadesi}</option>
									</c:when>
									<c:otherwise>
										<option value=${ especialidadesi}>${especialidadesi}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
						<button class="btn btn-primary"type="submit">Elegir</button>
					</form>

				</div>
			</div>
		</div>


		<div class="container">
			<div class="row">
				<div class="col-md-12 cita">
					<form action="SolicitarCitaPacienteServlet">
						<input type="hidden" name="paciente_dni" value="${paciente.dni}"
							readonly /> <input type="hidden" name="especialidad"
							value="${especialidad}" readonly /> <input type="hidden"
							name="estado" value="2" readonly /> <select
							name="medico_elegido">
							<option value="" disabled selected></option>
							<c:forEach items="${list_medicos}" var="medicoi">
								<c:choose>
									<c:when test="${medicoi.nombre == mimed}">
										<option value=${ medicoi.id} selected>${medicoi.nombre}${medicoi.apellido1}
											${medicoi.apellido2}</option>
									</c:when>
									<c:otherwise>
										<option value=${ medicoi.id}>${medicoi.nombre}${medicoi.apellido1}
											${medicoi.apellido2}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
						<%@ include file="DatePicker.jsp"%>

						<button class="btn btn-primary"type="submit">Ver horas disponibles</button>
					</form>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-12	 cita">
					<form action="SolicitarCitaPacienteServlet">
						<input type="hidden" name="paciente_dni" value="${paciente.dni}"
							readonly /> <input type="hidden" name="especialidad"
							value="${especialidad}" readonly /> <input type="hidden"
							name="medico_elegido" value="${medico_elegido.id}" readonly /> <input
							type="hidden" name="estado" value="3" readonly /> <input
							type="hidden" name="diaCita" value="${diaCita}" readonly /> <input
							type="text" name="comentarios" placeholder="Inserte comentario" />

						<select name="h_elegida">
							<c:forEach items="${h_elegida}" var="conjunto">
								<option value="${conjunto}">${conjunto}</option>
							</c:forEach>
						</select>
						<button class="btn btn-primary" type="submit">Solicitar cita</button>

					</form>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<h2>Horas Disponibles</h2>
			</div>
			<div class="row">
				<div class="col-md-3 datos scroll">

					<table class="tablaCitas table table-stripped table-bordered">
						<tr>
							<th><fmt:formatDate pattern="dd-MM-yyyy" value="${Dia2}" />
							</th>
						</tr>
						<c:forEach items="${horas_2}" var="horai">
							<tr>
								<td>${horai}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-md-3 datos scroll">
					<table class="tablaCitas table table-stripped table-bordered">
						<tr>
							<th><fmt:formatDate pattern="dd-MM-yyyy" value="${Dia3}" /></th>
						</tr>
						<c:forEach items="${horas_3}" var="horaj">
							<tr>
								<td>${horaj}</td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-6 datos">
					<h2>Citas pendientes</h2>
					<table class="tablaCitas table table-stripped table-bordered">
						<tr>
							<th>Fecha</th>
							<th>Hora</th>
							<th>Paciente</th>
							<th>Medico</th>
							<th>Especialidad</th>
							<th>Comentarios</th>
						</tr>

						<c:if test="${cita_list != null }">
							<c:forEach items="${cita_list}" var="citai">
								<tr>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${citai.fechaCita}" /></td>
									<td>${citai.horaInicio}</td>
									<td>${citai.paciente.nombre }</td>
									<td>${citai.medico.nombre }</td>
									<td>${citai.especialidad }</td>
									<td>${citai.comentarios }</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="atrasPaciente.jsp"%>
	</div>
</body>
<%@ include file="Footer.jsp"%>
</html>
