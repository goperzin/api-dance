package br.com.apidance.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.apidance.dto.FuncionarioDTO;
import br.com.apidance.form.FuncionarioForm;
import br.com.apidance.model.Funcionario;
import br.com.apidance.repository.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@PostMapping("cadastrar")
	public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody FuncionarioForm form, UriComponentsBuilder uriBuilder) {

		Funcionario funcionario = new Funcionario(form);
		funcionarioRepository.save(funcionario);
		
		URI uri = uriBuilder.path("/cadastrar/{id}").buildAndExpand(funcionario.getIdFuncionario()).toUri();
		
		return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
	}
	
	@GetMapping("listar")
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	@PutMapping("alterar")
	public List<Funcionario> alterar() {
		return funcionarioRepository.findAll();
	}

	@DeleteMapping("desativar")
	public List<Funcionario> desativar() {
		return funcionarioRepository.findAll();
	}
	
	
}
