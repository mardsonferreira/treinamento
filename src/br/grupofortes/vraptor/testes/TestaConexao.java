package br.grupofortes.vraptor.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.grupofortes.vraptor.model.Produto;

public class TestaConexao {
	public static void main(String[] args) {

		Produto produto = new Produto("arroz", "tipo 1", 2.20);

		AnnotationConfiguration confiration = new AnnotationConfiguration();
		confiration.configure();

		SessionFactory factory = confiration.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();
		session.save(produto);
		session.beginTransaction().commit();
		session.close();
		
	}
}
