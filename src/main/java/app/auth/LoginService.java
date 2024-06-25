//AuthenticationService.java
package app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import app.config.JwtServiceGenerator;
import app.entity.Cliente;
import app.entity.Funcionario;
import app.repository.ClienteRepository;
import app.repository.FuncionarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private JwtServiceGenerator jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;


	public String logar(Login login) {
		String jwtToken = "";
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						login.getUsername(),
						login.getPassword()
						)
				);
		
		Cliente user = clienteRepository.findByUsername(login.getUsername()).get();
		Funcionario admin = funcionarioRepository.findByUsername(login.getUsername()).get();
		
		if(user != null)
			jwtToken = jwtService.generateToken(user.getUsername(), user.getIdCliente(), "cliente");
		else
			jwtToken = jwtService.generateToken(admin.getUsername(), admin.getIdFuncionario(), "admin");
		
		
		return jwtToken;
	}

}
