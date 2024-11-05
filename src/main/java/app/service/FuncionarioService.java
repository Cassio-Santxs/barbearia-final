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
	
	@Autowired
    private PasswordService passwordService;
	
	public String save(Funcionario obj) throws Exception {
		
		if(obj == null)
			throw new RuntimeException();
		
		boolean emailVerificado = verifyEmail(obj.getDsEmail());
		
		if(!emailVerificado)
			throw new Exception("E-mail inválido!");
		
		obj.setUsername(obj.getDsEmail());
		obj.setDsSenha(passwordService.encodePassword(obj.getDsSenha()));
		
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
	public String update(Funcionario funcionario, long idFuncionario) throws Exception {
		funcionario.setIdFuncionario(idFuncionario);
		boolean emailVerificado = verifyEmail(funcionario.getDsEmail());
		
		if(!emailVerificado)
			throw new Exception("E-mail inválido!");
		
		funcionario.setUsername(funcionario.getDsEmail());
		funcionario.setDsSenha(passwordService.encodePassword(funcionario.getDsSenha()));
		
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
	
	public Boolean verifyEmail(String dsEmail) {
		boolean retorno = false;
		
		if(dsEmail.contains("@"))
			retorno = true;
		
		return retorno;
	}		
}