<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/head.jsp" />

<div id="content">
	<fieldset>
		<form class="form-horizontal" method="post" id="formulario"
			action='<c:url value="/produtos"/>' enctype="multipart/form-data">

			<c:if test="${produto.id != null}">
				<input type="hidden" name="produto.id" value="${produto.id}">
				<input type="hidden" name="produto.image" value="${produto.image}">
				<input type='hidden' name='_method' value='PUT' />
			</c:if>




			<div class="control-group">
				<div class="controls">
					<input id="pnome" placeholder="Nome" class="required input"
						type="text" name="produto.nome" value="${produto.nome}" />
				</div>
			</div>


			<div class="control-group">
				<div class="controls">
					<input id="pdesc" class="required input" type="text"
						placeholder="Descrição" name="produto.descricao"
						value="${produto.descricao}" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<input id="ppreco" placeholder="Preço" type="text"
						class="required input" name="produto.preco"
						value="${produto.preco}" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<div class="fileupload fileupload-new" data-provides="fileupload">
						<div class="fileupload-new thumbnail"
							style="width: 200px; height: 150px;">
							<img
								src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" />
						</div>
						<div class="fileupload-preview fileupload-exists thumbnail"
							style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
						<div>
							<span class="btn btn-file">
							<span class="fileupload-new">Selecione imagem</span>
							<span class="fileupload-exists">Alterar</span>
							<input type="file" name="imagem" />
							 </span> <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remover</a>
						</div>
					</div>

				</div>
			</div>



			<div class="control-group">
				<div class="controls">
					<button id="enviar" type="submit" class="btn">Enviar</button>
				</div>

			</div>






		</form>
	</fieldset>
</div>
</div>
</body>
</html>
