<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Cadastro Usuários</title>
	<link rel="stylesheet" href="">
</head>
<body>
	<h1>Adicionar Usuários</h1>
	<form action="<c:url value='/usuario/adiciona'/>" method="POST">
		Nome de Usuário: <input type="text" name="usuario.usuario"/><br>
		Senha: <input type="password" name="usuario.senha"/><br>
		Nome completo: <input type="text" name="usuario.nome"/><br>
		E-mail: <input type="text" name="usuario.email"/><br>
		<input type="submit" value="Adicionar"/>
	</form>
	
		<c:if test="${not empty errors }">
		<div>
			<c:forEach items="${errors }" var="erro">
				${erro.category } - ${erro.message }<br/>
			</c:forEach>
		</div>
	</c:if>

</body>
</html>