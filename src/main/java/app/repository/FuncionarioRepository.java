package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	public List<Funcionario> findByNmFuncionario(String nome);
	
	@Query(value = "FROM Funcionario f WHERE f.username = :username2")
	public Optional<Funcionario> findByUsername(@Param("username2") String username2);

}