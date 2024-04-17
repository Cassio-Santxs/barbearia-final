package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@SpringBootTest()
public class ClienteControllerTest {
	@MockBean
	private ClienteRepository repository;

	@Autowired
	private ClienteController controller;

	@BeforeEach // é usado em testes unitários em teste unitarios java,particulamente com Junit
	void setup() {
		List<Cliente> list = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE ");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		list.add(cliente); // adicionando os dados de cima ao objeto cliente
		Optional<Cliente> clienteOp = Optional.of(cliente);
	
		/// subestitui o banco de dados real
		ClienteRepository repositoryMock = spy(ClienteRepository.class); 
	 /// when define o comportamento do mock
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(cliente)).thenReturn(cliente);
		when(this.repository.findById(1L)).thenReturn(clienteOp);
		doNothing().when(repositoryMock).deleteById(1L);
		when(this.repository.findByNmCliente("TESTE")).thenReturn(list);
		when(this.repository.findBydsCpf("123")).thenReturn(list);

	}

	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		ResponseEntity<List<Cliente>> response = this.controller.listAll();
		List<Cliente> lista = response.getBody();
		 //teste se minha função esta funcionando como esperado
		assertEquals(1, lista.size());

	}

	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testsave() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("teste nome");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");

		ResponseEntity<String> response = this.controller.save(cliente);
		String mensagem = response.getBody();

		assertEquals("teste nome Cliente salvo com sucesso.", mensagem);
	}

	@Test
	@DisplayName("TESTE MÉTODO update()")
	void testUpdate() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("Teste Client");
		cliente.setDsEmail("cassol");
		cliente.setDsSenha("SENHA");

		ResponseEntity<String> response = this.controller.update(cliente, 1);
		String msg = response.getBody();

		assertEquals("Sucesso!", msg);
	}

	@Test
	@DisplayName("TESTE MÉTODO findById()")
	void testFindById() {
		ResponseEntity<Cliente> response = this.controller.findById(1L);
		Cliente obj = response.getBody();

		assertEquals("123", obj.getDsCpf());
	}

	@Test
	@DisplayName("TESTE MÉTODO delete()")
	void testDelete() {
		// Chama o método delete() do controlador
		ResponseEntity<String> response = this.controller.delete(1L);

		// Verifica se o status da resposta é o esperado (por exemplo, 200 OK)
		assertEquals(HttpStatus.OK, response.getStatusCode(), "O status da resposta deve ser OK");

		// Verifica se a mensagem retornada está correta
		String msg = response.getBody();
		assertEquals("Cliente deletado com sucesso", msg,
				"A mensagem deve indicar que o cliente foi deletado com sucesso");
	}

	@Test
	@DisplayName("TESTE MÉTODO findByNome()")
	void testFindByNmCliente() {
		ResponseEntity<List<Cliente>> response = this.controller.findByNome("Teste");
		List<Cliente> lista = response.getBody();

		assertEquals(0, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO findByCpf()")
	void testFindByLowerPreco() {
		ResponseEntity<List<Cliente>> response = this.controller.findBydsCpf("123");
		List<Cliente> lista = response.getBody();

		assertEquals(1, lista.size());
	}

}