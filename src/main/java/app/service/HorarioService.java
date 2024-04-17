package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Horario;
import app.repository.HorarioRepository;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository repository;

	public String save(Horario obj) {
		this.repository.save(obj);
		return "Horario salvo com sucesso.";
	}

	public List<Horario> listAll() {
		return this.repository.findAll();
	}

		public String update(long id, Horario obj) {
			obj.setIdHorario(id);
			this.repository.save(obj);
			return "Sucesso!";
		}
	

	public Horario findById(long id) {
		return this.repository.findById(id).orElse(null);
	}

	public String delete(long id) {
		this.repository.deleteById(id);
		return "Horario deletado com sucesso";
	}
}
