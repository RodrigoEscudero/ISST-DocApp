<%@ include file="Head.jsp"%>
<body>
<%@ include file="NavbarPaciente.jsp"%>	
<div class="cuerpo">
	<div class="container">
		<div class="row">
			<div class="col-md-12 titulo">
				<h1>Modificar Datos</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 datos">
				<form action="ModificarPacServlet">

					<input type="hidden" value="${paciente.dni}" name="pac_dni" />
					Nombre: ${paciente.nombre}<br> Primer Apellido:
					${paciente.apellido1}<br> Segundo Apellido:
					${paciente.apellido2}<br> Fecha de Nacimiento:
					${paciente.nacimiento}<br> D.N.I. : ${paciente.dni}<br>
					Domicilio: <input type="text" name="domicilio"
						placeholder="${paciente.domicilio}" /><br> Teléfono 1: <input
						type="text" name="telefono1" placeholder="${paciente.tfno1}" /><br>
					Teléfono 2: <input type="text" name="telefono2"
						placeholder="${paciente.tfno2}" /><br> Email: <input
						type="text" name="email" placeholder="${paciente.mail}" /> <br>
					Contraseña: <input type="password" name="password"
						placeholder="${paciente.password}" /><br>

					<button class="btn btn-primary" type="submit">Actualizar
						Información</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>

