<form action="ModificarMedServlet">
<h2>Modificar los datos</h2>
<input type="hidden" value="${medico.id}" name="med_id"/>
Nombre: ${medico.nombre}<br>
Primer Apellido: ${medico.apellido1}<br>
Segundo Apellido: ${medico.apellido2}<br>
Identificador : ${medico.id}<br>
Especialidad: <input type="text" name ="especialidad" placeholder="${medico.especialidad}"/><br>
Consulta: <input type="text" name="lugar" placeholder="${medico.lugar}"/><br>
Tel�fono: <input type="text" name="telefono" placeholder="${medico.tfno}"/><br>
Email: <input type="text" name="email" placeholder="${medico.mail}"/> <br>
Contrase�a: <input type="password" name="password" placeholder="${medico.password}"/><br>

<button type="submit">Actualizar Informaci�n</button>

</form>
