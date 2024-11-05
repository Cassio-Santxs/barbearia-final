package app.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;


public interface LoginRepository extends JpaRepository<Cliente, Long>{

	public Optional<Cliente> findByUsername(String login);
	
	//ver se tem q colocar mais um public pro usuário
	
}
