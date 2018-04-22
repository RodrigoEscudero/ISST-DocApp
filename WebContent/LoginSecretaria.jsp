<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista Secretaria</title>
</head>
<body>
	<h2>Vista Secretaria</h2>
<%@ include file = "FormLogout.jsp" %>

	<h3>Solicitar Cita</h3>
	
	<h3>  Modificar Perfil de Paciente</h3>
	<p>Elija el Paciente a modificar</p>
	<%@ include file = "FormModificarPacSec.jsp" %>
	<h3>  Modificar Perfil de Médico</h3>
	<p>Elija el Médico a modificar</p>
	<%@ include file = "FormModificarMedSec.jsp" %>
	
	<h3><a href="FormMedicoServlet" >Dar de alta personal Médico</a></h3>
	<h3>LISTADO DE CONSULTAS</h3>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Fecha</th>
			<th>Hora de Inicio</th>
			<th>Hora de Fin</th>
			<th>Paciente</th>
			<th>Médico</th>
			<th>Estado</th>
			<th>Comentarios</th>
			<th>Acción</th>
		</tr>

		<c:forEach items="${cita_list}" var="citai">
			<tr>
				<td>${citai.id}</td>
				<td>${citai.fechaCita}</td>
				<td>${citai.horaInicio}</td>
				<td>${citai.horaFinal}</td>
				<td>${citai.paciente.nombre} ${citai.paciente.apellido1} ${citai.paciente.apellido2}</td>
				<td>${citai.medico.nombre} ${citai.medico.apellido1}</td>
				<td>${citai.status}</td>
				<td>${citai.comentarios}</td>
				<td>
				<c:if test="${citai.status} == 1">
				<button type="submit">Modificar Cita</button>
				</c:if>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>