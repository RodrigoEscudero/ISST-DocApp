<%@ include file="Head.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>

	<%@ include file="NavbarPaciente.jsp"%>
	<div class="cuerpo">
		<div class="container">
			<div class="row">
				<div class="col-md-12 titulo">
					<h1>Lista de Citas</h1>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 datos">
					<table class="tablaCitas table table-stripped table-bordered">
						<tr>
							<th>ID</th>
							<th>Fecha</th>
							<th>Hora</th>
							<!--<th>Hora de Fin</th>-->
							<th>Paciente</th>
							<th>Médico</th>
							<th>Comentarios</th>
							<th>Acciones</th>
						</tr>

						<c:forEach items="${citaL}" var="cital">
							<tr>
								<td>${cital.id}</td>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
										value="${cital.fechaCita }" /></td>
								<td>${cital.horaInicio}</td>
								<!-- <td>${cital.horaFinal}</td> -->
								<td>${cital.paciente.nombre}${citai.paciente.apellido1}
									${citai.paciente.apellido2}</td>
								<td>${cital.medico.nombre}${citai.medico.apellido1}</td>
								<td>${cital.comentarios}</td>
								<td><c:if test="${cital.status == 1}">
										<form action="InterconsultaServlet">
											<input type="hidden" name="paciente_dni"
												value="${cital.paciente.dni}" readonly /> <select
												name="especialidad">
												<option value="${especialidad}" disabled selected></option>
												<c:forEach items="${especialidad}" var="especialidadesi">
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
											<button class="btn btn-primary" type="submit">Interconsulta</button>
										</form>
										<form action="FinCitaServlet">
											<input type="hidden" name="citaK" value="${cital.id}"
												readonly />
											<button class="btn btn-primary" type="submit">Fin
												cita</button>
										</form>
										<form action="UrgenciaServlet">
											<input type="hidden" name="citaU" value="${cital.id}"
												readonly /> <select name="pacientes">
												<option value="${pacientes}" disabled selected></option>
												<c:forEach items="${pacientes}" var="pacientesi">
													<option value=${ pacientesi.dni} selected>${pacientesi.dni}</option>
												</c:forEach>
											</select>
											<button class="btn btn-primary" type="submit">Urgencias</button>
										</form>
									</c:if></td>
							</tr>
						</c:forEach>
					</table>
					<%@ include file="FormLogout.jsp"%>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>
