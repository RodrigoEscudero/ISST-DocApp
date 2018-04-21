<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solicitar Cita</title>
</head>
<body>
	<h2>Solicitar Cita</h2>
			
	<p>Especialidad Seleccionada: ${especialidad}</p>
<form action="SolicitarCitaPacienteServlet">
	<input type="text" name="paciente_dni" value="${paciente.dni}" readonly /> 
	<select
		name="especialidad">
		<option value="${especialidad}" disabled selected></option>
		<c:forEach items="${especialidades}" var="especialidadesi">
			<option value=${ especialidadesi}>${especialidadesi}</option>
		</c:forEach>
	</select>
	<button type="submit">Elegir</button>

</form>

<form action="SolicitarCitaPacienteServlet">
	<input type="text" name="paciente_dni" value="${paciente.dni}" readonly />
	<input type="text" name="especialidad" value="${especialidad}" readonly />
	
	 <select
		name="medico_elegido">
		<option value="" disabled selected></option>
		<c:forEach items="${list_medicos}" var="medicoi">
			<option value=${ medicoi.id}>${medicoi.nombre}
				${medicoi.apellido1} ${medicoi.apellido2}</option>
		</c:forEach>
	</select>
	<button type="submit">Elegir</button>
</form>

<h3>Citas pendientes</h3>
<table border="1">
	<tr>
		<th>Paciente</th>
		<th>Medico</th>
		<th>Especialidad</th>
		<th>Comentarios</th>
	</tr>

	<c:if test="${cita_list != null }">
		<c:forEach items="${cita_list }" var="citai">
			<tr>
				<td>${citai.paciente.nombre }</td>
				<td>${citai.medico.nombre }</td>
				<td>${citai.especialidad }</td>
				<td>${citai.comentarios }</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<%@ include file = "FormLogout.jsp" %>	
</body>
</html>