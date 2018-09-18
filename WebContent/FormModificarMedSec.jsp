<form action="ModificarSecServlet">
		<select name="medico_modificado">
			<option value="" disabled selected></option>
				<c:forEach items="${medico_list}" var="medicoi">
					<option value=${ medicoi.id}>${medicoi.nombre} ${medicoi.apellido1} ${medicoi.apellido2 }</option>
				</c:forEach>
		</select>
		<button  class="btn btn-primary" type="submit">Modificar</button>
</form>
