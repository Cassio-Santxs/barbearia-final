package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findByNmCliente (String nmCliente);
	
	public List<Cliente> findBydsCpf (String dscpf);
	
	public Optional<Cliente> findByUsername(String login);
}