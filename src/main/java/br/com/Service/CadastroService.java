package br.com.Service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.DAO.CadastroDAO;
import br.com.Model.CadastroModel;
import br.com.Utils.NegocioException;

public class CadastroService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroDAO<CadastroModel> cadDAO = new CadastroDAO<CadastroModel>();
	
	public void salvar(CadastroModel cad) throws NegocioException {	
		if (cad.getNome().length()< 3) {
			throw new NegocioException("O nome do cadastro deve ter mais de três caracteres");
		}		
		try {
			cadDAO.salvar(cad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void remover(CadastroModel cad) throws NegocioException {
		cadDAO.remover(CadastroModel.class, cad.getId());
	}
	
	public List<CadastroModel> todosOsCadastros(){
		
		return cadDAO.buscaTodos("select c from CadastroModel c order by c.nome");
	}
}
