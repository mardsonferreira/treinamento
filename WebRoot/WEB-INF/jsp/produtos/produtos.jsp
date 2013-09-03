<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='../index/head.jsp' />

<div id="content">
	<table class="table table-striped">
		<tr>
			<th>Foto</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Comprar</th>
			<c:if test="${usuarioWeb.logado}">
				<th>Ações</th>
			</c:if>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr id="produto-${produto.id}">
				<td><img src="<c:url value="/produtos/${produto.id}/image"/>"
					width="80" height="80" /></td>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>

				<td>
					<form action="<c:url value="/carrinho"/>" method="POST">
						<input type="hidden" name="item.produto.id" value="${produto.id }" />
						<input class="qtde" name="item.quantidade" value="1" />

						<button type="submit" class="btn">Comprar</button>
					</form></td>
				<c:if test="${usuarioWeb.logado}">
					<td><a class="link"
						href='<c:url value="/produtos/edit/${produto.id}"/>'> <i
							class="icon-edit"></i> </a>
						<button class="button remove" id="${produto.id}">
							<i class="icon-trash button"></i>
						</button></td>
				</c:if>
			</tr>

		</c:forEach>
	</table>
</div>
</div>
</body>
</html>
