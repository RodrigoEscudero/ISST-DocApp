<%@ include file="Head.jsp"%>

<body>

	<%@ include file="NavbarPaciente.jsp"%>
	<div class="cuerpo">
	<div class="container">
		<div class="row">
			<div class="col-md-12 titulo center">
				<h1>Datos del paciente</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 datos">
				<%@ include file="FormVerPaciente.jsp"%>
			</div>
		</div>
	</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>
