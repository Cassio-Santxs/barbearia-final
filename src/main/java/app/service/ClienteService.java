package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public String save(Cliente obj) {
		this.clienteRepository.save(obj);
		return obj.getNmCliente() + " Cliente salvo com sucesso.";
	}

	public List<Cliente> listAll() {
		return this.clienteRepository.findAll();
	}

		public String update(long id, Cliente obj) {
			obj.setIdCliente(id);
			this.clienteRepository.save(obj);
			return "Sucesso!";
		}
	

	public Cliente findById(long id) {
		return this.clienteRepository.findById(id).orElse(null);
	}

	public String delete(long id) {
		this.clienteRepository.deleteById(id);
		return "Cliente deletado com sucesso";
	}

	public List<Cliente> findByNmCliente(String NmCliente) {
		return this.clienteRepository.findByNmCliente(NmCliente);
	}

	public List<Cliente> findBydsCpf(String dscpf) {
		return this.clienteRepository.findBydsCpf(dscpf);
	}
}