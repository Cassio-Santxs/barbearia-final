package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Pagamento;
import app.repository.PagamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional
    public Pagamento save(Pagamento pagamento) {
        if (pagamento == null) {
            throw new IllegalArgumentException("Objeto de pagamento não pode ser nulo");
        }

        return pagamentoRepository.save(pagamento);
    }
}