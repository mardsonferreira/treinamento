package br.grupofortes.vraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;

import javax.servlet.jsp.tagext.ValidationMessage;

import org.codehaus.jettison.json.JSONArray;
import org.json.JSONWriter;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Message;
import br.grupofortes.vraptor.dao.UsuarioDao;
import br.grupofortes.vraptor.model.Usuario;
import br.grupofortes.vraptor.model.UsuarioWeb;

@Resource
@Path("/usuarios")
public class UsuariosController {

	private final UsuarioDao usuariodao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;

	public UsuariosController(UsuarioDao usuariodao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		super();
		this.usuariodao = usuariodao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Get("/new")
	public void formulario() {

	}

	@Post("")
	public void adiciona(Usuario usuario) {
		if (usuariodao.existeUsuario(usuario)) {
			validator.add((Message) new ValidationMessage("Login já existe",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).formulario();
		usuariodao.save(usuario);
		result.redirectTo(ProdutosController.class).produtos();
	}

	@Get("/login")
	public void login() {

	}
	
	@Get("/login/{login}")
	public void verificaLogin(String login){
		result.use(json()).withoutRoot().from(usuariodao.verificaUsuario(login)).serialize();	
	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = usuariodao.carrega(usuario);
		if (carregado == null) {
			//validator.add((Message) new ValidationMessage(
					//"Login e/ou senha inválidos", "usuario.login"));
			result.redirectTo(UsuariosController.class).login();
		}
	//	validator.onErrorUsePageOf(UsuariosController.class).login();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutosController.class).produtos();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutosController.class).produtos();
	}

}
