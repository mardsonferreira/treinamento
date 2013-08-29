<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/head.jsp" />

<div id="content">
	<form class="form-horizontal" method="post" id="formulario"
		action='<c:url value="/produtos"/>'>
		
		<c:if test="${produto.id != null}"> 
			<input type="hidden" name="produto.id" value="${produto.id}">
			<input type='hidden' name='_method' value='PUT'/>
		</c:if>
		
		
		<div class="control-group">
			<label class="control-label">Nome</label>
			<div class="controls">
				<input id="pnome" class="required" type="text" name="produto.nome"
					value="${produto.nome}" />
			</div>
		</div>


		<div class="control-group">
			<label class="control-label">Descrição</label>
			<div class="controls">
				<input id="pdesc" class="required" type="text"
					name="produto.descricao" value="${produto.descricao}" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">Preço</label>
			<div class="controls">
				<input id="ppreco" type="text" class="required" name="produto.preco"
					value="${produto.preco}" />
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button id="enviar" type="submit" class="btn">Enviar</button>
			</div>

		</div>

	</form>
</div>
</div>
</body>
</html>
