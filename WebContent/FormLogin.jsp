<%@ include file="Head.jsp"%>
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">
	<!--banner-->
	<section id="banner" class="banner">
		<div class="bg-color">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="col-md-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img src="img/new-logo.png"
								class="img-responsive" style="width: 140px; margin-top: -16px;"></a>
						</div>
						<div class="collapse navbar-collapse navbar-right" id="myNavbar">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#banner">Inicio</a></li>
								<li class=""><a href="#login">Login</a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="banner-info">
						<div class="banner-logo text-center">
							<img src="img/new-logo.png" class="img-responsive">
						</div>
						<div class="banner-text text-center">
							<h1 class="white">BIENVENIDO A DOCAPP</h1>
							<p>La nueva forma de gestionar todas tus citas médicas,</p>
							<a href="#login" class="btn btn-appoint">Acceder</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ banner-->
	<!--service-->
	<section id="login" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4">

					<h2 class="ser-title">Iniciar Sesión</h2>
					<form action="LoginServlet">
						<div class="form-group">
							<input type="text" name="email" placeholder="email" /> <input
								type="password" name="password" placeholder="password" />
						</div>
						<button type="submit">Login</button>
						<a href="ResetPassword.jsp"> ¿Olvidó la
							contraseña?</a>

						<h3>¿Aún no tienes cuenta?</h3>
						<a href="FormRegistroServlet">Regístrate</a>
					</form>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-stethoscope"></i>
						</div>
						<div class="icon-info">
							<h3>Atención médica 24 horas</h3>
							<p>El hospital dispone de personal médico a su disposición 24
								horas diarias</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-ambulance"></i>
						</div>
						<div class="icon-info">
							<h3>Servicios de emergencia</h3>
							<p>Nuestro servicio de atención médica en caso de emergencia
								es de los mejores valorados por la Asociación de Médicos.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-user-md"></i>
						</div>
						<div class="icon-info">
							<h3>Atención médica personalizada</h3>
							<p>Registros personalizados con información y tratamientos
								exclusivos a cada paciente.</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-medkit"></i>
						</div>
						<div class="icon-info">
							<h3>
								Cuidados médicos de calidad
								</h4>
								<p>Contamos con los mejores médicos en su especialidad.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ service-->
	<%@ include file="Footer.jsp"%>
</body>
</html>