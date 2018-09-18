<form action="VerPacServlet">
		<select name="paciente_elegido">
			<option value="" disabled selected></option>
				<c:forEach items="${paciente_list}" var="pacientei">
					<option value=${ pacientei.dni}>${pacientei.nombre} ${pacientei.apellido1} ${pacientei.apellido2 }</option>
				</c:forEach>
		</select>
		<button class="btn btn-primary" type="submit">Ver</button>
</form>
