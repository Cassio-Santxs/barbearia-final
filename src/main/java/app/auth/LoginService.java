//AuthenticationService.java
package app.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		
		// Login não funcionando. Debuggando não passa dessa linha
		// git add .
		// git commit -m "mensagem"
		// git push+++++++++++++++++++++++++
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						login.getUsername(),
						login.getPassword()
						)
				);
		


		Optional<Cliente> user = clienteRepository.findByUsername(login.getUsername());
		Optional<Funcionario>  admin = funcionarioRepository.findByUsername(login.getUsername());

		if(user.isPresent()) {
			jwtToken = jwtService.generateToken(user.get().getUsername(), user.get().getIdCliente(), "cliente");
;		}else if(admin.isPresent()) {
			System.out.println("e");
			jwtToken = jwtService.generateToken(admin.get().getUsername(), admin.get().getIdFuncionario(), "admin");
		}else 
			throw  new UsernameNotFoundException("Usuário não encontrado");
		
	
		
		return jwtToken;
	}

}
