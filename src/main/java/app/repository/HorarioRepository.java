package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Horario;


public interface HorarioRepository extends JpaRepository<Horario, Long> {

}