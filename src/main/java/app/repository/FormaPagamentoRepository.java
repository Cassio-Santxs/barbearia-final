package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento , Long> {


	public List<FormaPagamento> findByNmFormaPagto(String nmFormaPagto);


}


