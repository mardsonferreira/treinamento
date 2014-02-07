package br.grupofortes.vraptor.testes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.grupofortes.vraptor.model.Produto;

public class TestaConexao {
	public static void main(String[] args) throws ParseException {

		// Produto produto = new Produto("arroz", "tipo 1", 2.20);
		//
		// AnnotationConfiguration confiration = new AnnotationConfiguration();
		// confiration.configure();
		//
		// SessionFactory factory = confiration.buildSessionFactory();
		//
		// Session session = factory.openSession();
		//
		// session.beginTransaction();
		// session.save(produto);
		// session.beginTransaction().commit();
		// session.close();

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date inicio = new Date(); //formatter.parse("10/09/2013");
		Date fim = new Date();// formatter.parse("10/09/2013");
	    inicio.setMinutes(20);

		System.out.println(inicio);
		System.out.println(fim);
		

		 if (fim.getTime() - inicio.getTime() > 900000)
				System.out.println("skjhjlkhkdjfhs");
		 	
		
	}
}
