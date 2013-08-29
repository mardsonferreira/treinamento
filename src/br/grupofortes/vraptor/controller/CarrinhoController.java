package br.grupofortes.vraptor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.grupofortes.vraptor.dao.ProdutoDao;
import br.grupofortes.vraptor.model.Carrinho;
import br.grupofortes.vraptor.model.Item;

@Resource
@Path("/carrinho")
public class CarrinhoController {

	private final Carrinho carrinho;
	private final ProdutoDao produtoDao;
	private final Result result;

	public CarrinhoController(Carrinho carrinho, ProdutoDao produtoDao,
			Result result) {
		super();
		this.carrinho = carrinho;
		this.produtoDao = produtoDao;
		this.result = result;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public Result getResult() {
		return result;
	}

	public void adiciona(Item item) {
		produtoDao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(ProdutosController.class).produtos();
	}

}
