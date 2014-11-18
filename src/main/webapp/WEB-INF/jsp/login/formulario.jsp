<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!-- <html lang="pt-br"> -->
<head>
<meta charset="utf-8">
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!--     <meta name="description" content=""> -->
<!--     <meta name="author" content="Dashboard"> -->
<!--     <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina"> -->

<title>BFar - Farmácia Básica</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/assets/css/bootstrap.css' />"
	rel="stylesheet" type="text/css" />
<!--external css-->
<link href="<c:url value='/assets/font-awesome/css/font-awesome.css' />"
	rel="stylesheet" type="text/css" />

<!-- Custom styles for this template -->
<link href="<c:url value='/assets/css/style.css' />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/assets/css/style-responsive.css' />"
	rel="stylesheet" type="text/css" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<div id="login-page">
		<div class="container">

			<form class="form-login" action="<c:url value='/login/autentica'/>"
				method="post">
				<h2 class="form-login-heading">Forneça suas credencias</h2>
				<div class="login-wrap">
					<input type="text" class="form-control" placeholder="Usuário"
						name="usuario.usuario" autofocus> <br> <input
						type="password" class="form-control" name="usuario.senha"
						placeholder="Senha"> <label class="checkbox"> <span
						class="pull-right"> <a data-toggle="modal"
							href="login.html#myModal"> Perdeu a senha?</a>

					</span>
					</label>
					<button class="btn btn-theme btn-block" href="index.html"
						type="submit">
						<i class="fa fa-lock"></i> LOGIN
					</button>
					
					<c:if test="${not empty errors }">
						<hr>
						<div class="alert alert-danger">
							<c:forEach items="${errors }" var="erro">
								${erro.category } - ${erro.message }<br />
							</c:forEach>
						</div>
					</c:if>
			</form>

		</div>
	</div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src=<c:url value="/assets/js/jquery.js" />></script>
	<script type="text/javascript"
		src=<c:url value="/assets/js/bootstrap.min.js" />></script>

	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript"
		src=<c:url value="/assets/js/jquery.backstretch.min.js" />></script>
	<script>
		$.backstretch("/farmacia-basica/assets/img/login-bg.jpg", {
			speed : 500
		});
	</script>


</body>
</html>