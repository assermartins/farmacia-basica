<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Lista Usuários</title>
<link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap-responsive.min.css'/>">

<script src="<c:url value='/bootstrap/js/jquery-1.7.1.min.js'/>"></script>
<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- <script type="text/javascript">
// 	var escolhidos = [];
// 	$(function() {
// 		$("#BtnEscolhidos").on('click', function() {
// 			var checks = $('#tabelaUsuarios input[type=checkbox]:checked');
// 			escolhidos = [];
// 			$.each(checks, function(index, objeto) {
// 				escolhidos.push(objeto.value);
// 			})
// 			console.log(escolhidos);
// 		});
// 	});
	
// 	$(document).ready(function(){
// 		$('#tabelaUsuarios').dataTable();
// 	});
</script> -->

<script type="text/javascript">
	$(document).ready(function() {
		$("a[rel=modal]").click(function(ev) {
			ev.preventDefault();

			var id = $(this).attr("href");

			var alturaTela = $(document).height();
			var larguraTela = $(window).width();

			//colocando o fundo preto
			$('#mascara').css({
				'width' : larguraTela,
				'height' : alturaTela
			});
			$('#mascara').fadeIn(1000);
			$('#mascara').fadeTo("slow", 0.8);

			var left = ($(window).width() / 2) - ($(id).width() / 2);
			var top = ($(window).height() / 2) - ($(id).height() / 2);

			$(id).css({
				'top' : top,
				'left' : left
			});
			$(id).show();
		});

		$("#mascara").click(function() {
			$(this).hide();
			$(".window").hide();
		});

		$('.fechar').click(function(ev) {
			ev.preventDefault();
			$("#mascara").hide();
			$(".window").hide();
		});
	});
</script>

<style type="text/css">
.window {
	display: none;
	width: 300px;
	height: 300px;
	position: absolute;
	left: 0;
	top: 0;
	background: #FFF;
	z-index: 9900;
	padding: 10px;
	border-radius: 10px;
}

#mascara {
	position: absolute;
	left: 0;
	top: 0;
	z-index: 9000;
	background-color: #000;
	display: none;
}

.fechar {
	display: block;
	text-align: right;
}
</style>

</head>
<body>
	<h1>Listagem de Usuários</h1>
	<a class="btn btn-primary btn-small" href="#janela2" rel="modal">Novo Usuário</a>
	<br><br>
	<form action="<c:url value='/usuario/apagaOsSafadosTodos'/>" method="post">
	<table id="tabelaUsuarios" class="table table-bordered table-hover table-condensed" method="POST ">
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
					<td><input type="checkbox" name="usuarios[].id" value="${usuario}"></td> <%-- Tentei usar o usuarios[].id também não deu --%>
					<td>${usuario.usuario }</td>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
					<td><a
						href="<c:url value='/usuario/remove?usuario.pkUsuario=${usuario.pkUsuario }'/>">Apagar</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" value="Apagar"/>
	</form>
	<a class="btn btn-primary btn-small" href="#janela2" rel="modal">Novo Usuário</a>

	<div class="window" id="janela2">
		<a href="#" class="fechar">X Fechar</a>
		<h4>Formulario</h4>
		<form action="<c:url value='/usuario/adiciona'/>" method="POST">
			Nome de Usuário: <input type="text" name="usuario.usuario" /><br>
			Senha: <input type="password" name="usuario.senha" /><br> Nome
			completo: <input type="text" name="usuario.nome" /><br> E-mail:
			<input type="text" name="usuario.email" /><br>
			<input class="btn btn-primary"	type="submit" value="Adicionar" />
		</form>

		<c:if test="${not empty errors }">
			<div>
				<c:forEach items="${errors }" var="erro">
				${erro.category } - ${erro.message }<br />
				</c:forEach>
			</div>
		</c:if>
	</div>
	<div id="mascara"></div>
</body>
</html>