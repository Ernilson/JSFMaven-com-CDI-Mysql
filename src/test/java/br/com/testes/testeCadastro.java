package br.com.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.DAO.CadastroDAO;
import br.com.Model.CadastroModel;
import br.com.Service.CadastroService;


public class testeCadastro {
	/*
	 * public static void main(String[] args) {
	 * 
	 * CadastroModel cadast = new CadastroModel();
	 * 
	 * try { cadast.setNome("mais teste"); cadast.setEndereco("quadra");
	 * cadast.setEmail("teste@teste.com"); cadast.setTelefone("123456");
	 * 
	 * EntityManagerFactory entityManagerFactory =
	 * Persistence.createEntityManagerFactory("CadastroPU"); EntityManager
	 * entityManager = entityManagerFactory.createEntityManager();
	 * 
	 * entityManager.getTransaction().begin(); entityManager.persist(cadast);
	 * entityManager.getTransaction().commit();
	 * 
	 * entityManager.close(); entityManagerFactory.close();
	 * 
	 * System.out.println("Sucesso"); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	@Test
	public void teste2() {
		CadastroModel c = new CadastroModel();
		CadastroService servico = new CadastroService();		
		try {
			c.setNome("teste");
			c.setEndereco("quadra");
			c.setEmail("segundo@mail.com");
			c.setTelefone("123456");

			//servico.salvar(c);
			//cdao.salvar(c);
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
//	@Test
//    public void listar() {
//		try {
//			CadastroService servico = new CadastroService();
//		      List<CadastroModel> resultado = servico.todosOsCadastros();
//		      System.out.println("Total de Registros" + resultado.size());
//		      for (CadastroModel produtos : resultado) {
//		          System.out.println(produtos.getNome()+ " - " + produtos.getEndereco()); }
//		} catch (Exception e) {
//			System.out.println(e);
//		}      
//  }

}
