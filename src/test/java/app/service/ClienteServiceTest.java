package app.service;

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

import app.entity.Cliente;
import app.repository.ClienteRepository;

@SpringBootTest()
public class ClienteServiceTest {

	@MockBean
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@BeforeEach
	void setup() {
		List<Cliente> list = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("TESTE Nome");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");
		list.add(cliente);
		Optional<Cliente> clienteOp = Optional.of(cliente);

		ClienteRepository repositoryMock = spy(ClienteRepository.class);

		when(repositoryMock.findAll()).thenReturn(list);
		when(repositoryMock.save(cliente)).thenReturn(cliente);
		when(repositoryMock.findById(1L)).thenReturn(clienteOp);
		doNothing().when(repositoryMock).deleteById(1L);
		when(repositoryMock.findByNmCliente("Teste")).thenReturn(list);
		when(repositoryMock.findBydsCpf("123")).thenReturn(list);
	}

	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		List<Cliente> lista = this.clienteService.listAll();

		assertEquals(0, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testSave() {
		Cliente cliente = new Cliente();
		cliente.setDsCpf("123");
		cliente.setIdCliente(1L);
		cliente.setNmCliente("teste nome");
		cliente.setDsEmail("Ivao");
		cliente.setDsSenha("cassol");

		String msg = this.clienteService.save(cliente);
		assertEquals(cliente.getNmCliente() + " Cliente salvo com sucesso.", msg);
	}
		
	@Test
	@DisplayName("teste unitario para confirmar se o email é real")
	void TestarEmail() {
		Boolean emailVerificado = clienteService.verifyEmail("teste@teste.com");
		assertEquals(true, emailVerificado);
	}
}