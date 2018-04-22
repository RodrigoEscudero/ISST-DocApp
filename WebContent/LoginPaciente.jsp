<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista Paciente</title>
</head>
<body>
	<h2>Vista Paciente</h2>
<%@ include file = "NavbarPaciente.jsp" %>
<%@ include file = "FormLogout.jsp" %>

<h3>INFORMACIÓN</h3>
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
	
	<h3>Solicitar Cita</h3>
	<h3>Ver historial citas</h3>
	
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