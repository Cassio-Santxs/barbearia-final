package app.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.repository.ClienteRepository;
import app.repository.FuncionarioRepository;

@Configuration
public class SecurityManager {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}


	@Bean
	public UserDetailsService userDetailsService() {
		
		return username -> this.buscarUsuario(username);
	}
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> clienteRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado") );
	}
	*/
	private UserDetails buscarUsuario(String username){

		System.out.println(username);
		System.out.println("b");
		String username2 = username;

		Optional<Cliente> user = clienteRepository.findByUsername(username);
		System.out.println("c");
		System.out.println(username);
		System.out.println(username2);

		Optional<Funcionario>  admin = funcionarioRepository.findByUsername(username2);
		System.out.println("d");

		if(user.isPresent()) {
			System.out.println("f");
			return user.get()
;		}else if(admin.isPresent()) {
			System.out.println("e");
			return admin.get();
		}else 
			throw  new UsernameNotFoundException("Usuário não encontrado");
	}


}
