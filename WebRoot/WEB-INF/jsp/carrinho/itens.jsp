<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page='../index/head.jsp' />

<div id="content">


	<h3>Itens do seu carrinho de compras</h3>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Qtde</th>
				<th>Total</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
				<tr>
					<td>${item.produto.nome }</td>
					<td>${item.produto.descricao }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.produto.preco }" />
					</td>
					<td>${item.quantidade }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.quantidade * item.produto.preco }" />
					</td>
					<td>
						<form action="<c:url value="/carrinho/${s.index}"/>" method="POST">
							<button class="button" name="_method" value="DELETE">
								<i class="icon-trash button"></i>	
							</button>	
						</form>
						</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"></td>
				<th colspan="1">Total:</th>
				<th><fmt:formatNumber type="currency"
						value="${carrinho.total }" />
				</th>
			</tr>
		</tfoot>
	</table>
</div>
</div>
</body>
</html>
