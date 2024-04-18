package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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

import app.entity.FormaPagamento;
import app.entity.Horario;
import app.entity.Pagamento;
import app.repository.PagamentoRepository;

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
        pagamento.setDtPagamento(LocalDateTime.now());
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
        Pagamento pagamento = new Pagamento();
        ResponseEntity<String> response = controller.savePagamento(pagamento);
        String mensagem = response.getBody();
        assertEquals("Pagamento salvo com sucesso!", mensagem);
    }

    @Test
    @DisplayName("Teste método update()")
    void testUpdate() {
        Pagamento pagamento = new Pagamento();
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
}