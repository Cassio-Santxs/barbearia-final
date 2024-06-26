package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findByNmCliente (String nmCliente);
	
	public List<Cliente> findBydsCpf (String dscpf);
	
	@Query(value = "FROM Cliente WHERE username = :username")
	public Optional<Cliente> findByUsername(@Param("username") String username);
}