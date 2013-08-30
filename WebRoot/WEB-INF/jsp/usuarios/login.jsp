<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="../index/head.jsp" />


		<div id="content">
			<form action="<c:url value="/usuarios/login"/>" method="POST"
				autocomplete="off">
				<fieldset>
					<legend>Efetue o login</legend>
					<div class="control-group">
						<div class="controls">
							<input placeholder="Login" id="login" type="text"
								name="usuario.login" />
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<input placeholder="Senha" id="senha" type="password"
								name="usuario.senha" />
						</div>
					</div>
					
					<button type="submit" class="btn">Login</button>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>
