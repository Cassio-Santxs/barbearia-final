package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Log;
import app.repository.LogRepository;

@Service
public class LogService {
	
	@Autowired
	private LogRepository repository;
	
	public String save(Log obj) throws Exception {
		if(obj == null)
			throw new RuntimeException();
		
		this.repository.save(obj);
		return ("Salvo com sucesso!");
	}
	
	public String saveAll(List<Log> logs) {
        try {
            repository.saveAll(logs);
            return "Logs salvos com sucesso!";
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar logs: " + e.getMessage());
        }
    }
	
	public List<Log> listAll(){
		
		return this.repository.findAll();
	}
	
	public String deleteById(long idLog) {
		
		this.repository.deleteById(idLog);
		return ("Deletado com sucesso!");
		
	}
	
	public String update(Log log, long idLog) throws Exception {
		log.setIdLog(idLog);
		
		this.repository.save(log);
		
		return("Atualizado com sucesso!");
	}
	
	public Log findById(long idLog) {
		
		Log log = this.repository.findById(idLog).get();
		return log;
	}		
}