<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Ver Votaciones</title>
</head>
<body>
	<h1>Votaciones</h1>
	<h2>Ver Votaciones</h2>
	<c:set var="bean" scope="request" value="${votacionesBean}" />
	<p>Votaciones: ${bean.votaciones}</p>
	
<%-- 	<sql:setDataSource driver="com.mysql.jdbc.Driver" --%>
<%-- 		url="jdbc:mysql://localhost:3306/miw18" user="miw18" password="288287169" /> --%>
<%-- 	<sql:query var="logs">SELECT * FROM Log</sql:query> --%>

	<table border="1px">
			<tr>
				<th>ID.VOTO</th>
				<th>IP CLIENTE</th>
				<th>RESULTADO</th>
			</tr>
		<c:forEach var="row" items="${bean.votaciones.voto}">
			<tr>
				<td><c:out value="${row.idVoto}" /></td>
				<td><c:out value="${row.ipCliente}" /></td>
				<td><c:out value="${row.respVoto}" /></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="?action=home">Home</a></p>
</body>
</html>