package app.controller;

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

import app.entity.FormaPagamento;
import app.repository.FormaPagamentoRepository;

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
		formaPagamento.setNmFormaPagto("Joao");

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
		formaPagamento.setNmFormaPagto("Joao");

		ResponseEntity<String> response = this.controller.saveFormaPagamento(formaPagamento);
		String msg = response.getBody();

		assertEquals("Forma de Pagamento Salva com Sucesso", msg);
	}




	@Test
	@DisplayName("teste no método update")
	void testUpdate() {

		FormaPagamento formaPagamento = new FormaPagamento();

		formaPagamento.setIdFormaPagto(1L);
		formaPagamento.setNmFormaPagto("Joao");


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






}