<form action="ModificarMedServlet">
<h3>MODIFICAR LOS DATOS</h3>
<input type="hidden" value="${medico.id}" name="med_id"/>
Nombre: ${medico.nombre}<br>
Primer Apellido: ${medico.apellido1}<br>
Segundo Apellido: ${medico.apellido2}<br>
Identificador : ${medico.id}<br>
Especialidad: <input type="text" name ="especialidad" placeholder="${medico.especialidad}"/><br>
Consulta: <input type="text" name="lugar" placeholder="${medico.lugar}"/><br>
Teléfono: <input type="text" name="telefono" placeholder="${medico.tfno}"/><br>
Email: <input type="text" name="email" placeholder="${medico.mail}"/> <br>
Contraseña: <input type="password" name="password" placeholder="${medico.password}"/><br>

<button type="submit">Actualizar Información</button>

</form>