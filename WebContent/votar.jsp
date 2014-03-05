<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Votar</title>
</head>
<body>
	<h1>Votaciones</h1>
	<h2>Votar</h2>
	<c:set var="bean" scope="request" value="${votarB}" />
	<form action="votar" method="post">
		<input type="hidden" name="action" value="votar" />
		<c:if test="${bean.hasErrors()}">
			<p>Errores: ${bean.errors}</p>
		</c:if>
		<p>Pregunta: ${bean.pregunta}</p>
		<p>
			Elige tu respuesta: <select name="respuesta" size="1">
				<c:forEach var="xxx" items="${bean.respuestas}">
					<option value="${xxx}">${xxx}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Votar" />
		</p>
	</form>
	<p>
		<a href="?action=home">Home</a>
	</p>
</body>
</html>