<form action="ModificarPacServlet">
<h3>MODIFICAR LOS DATOS</h3>
<input type="hidden" value="${paciente.dni}" name="pac_dni"/>
Nombre: ${paciente.nombre}<br>
Primer Apellido: ${paciente.apellido1}<br>
Segundo Apellido: ${paciente.apellido2}<br>
Fecha de Nacimiento: ${paciente.nacimiento}<br>
D.N.I. : ${paciente.dni}<br>
Domicilio: <input type="text" name="domicilio" placeholder="${paciente.domicilio}"/><br>
Teléfono 1: <input type="text" name="telefono1" placeholder="${paciente.tfno1}"/><br>
Teléfono 2: <input type="text" name="telefono2" placeholder="${paciente.tfno2}"/><br>
Email: <input type="text" name="email" placeholder="${paciente.mail}"/> <br>
Contraseña: <input type="password" name="password" placeholder="${paciente.password}"/><br>

<button type="submit">Actualizar Información</button>

</form>