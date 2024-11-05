package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordService passwordService;

    public String save(Cliente obj) {
        // Criptografa a senha antes de salvar
        obj.setDsSenha(passwordService.encodePassword(obj.getDsSenha()));
        obj.setUsername(obj.getDsEmail()); // Atribui dsEmail para username

        clienteRepository.save(obj); // Salvando o cliente no repositório

        return obj.getNmCliente() + " Cliente salvo com sucesso.";
    }

    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public String update(long id, Cliente obj) {
    	obj.setDsSenha(passwordService.encodePassword(obj.getDsSenha()));
        obj.setUsername(obj.getDsEmail());
        obj.setIdCliente(id);
        clienteRepository.save(obj);
        return "Cliente atualizado com sucesso!";
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public String delete(long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso";
    }

    public List<Cliente> findByNmCliente(String nmCliente) {
        return clienteRepository.findByNmCliente(nmCliente);
    }
	
	public Optional<Cliente> findByUsername(String username) {
		return this.clienteRepository.findByUsername(username);
	}

    public List<Cliente> findByDsCpf(String dsCpf) {
        return clienteRepository.findBydsCpf(dsCpf);
    }

    public Boolean verifyEmail(String dsEmail) {
        return dsEmail.contains("@");
    }
}