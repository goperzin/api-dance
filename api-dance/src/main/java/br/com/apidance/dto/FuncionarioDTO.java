package br.com.apidance.dto;

import br.com.apidance.model.Funcionario;

public class FuncionarioDTO {

	private Long idFuncionario;
	private String nome;
	private String email;
	private String telefone;
	
	public FuncionarioDTO() {
		super();
	}
	
	public FuncionarioDTO(Funcionario f) {
		this.idFuncionario = f.getIdFuncionario();
		this.nome = f.getNome();
		this.email = f.getEmail();
		this.telefone = f.getTelefone(); 
	}
	
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
}