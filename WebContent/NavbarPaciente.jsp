<nav>
<form action="SolicitarCitaPacienteServlet">
	<input type="text" name="paciente_dni" value="${paciente.dni}" readonly/>
	<button>Solicitar Cita</button>
</form>

<form action="DeleteCitaPacienteServlet">
	<input type="text" name="paciente_dni" value="${paciente.dni}" readonly/>
	<button>Modificar Cita</button>
</form>
</nav>