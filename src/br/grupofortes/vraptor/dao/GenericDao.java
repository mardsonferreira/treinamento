package br.grupofortes.vraptor.dao;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class GenericDao {

	@Autowired
	private Session session;
	
	public Session getSession(){
		return this.session;
	}
	
	public boolean save(Object object) {
		try {
			getSession().save(object);
			getSession().flush();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public boolean update(Object object) {
		try {
			getSession().merge(object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Object object) {
		try {
			getSession().delete(object);
			getSession().flush();
			return true;
		} catch (ConstraintViolationException e) {
			return false;
		}
	}
}
