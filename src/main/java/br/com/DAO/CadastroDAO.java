package br.com.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.Model.Base;
import br.com.Repository.ConnectionFactory;

public class CadastroDAO <T extends Base> implements Serializable {
	
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T buscaPorId(Class<T> clazz, Long id) {
		
		return manager.find(clazz, id);
	}
	
	//Metodo para Salvar ou alterar
	public void gravar(T t) {
		try {
			manager.getTransaction().begin();
			if (t.getId()== null) {
				manager.persist(t);
			}else {
				manager.merge(t);
			}
			
			manager.getTransaction().commit();
		} catch ( Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	//Metodo para Remover
	public void remover(Class<T>clazz, Long id) {
		T t = buscaPorId(clazz, id);
		try {
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch ( Exception e) {
			manager.getTransaction().rollback();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscaTodos(String jpql){
		Query query = (Query) manager.createQuery(jpql);
		return query.getResultList();
	}
}
