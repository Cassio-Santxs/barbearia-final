package app.config;

import java.util.Arrays;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Immutable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		//http
		//		.csrf(AbstractHttpConfigurer::disable)
		//		.cors(Customizer.withDefaults())
		//		.oauth2ResourceServer(oauth2 -> oauth2
		//				.jwt(jwt -> jwt.jwtAuthenticationConverter(new Conversor())))
		//		.authorizeHttpRequests((requests) -> requests
		//				.requestMatchers("/api/log/findAll", "/api", "/api/", "/api/login", "/api/cadastro", "/api/cliente/save", "api/cliente/findByUsername/{username}").permitAll()
		//				.anyRequest().authenticated());
		
		http.csrf(csrf -> csrf.disable());

		//http
		//		.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://barbearia.mshome.net"));
		configuration.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(), HttpMethod.POST.name(),
					HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name())); // Métodos permitidos
		configuration.setAllowedHeaders(Arrays.asList("*")); // Permite todos os cabeçalhos
		configuration.setAllowCredentials(true); // Permite credenciais
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration); // Aplica a configuração a todas as rotas
			return source;
	}
	
	//@Bean
	//public FilterRegistrationBean<CorsFilter> corsFilter() {
	//UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	//CorsConfiguration config = new CorsConfiguration();
	//config.setAllowCredentials(true);
	//config.setAllowedOriginPatterns(Arrays.asList("*"));
		//config.addAllowedOrigin("http://localhost:4200");
	//config.setAllowedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION,HttpHeaders.CONTENT_TYPE,HttpHeaders.ACCEPT));
	//config.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(),HttpMethod.POST.name(),HttpMethod.PUT.name(),HttpMethod.DELETE.name()));
	//config.setMaxAge(3600L);
	//source.registerCorsConfiguration("/**", config);
	//FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
	//bean.setOrder(-102);
	//return bean;
	//}

}