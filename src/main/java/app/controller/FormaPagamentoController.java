package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.FormaPagamento;
import app.service.FormaPagamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/formaPagamento")
@Validated
@CrossOrigin(origins = "*")
public class FormaPagamentoController {


	@Autowired
	private FormaPagamentoService formaPagamentoService;


	@PostMapping("/save")
	public ResponseEntity<String> saveFormaPagamento(@Valid @RequestBody FormaPagamento formaPagamento){
		try {
			String msg = this.formaPagamentoService.save(formaPagamento);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possível salvar a forma de pagamento: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	@DeleteMapping("/delete/{idFormaPagto}")
	public ResponseEntity<String> deleteFormaPagamento(@PathVariable long idFormaPagto) {
		try {
			this.formaPagamentoService.delete(idFormaPagto);
			return new ResponseEntity<String>("Forma de pagamento deletada com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possível deletar a forma de pagamento: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	@PutMapping("/update/{idFormaPagto}")
	public ResponseEntity<String> updateFormaPagamento(@PathVariable long idFormaPagto,@Valid @RequestBody FormaPagamento formaPagamento) {
		try {
			formaPagamento.setIdFormaPagto(idFormaPagto);
			String msg = this.formaPagamentoService.update(formaPagamento, idFormaPagto);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possível atualizar a forma de pagamento: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/findAll")
	public ResponseEntity<List<FormaPagamento>> findAllFormaPagamento() {
		try {
			List<FormaPagamento> formaPagamento = this.formaPagamentoService.findAll();
			return new ResponseEntity<List<FormaPagamento>>(formaPagamento, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<FormaPagamento>>(HttpStatus.BAD_REQUEST);
		}
	}



	@GetMapping("/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable long idFormaPagto) {
		try {
			FormaPagamento formaPagamento = this.formaPagamentoService.findById(idFormaPagto);
			return ResponseEntity.ok(formaPagamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao buscar forma de pagamento: " + e.getMessage());
		}
	} 




	@GetMapping("/findByNome")
	public ResponseEntity<List<FormaPagamento>> findByNmFormaPagto(@RequestParam String nmFormaPagto) {
		try {
			List<FormaPagamento> formaPagamento = this.formaPagamentoService.findByNmFormaPagto(nmFormaPagto);
			return ResponseEntity.ok(formaPagamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}


}