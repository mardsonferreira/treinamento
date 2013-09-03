<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="../index/head.jsp" />


<div id="content">

	<h2>${login}</h2>
	
	<form action="<c:url value="/usuarios/login"/>" method="POST"
	
	
	
		id="loginForm" autocomplete="off">
		<fieldset>
			<legend>Efetue o login</legend>
			<div class="control-group">
				<div class="controls">
					<input placeholder="Login" id="login" type="text"
						name="usuario.login" class="required input" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<input placeholder="Senha" id="senha" type="password"
						name="usuario.senha" class="required input" />
				</div>
			</div>

			<button type="submit" class="btn">Login</button>

		</fieldset>
	</form>
</div>
</div>
</body>
</html>
