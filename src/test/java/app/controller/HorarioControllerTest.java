/*package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
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
import org.springframework.http.ResponseEntity;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Horario;
import app.repository.ClienteRepository;
import app.repository.HorarioRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest()
public class HorarioControllerTest {
	@MockBean
	private HorarioRepository repository;

	@Autowired
	private HorarioController controller;

	@BeforeEach
	void setup() {
		List<Horario> list = new ArrayList<>();
		
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE ");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		Horario horario = new Horario();
		horario.setIdHorario(1L);
		horario.setDtHorario("01/01/0001");
		horario.setVlHorario(20);
		horario.setCliente(cliente);
		horario.setFuncionario(funcionario);
		list.add(horario);
		
		Optional<Horario> horarioOp = Optional.of(horario);
	
		ClienteRepository repositoryMock = spy(ClienteRepository.class); 
		
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(horario)).thenReturn(horario);
		when(this.repository.findById(1L)).thenReturn(horarioOp);
		doNothing().when(repositoryMock).deleteById(1L);
	}

	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		ResponseEntity<List<Horario>> response = this.controller.listAll();
		List<Horario> lista = response.getBody();
		assertEquals(1, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testsave() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE ");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		Horario horario = new Horario();
		horario.setIdHorario(1L);
		horario.setDtHorario("01/01/0001");
		horario.setVlHorario(20);
		horario.setCliente(cliente);
		horario.setFuncionario(funcionario);
		
		ResponseEntity<String> response = this.controller.save(horario);
		String mensagem = response.getBody();

		assertEquals("Horario salvo com sucesso.", mensagem);
	}

	@Test
	@DisplayName("TESTE MÉTODO update()")
	void testUpdate() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE ");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		Horario horario = new Horario();
		horario.setIdHorario(1L);
		horario.setDtHorario("01/01/0001");
		horario.setVlHorario(20);
		horario.setCliente(cliente);
		horario.setFuncionario(funcionario);
		
		ResponseEntity<String> response = this.controller.update(horario, 1);
		String msg = response.getBody();

		assertEquals("Sucesso!", msg);
	}

	@Test
	@DisplayName("TESTE MÉTODO findById()")
	void testFindById() {
		ResponseEntity<Horario> response = this.controller.findById(1L);
		Horario obj = response.getBody();

		assertEquals(1, obj.getIdHorario());
	}

	@Test
	@DisplayName("TESTE MÉTODO delete()")
	void testDelete() {
		ResponseEntity<String> response = this.controller.delete(1L);
		String msg = response.getBody();
		
		assertEquals("Horario deletado com sucesso", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO save() com erro de validação com campos nulos")
	void testSaveValidation() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE ");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(1L);
		funcionario.setNmFuncionario("breno");
		funcionario.setFlFuncionario(true);
		funcionario.setDsCpf("12345678900");
		funcionario.setDsEmail("breno@gmail.com");
		funcionario.setDsSenha("123123");
		
		Horario horario = new Horario();
		horario.setIdHorario(1L);
		horario.setDtHorario(null);
		horario.setVlHorario(20);
		horario.setCliente(cliente);
		horario.setFuncionario(funcionario);
		
		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
	        this.controller.save(horario);
	    });

	    assertEquals("save.obj.dtHorario: Informe o Horário!", exception.getMessage());	}
}*/
