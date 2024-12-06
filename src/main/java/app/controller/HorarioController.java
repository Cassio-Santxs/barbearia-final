package app.controller;

import java.util.List;

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
import app.entity.Horario;
import app.service.HorarioService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/horario")
@CrossOrigin(originPatterns = "*")
public class HorarioController {

	@Autowired
	private HorarioService service;

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Horario obj) {
		try {
			String msg = this.service.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu algo de errado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @RequestBody Horario obj, @PathVariable int id) {
		try {
			String msg = this.service.update(id, obj);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possivel atualizar a lista. " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Horario>> listAll() {
		try {
			List<Horario> lista = this.service.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Horario> findById(@PathVariable long id) {
		try {
			Horario obj = this.service.findById(id);
			return new ResponseEntity<Horario>(obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String msg = this.service.delete(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByIdCliente/{idCliente}")
	public ResponseEntity<List<Horario>> findByIdCliente(@PathVariable Long idCliente){
		try {
			List<Horario> lista = this.service.findByIdCliente(idCliente);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
