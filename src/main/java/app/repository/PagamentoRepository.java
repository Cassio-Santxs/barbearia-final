package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Não é necessário adicionar um método save aqui, pois ele é fornecido por padrão pelo JpaRepository.
    // Outros métodos personalizados podem ser adicionados, se necessário.
}