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

import app.entity.Funcionario;
import app.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/funcionario")
@Validated
@CrossOrigin(originPatterns = "*")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Funcionario obj){
		
		try {
			String msg = this.funcionarioservice.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possível salvar:   "+ e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Funcionario>> listAll(){
		
		try {
			
			List<Funcionario> lista = this.funcionarioservice.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} 
		
	}
	
	@DeleteMapping("/deleteById/{idFuncionario}")
	public ResponseEntity<String> deleteById(@PathVariable long idFuncionario){
		
		try {
			
			String msg = this.funcionarioservice.deleteById(idFuncionario);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("update/{idFuncionario}")
	public ResponseEntity<String> update(@Valid @RequestBody Funcionario funcionario,@PathVariable long idFuncionario){
		
		try {
			String msg = this.funcionarioservice.update(funcionario, idFuncionario);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findById/{idFuncionario}")
	public ResponseEntity<Funcionario> findById(@PathVariable long idFuncionario){
		
		try {
			Funcionario funcionario = this.funcionarioservice.findById(idFuncionario);
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Funcionario>> findByNmFuncionario(@RequestParam String nome){
		
		try {
			List<Funcionario> lista = this.funcionarioservice.findByNmFuncionario(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			//rever
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}