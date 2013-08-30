<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/head.jsp" />

<div id="content">

	<form id="usuariosForm" action="<c:url value="/usuarios"/>"
		method="POST" autocomplete="off">
		<fieldset>
			<legend>Criar novo usuário</legend>
			<div class="control-group">
				<div class="controls">
					<input id="nome" class="required" type="text" name="usuario.nome"
						placeholder="Nome" value="${usuario.nome }" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<input placeholder="login" id="login" class="required" type="text"
						name="usuario.login" value="${usuario.login }" />
				</div>
			</div>


			<div class="control-group">
				<div class="controls">
					<input id="senha" class="required" type="password"
						placeholder="senha" name="usuario.senha" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="confirmacao" placeholder="Confirme sua senha"
						equalTo="#senha" type="password" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<button id="enviar" type="submit" class="btn">Enviar</button>
				</div>
			</div>
		</fieldset>
	</form>

</div>

<script>
	$(function() {
		$("#login").val("");
	});
</script>

</div>
</body>
</html>
