package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import app.entity.FormaPagamento;
import app.entity.Funcionario;
import app.entity.Horario;
import app.entity.Pagamento;
import app.repository.PagamentoRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class PagamentoControllerTest {

    @MockBean
    private PagamentoRepository repository;

    @Autowired
    private PagamentoController controller;

    @BeforeEach
    void setup() {
        List<Pagamento> list = new ArrayList<>();

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdFormaPagto(1L);
        formaPagamento.setNmFormaPagto("Cartão de Crédito");

        Horario horario = new Horario();
        horario.setIdHorario(1L);

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1L);
        pagamento.setDtPagamento(LocalDate.now());
        pagamento.setHorario(horario);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setDsSituacao("Pago");

        list.add(pagamento);

        Optional<Pagamento> pagamentoOp = Optional.of(pagamento);

        when(repository.findAll()).thenReturn(list);
        when(repository.save(pagamento)).thenReturn(pagamento);
        when(repository.findById(1L)).thenReturn(pagamentoOp);
        doNothing().when(repository).deleteById(1L);
    }

    @Test
    @DisplayName("Teste método listAll()")
    void testListAll() {
        ResponseEntity<List<Pagamento>> response = controller.listAll();
        List<Pagamento> lista = response.getBody();
        assertEquals(1, lista.size());
    }

    @Test
    @DisplayName("Teste método save()")
    void testSave() {
    	FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdFormaPagto(1L);
        formaPagamento.setNmFormaPagto("Cartão de Crédito");

        Horario horario = new Horario();
        horario.setIdHorario(1L);

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1L);
        pagamento.setDtPagamento(LocalDate.now());
        pagamento.setHorario(horario);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setDsSituacao("Pago");
        
        ResponseEntity<String> response = controller.savePagamento(pagamento);
        String mensagem = response.getBody();
        assertEquals("Pagamento salvo com sucesso!", mensagem);
    }

    @Test
    @DisplayName("Teste método update()")
    void testUpdate() {
    	FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdFormaPagto(1L);
        formaPagamento.setNmFormaPagto("Cartão de Crédito");

        Horario horario = new Horario();
        horario.setIdHorario(1L);

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1L);
        pagamento.setDtPagamento(LocalDate.now());
        pagamento.setHorario(horario);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setDsSituacao("Pago");
        ResponseEntity<String> response = controller.updatePagamento(pagamento, 1L);
        String msg = response.getBody();
        assertEquals("Pagamento atualizado com sucesso!", msg);
    }

    @Test
    @DisplayName("Teste método findById()")
    void testFindById() {
        ResponseEntity<Pagamento> response = controller.findById(1L);
        Pagamento obj = response.getBody();
        assertEquals("Pago", obj.getDsSituacao());
    }

    @SuppressWarnings("deprecation")
	@Test
    @DisplayName("Teste método delete()")
    void testDelete() {
        ResponseEntity<Void> response = controller.deletePagamento(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
    @Test
    @DisplayName("Teste método save() com BadRequest")
    void testSaveWithBadRequest() {
    	FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdFormaPagto(1L);
        formaPagamento.setNmFormaPagto("Cartão de Crédito");

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
        
    	Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1L);
        pagamento.setDtPagamento(LocalDate.now());
        pagamento.setHorario(horario);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setDsSituacao(null);
        
        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
	        this.controller.savePagamento(pagamento);
	    });

	    assertEquals("savePagamento.pagamento.dsSituacao: Informe a situação do paganento!", exception.getMessage());
    }

    @Test
    @DisplayName("Teste método update() com BadRequest")
    void testUpdateWithBadRequest() {
    	FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setIdFormaPagto(1L);
        formaPagamento.setNmFormaPagto("Cartão de Crédito");

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
        
    	Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1L);
        pagamento.setDtPagamento(LocalDate.now());
        pagamento.setHorario(horario);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setDsSituacao(null);
        
        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
	        this.controller.updatePagamento(pagamento, pagamento.getIdPagamento());
	    });

	    assertEquals("updatePagamento.novoPagamento.dsSituacao: Informe a situação do paganento!", exception.getMessage());
    }
}