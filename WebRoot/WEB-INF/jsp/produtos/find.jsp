<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<script src="/produtos/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/produtos/js/puts.js" type="text/javascript"></script>
<script src="/produtos/js/jquery.mask.min.js" type="text/javascript"></script>



<script src="/produtos/js/script.js" type="text/javascript"></script>


<h3>
	Resultados da busca por <b>"${nome }"</b>
</h3>

<table class="table table-striped">
	<tr>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Preço</th>
		<th>Quantidade</th>
		<th>Comprar</th>
		<c:if test="${usuarioWeb.logado}">
			<th>Ações</th>
		</c:if>
	</tr>
	<c:forEach items="${produtos}" var="produto">
		<tr id="produto-${produto.id}">
			<td>${produto.nome}</td>
			<td>${produto.descricao}</td>
			<td>${produto.preco}</td>

			<td>
				<form action="<c:url value="/carrinho"/>" method="POST">
					<input type="hidden" name="item.produto.id" value="${produto.id }" />
					<input class="qtde" name="item.quantidade" value="1" />
					<button type="submit" class="btn">Comprar</button>
				</form>
			</td>
			<c:if test="${usuarioWeb.logado}">
				<td><a class="link"
					href='<c:url value="/produtos/edit/${produto.id}"/>'> <i
						class="icon-edit"></i> </a>
					<button class="button remove" id="${produto.id}">
						<i class="icon-trash button"></i>
					</button>
				</td>
			</c:if>
		</tr>

	</c:forEach>
</table>



