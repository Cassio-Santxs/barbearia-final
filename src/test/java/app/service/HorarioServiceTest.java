package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Horario;
import app.repository.HorarioRepository;

@SpringBootTest
public class HorarioServiceTest {
	
	@Autowired
	HorarioService service;
	
    @MockBean
    private HorarioRepository repository;
	
	@BeforeEach
    void setUp() {

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
        funcionario.setDsEmail("brenofoda@gmail.com");
        funcionario.setDsSenha("123123");

        Horario horario = new Horario();
        horario.setIdHorario(1L);
        horario.setDtHorario("01/01/0001");
        horario.setVlHorario(20);
        horario.setCliente(cliente);
        horario.setFuncionario(funcionario);
        list.add(horario);
        
        when(this.repository.checkHorarioExist(1L, "01/01/2024")).thenReturn(list);
    }
	
	@Test
	@DisplayName("TESTE MÉTODO checkHorarioValid()")
	void testFindByLowerPreco() {
		List<Horario> response = this.service.checkHorarioExist(1L, "01/01/2024");
		
		assertEquals(1, response.size());
	}
}
