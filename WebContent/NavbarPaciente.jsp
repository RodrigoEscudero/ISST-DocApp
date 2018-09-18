<!--banner-->
<section  class="banner">

		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img src="img/new-logo.png"
								class="img-responsive" style="width: 140px; margin-top: -5px;"></a>
						</div>
						<div class="collapse navbar-collapse navbar-right" id="myNavbar">
							<ul class="nav navbar-nav">
								<li><a href="FormLogin.jsp#banner">Inicio</a></li>
								<li>
									<form action="SolicitarCitaPacienteServlet">
										<input type="hidden" name="paciente_dni" value="${paciente.dni}" readonly/>
										<input type="hidden" name="estado" value="0" readonly/>
										<button class="btn bt-link navBtn">Solicitar Cita</button>
									</form>
								</li>
								<li>
									<form action="GestionCitaPacienteServlet">
										<input type="hidden" name="paciente_dni" value="${paciente.dni}" readonly/>
										<button class="btn bt-link navBtn">Gestion Cita</button>
									</form>
								</li>
								<li>
									<form action="LogoutServlet">
										<button class="btn bt-link navBtn" type="submit">Salir</button>
									</form>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>
</section>
<!--/ banner-->