package app.service;

import java.util.List;
import java.util.Optional;

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
    public void deletePagamentoById(Long id) {
        pagamentoRepository.deleteByIdPagamento(id);
    }
    public List<Pagamento> listAll() {
        return pagamentoRepository.findAll();
    }
    public String updatePagamento(Long id, Pagamento novoPagamento) {
        Pagamento pagamentoExistente = pagamentoRepository.findById(id).orElse(null);
        if (pagamentoExistente != null) {
            // Atualizar os campos relevantes do pagamento existente com os valores do novo pagamento
            pagamentoExistente.setDtPagamento(novoPagamento.getDtPagamento());
            pagamentoExistente.setHorario(novoPagamento.getHorario());
            pagamentoExistente.setFormaPagamento(novoPagamento.getFormaPagamento());
            pagamentoExistente.setDsSituacao(novoPagamento.getDsSituacao());

            // Salvar as alterações no banco de dados
            pagamentoRepository.save(pagamentoExistente);
            return "Pagamento atualizado com sucesso!";
        } else {
            return "Pagamento não encontrado.";
        }
    }
	public String savePagamento(Pagamento novoPagamento) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Pagamento> listByValue(double valor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Optional<Pagamento> findById(Long id) {
	        return pagamentoRepository.findById(id);
    }
	 
	public boolean checkValuePayment(double vlPagamento) {
		boolean retorno = true;
		
		if(vlPagamento <= 0)
			retorno = false;
		
		return retorno;
	}
}