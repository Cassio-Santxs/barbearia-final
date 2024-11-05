/*package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.FormaPagamento;
import app.repository.FormaPagamentoRepository;
import app.service.FormaPagamentoService;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class FormaPagamentoControllerTest {


	@Autowired
	FormaPagamentoController controller;

	@MockBean
	FormaPagamentoRepository repository;


	@BeforeEach
	void setup() {	

		List<FormaPagamento> list = new ArrayList<FormaPagamento>();
		FormaPagamento formaPagamento = new FormaPagamento();

		formaPagamento.setIdFormaPagto(1L);
		formaPagamento.setNmFormaPagto("Cartao");

		Optional<FormaPagamento> formaPagamentoOp = Optional.of(formaPagamento);

		list.add(formaPagamento);

		when(this.repository.save(formaPagamento)).thenReturn(formaPagamento);
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.findById(1L)).thenReturn(formaPagamentoOp);
		doNothing().when(this.repository).deleteById(1L);
	}





	@Test
	@DisplayName("teste do metodo save")
	void testSave() {

		FormaPagamento formaPagamento = new FormaPagamento();

		formaPagamento.setIdFormaPagto(1L);
		formaPagamento.setNmFormaPagto("Cartao");

		ResponseEntity<String> response = this.controller.saveFormaPagamento(formaPagamento);
		String msg = response.getBody();

		assertEquals("Forma de Pagamento Salva com Sucesso", msg);
	}




	@Test
	@DisplayName("teste no método update")
	void testUpdate() {

		FormaPagamento formaPagamento = new FormaPagamento();

		formaPagamento.setIdFormaPagto(1L);
		formaPagamento.setNmFormaPagto("Cartao");


		ResponseEntity<String> response = this.controller.updateFormaPagamento(1L, formaPagamento);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}






	@Test
	@DisplayName("teste no método delete")
	void testDelete() {

		ResponseEntity<String> response = this.controller.deleteFormaPagamento(2L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}




	@Test
	@DisplayName("teste no método findAll")
	void testFindAll() {

		ResponseEntity<List<FormaPagamento>> response = this.controller.findAllFormaPagamento();
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}




	@Test
	@DisplayName("test no método findById")
	void testFindById() {
		ResponseEntity<Object> response = this.controller.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}


	@Test
	@DisplayName("teste de Catch no método saveFormaPagamento com objeto nulo")
	void testSaveFormaPagamentoNulo() {
		FormaPagamentoService formaPagamentoServiceMock = Mockito.mock(FormaPagamentoService.class);

		when(formaPagamentoServiceMock.save(any(FormaPagamento.class))).thenThrow(new RuntimeException("Objeto nulo não é permitido"));

		FormaPagamentoController controller = new FormaPagamentoController();

		ResponseEntity<String> response = controller.saveFormaPagamento(null);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}



	@Test
	@DisplayName("teste de validação de @NotBlank para nmFormaPagto")
	void testNotBlankNmFormaPagto() {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setNmFormaPagto(""); 

		assertThrows(ConstraintViolationException.class, () -> {
			this.controller.saveFormaPagamento(formaPagamento);
		});
	}


	@Test
	@DisplayName("teste de Catch no método updateFormaPagamento com objeto nulo")
	void testUpdateFormaPagamentoNulo() {
		FormaPagamentoService formaPagamentoServiceMock = Mockito.mock(FormaPagamentoService.class);

		when(formaPagamentoServiceMock.update(any(FormaPagamento.class), any(Long.class))).thenThrow(new RuntimeException("Objeto nulo não é permitido"));

		FormaPagamentoController controller = new FormaPagamentoController();

		ResponseEntity<String> response = controller.updateFormaPagamento(1, null);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}


	@Test
	@DisplayName("teste no método findAllFormaPagamento")
	void testFindAllFormaPagamento() {
		FormaPagamentoService formaPagamentoServiceMock = Mockito.mock(FormaPagamentoService.class);

		when(formaPagamentoServiceMock.findAll()).thenThrow(new RuntimeException("Erro ao buscar formas de pagamento"));

		FormaPagamentoController controller = new FormaPagamentoController();

		ResponseEntity<List<FormaPagamento>> response = controller.findAllFormaPagamento();

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}


}*/