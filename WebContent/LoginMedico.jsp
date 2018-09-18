<%@ include file="Head.jsp" %>
<body>
	<%@ include file="NavbarPaciente.jsp"%>
	<div class="cuerpo">
		<div class="container">
			<div class="row">
				<div class="col-md-12 titulo">
					<h1> Médico ${medico.nombre}</h1>
				</div>
			</div>
		</div>
<div class="container">
			<div class="row">
				<div class="col-md-6 datos">
					<h2>INFORMACIÓN</h2>
					<p>Identificador: ${medico.id}</p>
					<p>Nombre: ${medico.nombre}</p>
					<p>Apellido 1: ${medico.apellido1}</p>
					<p>Apellido 2: ${medico.apellido2}</p>
					<p>Especialidad: ${medico.especialidad}</p>
					<p>Consulta Asignada: ${medico.lugar}</p>
					<p>Teléfono: ${medico.tfno}</p>
					<p>Email: ${medico.mail}</p>
					<a href="ResetPasswordMedico.jsp"> Cambiar contraseña</a>
				</div>

<div class="col-md-4 datos" id="agenda">
					<h2>Agenda del día</h2>
<form action="AgendaDiaServlet">
<input type="hidden" name="medico" value="${medico.id}" readonly>
<button class="btn btn-primary">Consultar agenda del dia</button>
					</form>
				</div>
			</div>
<div class="row">
<div class="col-md-12 citas">
					<h2>Ver Perfil de Paciente</h2>
					<p>Elija el Paciente</p>
					<%-- 	<%@ include file = "FormVerPac.jsp" %>
 --%><%@ include file="FormMedVerPac.jsp"%>
	
	<h3>Lista de Citas</h3>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Fecha</th>
			<th>Hora de Inicio</th>
			<th>Hora de Fin</th>
			<th>Paciente</th>
			<th>Médico</th>
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
				<td>${citai.comentarios}</td>
				<td>
			<!--	<c:if test="${citai.status} == 1">
				<button type="submit">Modificar Cita</button>
				</c:if> -->
				
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
