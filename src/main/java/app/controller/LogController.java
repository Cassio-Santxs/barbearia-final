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
import org.springframework.web.bind.annotation.RestController;

import app.entity.Log;
import app.service.LogService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/log")
@Validated
@CrossOrigin(origins = "*")
public class LogController {
	
	@Autowired
	private LogService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Log obj){
		
		try {
			String msg = this.service.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possível salvar:   "+ e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<String> saveAll(@Valid @RequestBody List<Log> logs) {
	    try {
	        String msg = this.service.saveAll(logs);
	        return new ResponseEntity<>(msg, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Não foi possível salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Log>> listAll(){
		
		try {
			
			List<Log> lista = this.service.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} 
		
	}
	
	@DeleteMapping("/deleteById/{idLog}")
	public ResponseEntity<String> deleteById(@PathVariable long idLog){
		try {
			String msg = this.service.deleteById(idLog);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("update/{idLog}")
	public ResponseEntity<String> update(@Valid @RequestBody Log log,@PathVariable long idLog){
		try {
			String msg = this.service.update(log, idLog);
			return new ResponseEntity<>(msg, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findById/{idLog}")
	public ResponseEntity<Log> findById(@PathVariable long idLog){
		try {
			Log log = this.service.findById(idLog);
			return new ResponseEntity<>(log, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}