package app.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import app.entity.Pagamento;
import app.service.PagamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagamento")
@Validated
@CrossOrigin(originPatterns = "*")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;
    
    @PostMapping("/save")
    public ResponseEntity<String> savePagamento(@Valid @RequestBody Pagamento pagamento) {
        try {
            pagamentoService.save(pagamento);
            String mensagem = "Pagamento salvo com sucesso!";
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable long id) {
        pagamentoService.deletePagamentoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<List<Pagamento>> listAll(){
        try {
            List<Pagamento> lista = this.pagamentoService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePagamento(@Valid @RequestBody Pagamento novoPagamento, @PathVariable Long id) {
        try {
            String msg = pagamentoService.updatePagamento(id, novoPagamento);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possível atualizar o pagamento. " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listByValue/{valor}")
    public ResponseEntity<List<Pagamento>> listByValue(@PathVariable double valor) {
        try {
            List<Pagamento> lista = this.pagamentoService.listByValue(valor);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
        try {
            Optional<Pagamento> pagamento = this.pagamentoService.findById(id);
            if (pagamento.isPresent()) {
                return new ResponseEntity<>(pagamento.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
