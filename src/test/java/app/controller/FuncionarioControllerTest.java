/*package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@SpringBootTest
public class FuncionarioControllerTest {
	
	@Autowired
	FuncionarioController controller;
	
	@MockBean
	FuncionarioRepository repository;
	
	@BeforeEach
	void setup() {
		
		List<Funcionario> list = new ArrayList<Funcionario>();
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		Optional<Funcionario> funcionarioOp = Optional.of(funcionario);
		
		list.add(funcionario);
		
		//FuncionarioRepository repositoryMock = spy(FuncionarioRepository.class);
		
		when(this.repository.save(funcionario)).thenReturn(funcionario);
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.findById(1L)).thenReturn(funcionarioOp);
		when(this.repository.findByNmFuncionario("breno")).thenReturn(list);
		doNothing().when(this.repository).deleteById(1L);
		
	}
	
	@Test
	@DisplayName("teste do metodo save")
	void testSave() {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		ResponseEntity<String> response = this.controller.save(funcionario);
		String msg = response.getBody();
		
		assertEquals("Salvo com sucesso!", msg);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		}
	
	@Test
	@DisplayName("teste de Catch no metoodo save")
	void testSave2() {
		
		ResponseEntity<String> response = this.controller.save(null);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
		}
	
	@Test
	@DisplayName("teste no método findAll")
	void testListall() {
		
		ResponseEntity<List<Funcionario>> response = this.controller.listAll();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	@DisplayName("test no método findById")
	void testFindById() {
		ResponseEntity<Funcionario> response = this.controller.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	@DisplayName("teste no método update")
	void testUpdate() {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("brenofoda@gmail.com");
		funcionario.setDsSenha("123123");
		
		ResponseEntity<String> response = this.controller.update(funcionario, 1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	@DisplayName("teste no método delete")
	void testDelete() {
		
		ResponseEntity<String> response = this.controller.deleteById(2L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	@DisplayName("teste no método FindByNmFuncionario")
	void testFindByNmFuncionario() {
		ResponseEntity<List<Funcionario>> response = this.controller.findByNmFuncionario("breno");
		List<Funcionario> obj = response.getBody();
		assertEquals(1, obj.size());
	}
}*/