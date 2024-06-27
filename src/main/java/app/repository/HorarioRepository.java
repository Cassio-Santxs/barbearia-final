package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
	
	@Query("SELECT h FROM Horario h WHERE h.funcionario.idFuncionario = :idFuncionario AND h.dtHorario = :horario")
	public List<Horario> checkHorarioExist(Long idFuncionario, String horario);
	
	@Query("SELECT h FROM Horario h WHERE h.cliente.idCliente = :idCliente")
	public List<Horario> findByIdCliente(Long idCliente);

}