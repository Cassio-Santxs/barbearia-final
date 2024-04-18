package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Horario;


public interface HorarioRepository extends JpaRepository<Horario, Long> {
	@Query("FROM Horario WHERE vlHorario < :valor")
	public List<Horario> findByLowerPreco (double valor);
}