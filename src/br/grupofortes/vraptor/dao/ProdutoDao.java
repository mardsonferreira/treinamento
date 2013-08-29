package br.grupofortes.vraptor.dao;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.grupofortes.vraptor.model.Produto;

@Component
public class ProdutoDao extends GenericDao {
	
	@SuppressWarnings("unchecked")
	public List<Produto> list(){
		return getSession().createCriteria(Produto.class).list();
	}

	public Produto carrega(Long id) {
		return (Produto) getSession().load(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> busca(String nome) {
		return getSession().createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Produto produto) {
		getSession().refresh(produto);
		
	}

	
}
