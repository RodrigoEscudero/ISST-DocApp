<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DocApp</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">


  <!-- Stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
  <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/DocApps.css">
  
  
  <!-- Scripts -->
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/custom.js"></script>
  <script src="contactform/contactform.js"></script>
  <script>
	function loadDoc() {
  	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
     	hj=this.responseText;
     	var array = hj.split(',');    
     	var hs = document.getElementById("horaselect");
     
     	while (hs.length > 0){
    	 	hs.remove(hs.legth-1);
	     } 
    	 for (x =0;x<array.length;x++){
    		 var option = document.createElement("option");
         	option.text = array[x];
         	hs.add(option,x);
     	}
	    }
  	};
  	dia=document.getElementById("datepicker").value;
  	idm=document.getElementById("miMedico").value;
	
  	xhttp.open("GET", "/DocApp/GetHorasModificar?idMedico="+idm+"&diaCita="+dia, true);
  	xhttp.send();  
	}
	
	function saveCita() {
	
    var form = document.createElement("form");
    form.setAttribute("action", "setHoraFechaCitaPac");

    hora=document.getElementById("horaselect").value;
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "hora");
    hiddenField.setAttribute("value", hora);
    form.appendChild(hiddenField);

    dia=document.getElementById("datepicker").value;
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "fecha");
    hiddenField.setAttribute("value", dia);
    form.appendChild(hiddenField);
    
    id=document.getElementById("idCita").value;
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idCita");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);
    
    pag = "/GestionCitaPaciente.jsp";
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "pag");
    hiddenField.setAttribute("value", pag);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
	}
</script>
  
</head>

<body>
<%@ include file="NavbarPaciente.jsp"%>
	<div class="cuerpo">
		<div class="cuerpo">
			<div class="container">
				<div class="row">
					<div class="col-md-12 titulo">
						<h1>Modificar Cita</h1>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-12 datos">

						<table class="tablaCitas table table-stripped table-bordered">
							<tr>
		<th>Especialidad</th>
		<th>Fecha</th>
		<th>Hora</th>
		<th>Acciones</th>
	</tr>

	<c:if test="${cita_list != null }">
		<c:forEach items="${cita_list }" var="citai">
			<tr>
				<td>${citai.medico.nombre }</td>
				<td>${citai.especialidad }</td>
				
				<td>				
					<fmt:formatDate pattern = "dd-MM-yyyy" value ="${citai.fechaCita }"/>
					<c:if test="${estado.equals('1')}" >
					 <c:if test="${citaA_tratar == citai.id}">
					    <input type="hidden" id="miMedico" name="citaA_borrar" value="${citai.medico.id}" readonly>
					 	<%@ include file = "DatePicker.jsp" %>
					  <button class="btn btn-primary" type="button" onclick="loadDoc()">Cambiar Día</button>
					</c:if>
					</c:if>				
				</td>
				
				<td>
				${citai.horaInicio}
				<c:if test="${estado.equals('1')}">
				<c:choose>
    				<c:when test="${citaA_tratar == citai.id}">
    					<input type="hidden" id="idCita" value="${citai.id}" readonly>
    				    <button class="btn btn-primary" onClick="saveCita()">Cambiar Hora</button>
    					<select id="horaselect" name="horaA_cambiar">
    				</c:when>    
    				<c:otherwise>
        				<select name="horaA_cambiar">
        			</c:otherwise>
        		</c:choose>
					<c:forEach items="${horaA_cambiar}" var="conjunto">
    					<option value="${conjunto}">
        				${conjunto}
    					</option>
  					</c:forEach>
				</select>
				</c:if>
				</td>
				<td>
				<form action="GestionCitaPacienteServlet">
				<input type="hidden" name="citaA_tratar" value="${citai.id}" readonly>
				<input type="hidden" name="paciente_dni" value="${citai.paciente.dni}" readonly>
				<input type = "hidden" name="estado" value="1" readonly>
				<button class="btn btn-primary">Modificar cita</button>
				</form>
<span> </span>
				<form action="DeleteCitaPacienteServlet" style="padding-top:10px">
				<input type="hidden" name="citaA_borrar" value="${citai.id}" readonly>
				<input type="hidden" name="paciente_dni" value="${citai.paciente.dni}" readonly>
<button class="btn btn-primary">Borrar</button>
				</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<%@ include file="atrasPaciente.jsp"%>
						<%@ include file="FormLogout.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</html>
