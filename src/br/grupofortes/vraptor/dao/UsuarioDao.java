package br.grupofortes.vraptor.dao;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.grupofortes.vraptor.model.Usuario;

@Component
public class UsuarioDao extends GenericDao {

	public boolean existeUsuario(Usuario usuario) {
		Usuario encontrado = (Usuario) getSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.uniqueResult();
		return encontrado != null;
	}
	
	public boolean  verificaUsuario(String login) {
		Usuario encontrado = (Usuario) getSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.uniqueResult();
		return encontrado != null;
	}

	public Usuario carrega(Usuario usuario) {
		return (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

}
