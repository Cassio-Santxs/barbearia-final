package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Horario;
import app.entity.Pagamento;
import app.repository.PagamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public void save(Pagamento pagamento) throws Exception {
        if (isHorarioDisponivel(pagamento.getHorario())) {
            pagamentoRepository.save(pagamento);
        } else {
            throw new Exception("Horário já está ocupado.");
        }
    }

    public void deletePagamentoById(long id) {
        pagamentoRepository.deleteById(id);
    }

    public List<Pagamento> listAll() {
        return pagamentoRepository.findAll();
    }

    public String updatePagamento(Long id, Pagamento novoPagamento) throws Exception {
        Optional<Pagamento> pagamentoExistente = pagamentoRepository.findById(id);
        if (pagamentoExistente.isPresent()) {
            if (isHorarioDisponivel(novoPagamento.getHorario(), id)) {
                Pagamento pagamento = pagamentoExistente.get();
                pagamento.setHorario(novoPagamento.getHorario());
                pagamento.setDtPagamento(novoPagamento.getDtPagamento());
                pagamento.setFormaPagamento(novoPagamento.getFormaPagamento());
                pagamento.setDsSituacao(novoPagamento.getDsSituacao());
                pagamentoRepository.save(pagamento);
                return "Pagamento atualizado com sucesso!";
            } else {
                throw new Exception("Horário já está ocupado.");
            }
        } else {
            throw new Exception("Pagamento não encontrado.");
        }
    }

    public List<Pagamento> listByValue(double valor) {
        return pagamentoRepository.findByValor(valor);
    }
    public Optional<Pagamento> findById(Long id) {
        return pagamentoRepository.findById(id);
    }

    private boolean isHorarioDisponivel(Horario horario) {
        return pagamentoRepository.findByHorario(horario).isEmpty();
    }

    private boolean isHorarioDisponivel(Horario horario, Long id) {
        Optional<Pagamento> pagamentoExistente = pagamentoRepository.findByHorario(horario);
        return pagamentoExistente.isEmpty() || pagamentoExistente.get().getIdPagamento().equals(id);
    }

	public boolean checkValuePayment(int i) {
		// TODO Auto-generated method stub
		return false;
	}
}