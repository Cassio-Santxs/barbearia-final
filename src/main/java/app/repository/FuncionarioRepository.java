package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;
import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	public List<Funcionario> findByNmFuncionario(String nome);
	
	public Optional<Funcionario> findByUsername(String login);

}