package app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import app.entity.Cliente;
import app.service.ClienteService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Cliente obj){
		try {
			String msg = this.service.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu algo de errado: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @RequestBody Cliente obj, @PathVariable int id){
		try {
			String msg = this.service.update(id, obj);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possivel atualizar a lista. "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('cliente')")
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
	
	@GetMapping("/findByNome/{nmCliente}")
	public ResponseEntity<List<Cliente>> findByNmCliente(@PathVariable String nmCliente){
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
			List<Cliente> lista = this.service.findByDsCpf(dscpf);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByUsername/{username}")
	public ResponseEntity<Optional<Cliente>> findByUsername(@PathVariable String username){
		try {
			Optional<Cliente> lista = this.service.findByUsername(username);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	

}