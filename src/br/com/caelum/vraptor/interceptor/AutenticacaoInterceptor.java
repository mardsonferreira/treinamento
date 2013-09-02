package br.com.caelum.vraptor.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.grupofortes.vraptor.controller.UsuariosController;
import br.grupofortes.vraptor.model.UsuarioWeb;

@Intercepts
public class AutenticacaoInterceptor implements Interceptor{

	private final UsuarioWeb usuario;
	private final Result result;
	
	
	
	public AutenticacaoInterceptor(UsuarioWeb usuario, Result result) {
		super();
		this.usuario = usuario;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return !this.usuario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuariosController.class).login();
		
	}

}
