package br.com.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.Model.CadastroModel;
import br.com.Service.CadastroService;

import br.com.Utils.*;

@Named("bean")
@SessionScoped
public class CadastroControllerBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroModel cad;

	@Inject
	private CadastroService service;

	private List<CadastroModel> cadList = new ArrayList<>();

	// Metodo para iniciar a listas logo ao carregar a tela
	/*
	@PostConstruct
	public void inicializa() {
		cad = (CadastroModel) service.todosOsCadastros();
	}

	// Metodo salvar
	public void incluir() throws NegocioException {
		service.salvar(cad);
		cad = new CadastroModel();
		inicializa();

		Message.info("Cadastro inserido com sucesso!");
	}

	public void excluir() {
		try {

			service.remover(cad);
			inicializa();

			Message.warn("Cadastro excluido com sucesso!");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
*/
	public String adicionarCadastro() {
		cadList.add(cad);

		limpar();

		return null;
	}

	private void limpar() {
		cad = new CadastroModel();
	}

	public CadastroModel getCad() {
		return cad;
	}

	public void setCad(CadastroModel cad) {
		this.cad = cad;
	}

	public List<CadastroModel> getCadList() {
		return cadList;
	}

	public void setCadList(List<CadastroModel> cadList) {
		this.cadList = cadList;
	}

}
