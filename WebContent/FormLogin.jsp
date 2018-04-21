<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DocApp Login</title>
</head>
<body>
<h2>BIENVENIDO A DOCAPP</h2>
<h3>Iniciar Sesión</h3>
<form action="LoginServlet">
	<input type="text" name="email" placeholder="email"/>
	<input type="password" name="password" placeholder="password"/>
	<button type ="submit">Login</button>
	<a href="ResetPassword.jsp"> ¿Olvidó la contraseña?</a>
</form>
<h3>¿Aún no tienes cuenta?</h3>
<a href="FormRegistroServlet" >Regístrate</a>	
</body>

</html>