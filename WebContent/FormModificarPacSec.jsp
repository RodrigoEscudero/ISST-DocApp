<form action="ModificarSecServlet">
		<select name="paciente_modificado">
			<option value="" disabled selected></option>
				<c:forEach items="${paciente_list}" var="pacientei">
					<option value=${ pacientei.dni}>${pacientei.nombre} ${pacientei.apellido1} ${pacientei.apellido2 }</option>
				</c:forEach>
		</select>
		<button type="submit">Modificar</button>
</form>