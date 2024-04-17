package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	public List<Funcionario> findByNmFuncionario(String nome);

}