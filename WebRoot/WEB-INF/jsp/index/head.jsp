<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script src="/produtos/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.mask.min.js" type="text/javascript"></script>

<script src="/produtos/js/bootstrap-fileupload.js" type="text/javascript"></script>
<script src="/produtos/js/bootstrap-fileupload.min.js" type="text/javascript"></script>
<script src="/produtos/js/bootstrap.js" type="text/javascript"></script>
<script src="/produtos/js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="/produtos/css/bootstrap-fileupload.css">
<link rel="stylesheet" type="text/css" href="/produtos/css/bootstrap-fileupload.min.css">
<link rel="stylesheet" type="text/css" href="/produtos/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/produtos/css/bootstrap.css">


<link rel="stylesheet" type="text/css" href="/produtos/css/layout.css">
<link rel="stylesheet" type="text/css" href="/produtos/css/font-awesome.min.css">




<script src="/produtos/js/script.js" type="text/javascript"></script>

</head>

<body>

	<div id="centro">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="#">Produtos</a>
				<ul class="nav">
					<c:if test="${usuarioWeb.logado}">
						<li><a href='<c:url value="/produtos/new"/>'>Novo Produto</a>
						</li>
					</c:if>
					<li><a href='<c:url value="/produtos"/>'>Listar Produtos</a>
					</li>
					<li id="find"><input id="busca" class="inp_busca" placeHolder="Buscar por Nome" name="nome" />

					</li>
				</ul>
				<div id="usuario">
					<c:if test="${usuarioWeb.logado}">
							Olá, ${usuarioWeb.nome }!
							<a href="<c:url value="/usuarios/logout"/>">Logout</a>
					</c:if>
					<c:if test="${empty usuarioWeb or not usuarioWeb.logado}">
					Você não está logado. <a href="<c:url value="/usuarios/login"/>">Login</a>
						<a href="<c:url value="/usuarios/new"/>"> Cadastre-se </a>
					</c:if>

				</div>
				<div id="header">
					<div id="carrinho">
						<h3 class="car_h3">
							<a href="<c:url value="/carrinho"/>">Meu carrinho:</a>
						</h3>
						<c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">
							<span>Você não possui itens no seu carrinho</span>
						</c:if>
						<c:if test="${carrinho.totalDeItens > 0 }">
							<ul class="car_ul">
								<li><strong>Itens:</strong> ${carrinho.totalDeItens }</li>
								<li><strong>Total:</strong> <fmt:formatNumber
										type="currency" value="${carrinho.total}" /></li>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>