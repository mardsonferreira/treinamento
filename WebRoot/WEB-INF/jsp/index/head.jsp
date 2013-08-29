<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script src="/produtos/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/produtos/js/puts.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.mask.min.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="/produtos/css/layout.css">
<link rel="stylesheet" type="text/css"
	href="/produtos/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/produtos/css/font-awesome.min.css">




<script src="/produtos/js/script.js" type="text/javascript"></script>

</head>

<body>

	<div id="centro">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="#">Produtos</a>
				<ul class="nav">
					<li><a href='<c:url value="/produtos/new"/>'>Novo Produto</a>
					</li>
					<li><a href='<c:url value="/produtos"/>'>Listar Produtos</a></li>
					<li id="find"><input id="busca" class="inp_busca" name="nome" />

					</li>
				</ul>

				<div id="header">
					<div id="carrinho">
						<h3>Meu carrinho:</h3>
						<c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">
							<span>Voc� n�o possui itens no seu carrinho</span>
						</c:if>
						<c:if test="${carrinho.totalDeItens > 0 }">
							<ul>
								<li><strong>Itens:</strong> ${carrinho.totalDeItens }</li>
								<li><strong>Total:</strong> <fmt:formatNumber
										type="currency" value="${carrinho.total}" />
								</li>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>