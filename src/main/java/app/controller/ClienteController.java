package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente obj){
		try {
			String msg = this.service.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu algo de errado: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Cliente obj, @PathVariable int id){
		try {
			String msg = this.service.update(id, obj);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possivel atualizar a lista. "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll(){
		try {
			List<Cliente> lista = this.service.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Cliente>findById(@PathVariable long id){
		try {
			Cliente obj = this.service.findById(id);
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String msg = this.service.delete(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nmCliente){
		try {
			List<Cliente> lista = this.service.findByNmCliente(nmCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findBydsCpf/{dscpf}")
	public ResponseEntity<List<Cliente>> findBydsCpf(@PathVariable String dscpf){
		try {
			List<Cliente> lista = this.service.findBydsCpf(dscpf);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	

}