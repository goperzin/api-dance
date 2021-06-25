package br.com.apidance.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping()
	public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody FuncionarioForm form, UriComponentsBuilder uriBuilder) {
		Funcionario funcionario = new Funcionario(form);
		funcionarioRepository.save(funcionario);
		
		URI uri = uriBuilder.path("/cadastrar/{id}").buildAndExpand(funcionario.getIdFuncionario()).toUri();
		
		return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
	}
	
	@GetMapping()
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public FuncionarioDTO listarPorId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioRepository.getById(id);
		
		return new FuncionarioDTO(funcionario);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDTO> alterar(@PathVariable Long id, @RequestBody FuncionarioForm form) {
		Funcionario funcionario = funcionarioRepository.getById(id);
		funcionario.setNome(form.getNome());
		
		return ResponseEntity.ok(new FuncionarioDTO(funcionario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
