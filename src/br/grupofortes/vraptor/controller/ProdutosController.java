package br.grupofortes.vraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.Restrito;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.download.FileDownload;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.grupofortes.vraptor.dao.ProdutoDao;
import br.grupofortes.vraptor.model.Imagens;
import br.grupofortes.vraptor.model.Produto;

@Resource
@Path("/produtos")
public class ProdutosController {

	private ProdutoDao produtoDao;
	private Result result;
	private Validator validator;
	private Imagens imagens;

	public ProdutosController(ProdutoDao produtoDao, Result result,
			Validator validator, Imagens imagens) {
		super();
		this.produtoDao = produtoDao;
		this.result = result;
		this.validator = validator;
		this.imagens = imagens;
	}

	@Get({ "", "/" })
	public void produtos() {
		result.include("produtos", produtoDao.list());
	}

	@Get
	@Path("/index")
	public void index() {

	}

	@Get("/new")
	@Restrito
	public void formulario() {
	}

	@Get("/{id}/image")
	public Download loadImage(Long id) {
		Produto produto = produtoDao.carrega(id);
		String path = "C:/Users/mardsonferreira/Workspaces/MyEclipse 10/treinamento/WebRoot/WEB-INF/images/"
				+ produto.getImage();

		File foto = new File(path);
		FileDownload file = new FileDownload(foto, "image/jpg",
				produto.getImage());

		return file;
	}

	@Post("")
	@Restrito
	public void save(Produto produto, UploadedFile imagem) {

		validator.validate(produto);
		validator.onErrorUsePageOf(this).formulario();

		if (imagem != null) {
			produto.setImage(imagem.getFileName());

			if (produtoDao.save(produto)) {
				produto.salvaImagem(imagem, produto.getImage());
			}
		} else {

			produtoDao.save(produto);
		}
		result.redirectTo(this).produtos();
	}

	@Get("/edit/{id}")
	@Restrito
	public void edit(Long id) {
		Produto produto = produtoDao.carrega(id);
		result.include("produto", produto).forwardTo(this).formulario();
	}

	@Put("")
	@Restrito
	public void update(Produto produto, UploadedFile imagem) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).edit(produto.getId());

		if (imagem != null) {
			produto.removerImagem(produto.getImage());
			produto.setImage(imagem.getFileName());

			if (produtoDao.update(produto)){
				produto.salvaImagem(imagem, produto.getImage());
				result.include("mensagem", "Produto atualizado com sucesso!");
			}else
				result.include("mensagem",
						"Ocorreu um problema ao atualizar o produto.");
		}else{
			if (produtoDao.update(produto))
				result.include("mensagem", "Produto atualizado com sucesso!");
			else
				result.include("mensagem",
						"Ocorreu um problema ao atualizar o produto.");
		}
		result.redirectTo(this).produtos();
	}

	@Delete("/remove/{id}")
	@Restrito
	public void remove(Long id) {
		Produto produto = produtoDao.carrega(id);
		if (produtoDao.delete(produto)) {
			produto.removerImagem(produto.getImage());
		}
		result.use(Results.representation());
	}

	@Get("/findJson/{nome}")
	public void findJson(String nome) {
		result.use(json()).withoutRoot().from(produtoDao.busca(nome))
				.exclude("id", "descricao", "preco").serialize();
	}

	@Get("/find/{nome}")
	public void find(String nome) {
		result.include("nome", nome)
				.include("produtos", produtoDao.busca(nome));
	}

	// @Get("/find/{nome}")
	// public void find(String nome) {
	// System.out.println(nome);
	// result.include("nome", nome);
	// result.use(Results.representation()).from(produtoDao.busca(nome),"produtos").exclude("id",
	// "descricao").serialize();
	// }
}
