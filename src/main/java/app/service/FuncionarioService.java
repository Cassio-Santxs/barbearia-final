package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	
	@Autowired
	private FuncionarioRepository repository;
	
	public String save(Funcionario obj) {
		
		if(obj == null)
			throw new RuntimeException();
		
		this.repository.save(obj);
		return ("Salvo com sucesso!");
	}
	
	
	
	public List<Funcionario> listAll(){
		
		return this.repository.findAll();
	}
	public String deleteById(long idFuncionario) {
		
		this.repository.deleteById(idFuncionario);
		return ("Deletado com sucesso!");
		
	}
	public String update(Funcionario funcionario, long idFuncionario) {
		
		funcionario.setIdFuncionario(idFuncionario);
		this.repository.save(funcionario);
		return("Atualizado com sucesso!");
	}
	public Funcionario findById(long idFuncionario) {
		
		Funcionario funcionario = this.repository.findById(idFuncionario).get();
		return funcionario;
	}
	public List<Funcionario> findByNmFuncionario(String nmFuncionario){
		
		List<Funcionario> lista = this.repository.findByNmFuncionario(nmFuncionario);
		return lista;
		
	}
}