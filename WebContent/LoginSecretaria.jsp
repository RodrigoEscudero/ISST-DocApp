<%@ include  file="Head.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
	<%@ include file="NavbarPaciente.jsp"%>

	<div class="cuerpo">

	<div class="container">
		<div class="row">
			<div class="col-md-12 titulo">
				<h1>Secretaría</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-12 citas">
						<h2>Modificar Perfil de Paciente</h2>
						<p>Elija el Paciente a modificar</p>
						<%@ include file="FormModificarPacSec.jsp"%>
					</div>
				</div>
		<div class="row">
					<div class="col-md-12 citas">
						<h2>Modificar Perfil de Médico</h2>
						<p>Elija el Médico a modificar</p>
						<%@ include file="FormModificarMedSec.jsp"%>
						<h3>
							<a href="FormMedicoServlet">Dar de alta personal Médico</a>
						</h3>
					</div>
				</div>
			</div>
	
	<div class="col-md-6 citas">
				<h2>LISTADO DE CONSULTAS</h2>
				<table class="tablaCitas table table-stripped table-bordered">
		<tr>
			<th>ID</th>
			<th>Fecha</th>
			<th>Hora de Inicio</th>
			<th>Hora de Fin</th>
			<th>Paciente</th>
			<th>Médico</th>
			<th>Estado</th>
			<th>Acción</th>
		</tr>

		<c:forEach items="${cita_list}" var="citai">
			<tr>
				<td>${citai.id}</td>
				<td><fmt:formatDate pattern = "dd-MM-yyyy" value ="${citai.fechaCita }"/>
				</td>
				<td>${citai.horaInicio}</td>
				<td>${citai.horaFinal}</td>
				<td>${citai.paciente.nombre} ${citai.paciente.apellido1} ${citai.paciente.apellido2}</td>
				<td>${citai.medico.nombre} ${citai.medico.apellido1}</td>
				<td>${citai.status}</td>
				<td>
				<form action="ConfirmaLlegadaServlet">
				<input type="hidden" name="cita" value="${citai.id}" readonly />
				<button class="btn btn-primary" type="submit">Confirmar llegada</button>
				</form>
				</td>	
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
