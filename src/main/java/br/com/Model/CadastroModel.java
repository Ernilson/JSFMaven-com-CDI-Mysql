package br.com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabcadastro")
public class CadastroModel implements Serializable, Base{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;	
	private String telefone;
	private String endereco;
	private String email;

	public CadastroModel() {
		// TODO Auto-generated constructor stub
	}

	public CadastroModel(long id, String nome, String telefone, String endereco, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroModel other = (CadastroModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CadastroModel [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", email=" + email + "]";
	}
	
	
}
