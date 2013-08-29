<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='../index/head.jsp' />

		<div id="content">
			<table class="table table-striped">
				<tr>
					<th>Nome</th>
					<th>Descri��o</th>
					<th>Pre�o</th>
					<th>A��es</th>
				</tr>
				<c:forEach items="${produtos}" var="produto">
					<tr id="produto-${produto.id}">
						<td>${produto.nome}</td>
						<td>${produto.descricao}</td>
						<td>${produto.preco}</td>
						<td><a class="link"
							href='<c:url value="/produtos/edit/${produto.id}"/>'> <i
								class="icon-edit"></i> </a>
							<button class="button remove" id="${produto.id}">
								<i class="icon-trash button"></i>
							</button></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
