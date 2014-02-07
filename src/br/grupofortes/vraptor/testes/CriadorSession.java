package br.grupofortes.vraptor.testes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


public class CriadorSession implements ComponentFactory<Session> {
	private SessionFactory sessionFactory;
	private Session session;

	public CriadorSession(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	@PostConstruct
	public void abre() {
		this.session = sessionFactory.openSession();
	}

	@PreDestroy
	public void fecha() {
		session.close();
	}

	public Session getInstance() {
		return session;
	}
}