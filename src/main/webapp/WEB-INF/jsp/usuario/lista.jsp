<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Lista Usuários</title>
<link rel="stylesheet" href="">

<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	var escolhidos = [];
	$(function() {
		$("#BtnEscolhidos").on('click', function() {
			var checks = $('#tabelaUsuarios input[type=checkbox]:checked');
			escolhidos = [];
			$.each(checks, function(index, objeto) {
				escolhidos.push(objeto.value);
			})
			console.log(escolhidos);
		});
	});
</script>

</head>
<body>
	<h1>Listagem de Usuários</h1>
	<table id="tabelaUsuarios">
		<thead>
			<tr>
				<th>Selecionar</th>
				<th>Nome de Usuário</th>
				<th>Nome Completo</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td><input type="checkbox" value="${usuario.pkUsuario}"
						id="box${usuario.pkUsuario}"></td>
					<td>${usuario.usuario }</td>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
					<td><a
						href="<c:url value='/usuario/remove?usuario.pkUsuario=${usuario.pkUsuario }'/>">Apagar
							Usuário</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="BtnEscolhidos" type="button" value="">Escolhidos</button>

</body>
</html>