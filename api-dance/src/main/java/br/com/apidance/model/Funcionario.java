package br.com.apidance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import com.sun.istack.NotNull;

import br.com.apidance.form.FuncionarioForm;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private Long idFuncionario;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefone;
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(FuncionarioForm f) {
		this.idFuncionario = f.getIdFuncionario();
		this.nome = f.getNome();
		this.email = f.getEmail();
		this.telefone = f.getTelefone(); 
	}
	
}
