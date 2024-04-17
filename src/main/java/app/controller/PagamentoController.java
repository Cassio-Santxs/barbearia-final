package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Pagamento;
import app.service.PagamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;
    
    @PostMapping("/save")
    public ResponseEntity<String> savePagamento(@Valid @RequestBody Pagamento pagamento) {
        try {
            pagamentoService.save(pagamento);
            String mensagem = "Pagamento salvo com sucesso!";
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            String mensagemErro = "Erro ao salvar o pagamento: " + e.getMessage();
            return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
        }
    }
}