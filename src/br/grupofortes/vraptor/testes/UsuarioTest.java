package br.grupofortes.vraptor.testes;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebRoot/WEB-INF/config/spring/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class UsuarioTest extends TestCase{
     
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() throws Exception{
		// Insere os dados no banco de dados
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
	}

	@After
	public void after() throws Exception{
		//Limpa a base de dados
		DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
	}

	private IDatabaseConnection getConnection() throws Exception{
	    // Pega a conexão com o banco de dados
		Connection con = dataSource.getConnection();
		DatabaseMetaData  databaseMetaData = con.getMetaData();
		IDatabaseConnection connection = new DatabaseConnection(con,databaseMetaData.getUserName().toUpperCase());
		return connection;
	}

	private IDataSet getDataSet() throws Exception{
		// Pega o arquivo de para inserir
		File file = new File("src/br/grupofortes/vraptor/testes/base/dataset.xml");
		return new FlatXmlDataSet(file);
	}

	@Test
	public void testSQLUpdate() throws Exception{
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		// Pega o valor atual
		ResultSet rst = stmt.executeQuery("select * from usuario where id = 1");
		if(rst.next()){
			// compara a partir de dataset.xml
			assertEquals("MARDSON", rst.getString("nome"));
			rst.close();

			// atualiza via SQL
			int count = stmt.executeUpdate("update usuario set nome='mardson Alterado' where id=1");

			stmt.close();
			con.close();

			// expera somente 1 linha de alteração
			assertEquals("one row should be updated", 1, count);

			// Fetch database data after executing the code
			QueryDataSet databaseSet = new QueryDataSet(getConnection());
			// filtra os dados
			databaseSet.addTable("usuario", "select * from usuario where id = 1");
			ITable actualTable = databaseSet.getTables()[0];

			// Carrega os dados esperados a partir do XML
			IDataSet expectedDataSet = new FlatXmlDataSet(new File("src/br/grupofortes/vraptor/testes/base/expectedDataSet.xml"));
			ITable expectedTable = expectedDataSet.getTable("usuario");

			// Filtra colunas desnessarias dos dados atuais definidos pelo XML
			actualTable = DefaultColumnFilter.includedColumnsTable(actualTable, expectedTable.getTableMetaData().getColumns());

			// Assert da base de dados atual com os dados esperados
			assertEquals(1,expectedTable.getRowCount());
			assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());
			assertEquals(expectedTable.getValue(0, "nome"), actualTable.getValue(0, "nome"));

		} else {
			fail("no rows");
			rst.close();
			stmt.close();
			con.close();
		}

	}
}
