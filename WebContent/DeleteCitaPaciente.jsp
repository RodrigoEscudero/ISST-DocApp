<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Cita</title>
</head>
<body>
	<h2>Modificar Cita</h2>

<table border="1">
	<tr>
		<th>Paciente</th>
		<th>Medico</th>
		<th>Especialidad</th>
		<th>Comentarios</th>
		<th>Acciones</th>
	</tr>

	<c:if test="${cita_list != null }">
		<c:forEach items="${cita_list }" var="citai">
			<tr>
				<td>${citai.paciente.nombre }</td>
				<td>${citai.medico.nombre }</td>
				<td>${citai.especialidad }</td>
				<td>${citai.comentarios }</td>
				<td>
				<form action="DeleteCitaPacienteServlet">
				<input type="text" name="citaA_borrar" value="${citai.id}" readonly>
				<input type="text" name="paciente_dni" value="${citai.paciente.dni}" readonly>
				<button>Delete</button>
				</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<%@ include file = "FormLogout.jsp" %>	
</body>
</html>