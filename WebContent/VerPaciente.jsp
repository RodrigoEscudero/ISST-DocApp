<form action="VerPacienteServlet">
<h3>MODIFICAR LOS DATOS</h3>
<input type="hidden" value="${paciente.dni}" name="pac_dni"/>
Nombre: ${paciente.nombre}<br>
Primer Apellido: ${paciente.apellido1}<br>
Segundo Apellido: ${paciente.apellido2}<br>
Fecha de Nacimiento: ${paciente.nacimiento}<br>
D.N.I. : ${paciente.dni}<br>
Domicilio: ${paciente.domicilio}<br>
Teléfono 1: ${paciente.tfno1}<br>
Teléfono 2: ${paciente.tfno2}<br>
Email: ${paciente.mail} <br>

</form>