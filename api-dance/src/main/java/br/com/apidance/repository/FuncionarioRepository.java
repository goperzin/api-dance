package br.com.apidance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apidance.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
