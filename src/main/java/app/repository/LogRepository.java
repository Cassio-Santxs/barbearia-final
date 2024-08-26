package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}