package br.com.Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.Model.CadastroModel;
import br.com.Service.CadastroService;
import br.com.Utils.Message;
import br.com.Utils.NegocioException;


@Named
@SessionScoped
public class CadastroMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroModel cad;
	
	@Inject
	private CadastroService service;

	private List<CadastroModel> cadList;
	
	//private CadastroModel carrega;
	
	@PostConstruct
	public void inicializar() {
		cadList = service.todosOsCadastros();
		cad = new CadastroModel();
	}
	
	public void adicionar() {
		try {
			service.gravar(cad);
			cad = new CadastroModel();
			inicializar();
			
			Message.info("Salvo com sucesso");
			
		} catch (Exception e) {
			Message.erro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			service.gravar(cad);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void carregaDados(CadastroModel cad) {
		this.cad = cad;
	}
	
	public String remover(CadastroModel c) {
        try {
        	if (service.remover(c)) {
        		inicializar();               
                Message.info(cad.getNome() + "Foi removido com sucesso!!");
            }
		} catch (Exception e) {
			Message.erro(e.getMessage());
		}
        return "sorte.xhtml";
    }	

	public CadastroModel getCad() {
		return cad;
	}

	public void setCad(CadastroModel cad) {
		this.cad = cad;
	}

	public CadastroService getService() {
		return service;
	}

	public void setService(CadastroService service) {
		this.service = service;
	}

	public List<CadastroModel> getCadList() {
		return cadList;
	}

	public void setCadList(List<CadastroModel> cadList) {
		this.cadList = cadList;
	}

	
	
	
	

	
}
