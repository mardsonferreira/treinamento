package br.grupofortes.vraptor.testes.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.grupofortes.vraptor.dao.UsuarioDao;
import br.grupofortes.vraptor.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:appContext.xml" })

@TransactionConfiguration(defaultRollback = false)
public class UsuarioTest extends AbstractDependencyInjectionSpringContextTests{

	@Autowired
	private UsuarioDao userDao;
	
	@Test
	public void save(){
		Usuario user = new Usuario();
		user.setNome("matheus");
		user.setLogin("matheus");
		user.setSenha("123");
		user.setNasc(new Date());
		userDao.save(user);
		assertNotNull(user);		
	}
	
}
