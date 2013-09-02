package br.grupofortes.vraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.Restrito;
import br.com.caelum.vraptor.view.Results;
import br.grupofortes.vraptor.dao.ProdutoDao;
import br.grupofortes.vraptor.model.Produto;

@Resource
@Path("/produtos")
public class ProdutosController {

	private ProdutoDao produtoDao;
	private Result result;
	private Validator validator;

	public ProdutosController(ProdutoDao produtoDao, Result result,
			Validator validator) {
		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;
	}

	@Get({ "", "/" })
	public void produtos() {
		result.include("produtos", produtoDao.list());
	}
	
	@Get
	@Path("/index")
	public void index(){
		
	}
	
	@Get("/new")
	@Restrito
	public void formulario() {
	}

	@Post("")
	@Restrito
	public void save(final Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).formulario();
		produtoDao.save(produto);
		result.redirectTo(this).produtos();
	}

	@Get("/edit/{id}")
	@Restrito
	public void edit(Long id) {
		Produto produto =  produtoDao.carrega(id);
		result.include("produto", produto).forwardTo(this).formulario();
	}

	@Put("")
	@Restrito
	public void update(Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).edit(produto.getId());

		if (produtoDao.update(produto))
			result.include("mensagem", "Produto atualizado com sucesso!");
		else
			result.include("mensagem",
					"Ocorreu um problema ao atualizar o produto.");
		result.redirectTo(this).produtos();
	}

	@Delete("/remove/{id}")
	@Restrito
	public void remove(Long id) {
		produtoDao.delete(produtoDao.carrega(id));
		result.use(Results.representation());
	}

	@Get("/findJson/{nome}")
	public void findJson(String nome) {
		result.use(json()).withoutRoot().from(produtoDao.busca(nome)).exclude("id", "descricao","preco").serialize();
	}

	
	@Get("/find/{nome}")
	public void find(String nome) {
		result.include("nome", nome)
				.include("produtos", produtoDao.busca(nome));
	}

	
	
//	@Get("/find/{nome}")
//	public void find(String nome) {
//		System.out.println(nome);
//		result.include("nome", nome);
//		result.use(Results.representation()).from(produtoDao.busca(nome),"produtos").exclude("id", "descricao").serialize();
//	}
}
