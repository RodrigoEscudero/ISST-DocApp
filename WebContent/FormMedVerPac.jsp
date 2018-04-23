<form action="VerPacServlet">
		<select name="paciente_elegido">
			<option value="" disabled selected></option>
				<c:forEach items="${cita_list}" var="citai">
					<option value=${ citai.paciente.dni}>${citai.paciente.nombre} ${citai.paciente.apellido1} ${citai.paciente.apellido2 }</option>
				</c:forEach>
		</select>
		<button type="submit">Ver mis pacientes</button>
</form>