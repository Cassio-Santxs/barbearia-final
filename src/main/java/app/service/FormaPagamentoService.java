package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.FormaPagamento;
import app.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {


	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;



	public String save(FormaPagamento formaPagamento) {
		this.formaPagamentoRepository.save(formaPagamento);
		return "Forma de Pagamento Salva com Sucesso";
	}


	public String delete(long idFormaPagto) {
		this.formaPagamentoRepository.deleteById(idFormaPagto);	
		return "Forma de Pagamento Deletada com Sucesso";
	}



	public String update(FormaPagamento formaPagamento, long idFormaPagto) {
		formaPagamento.setIdFormaPagto(idFormaPagto);
		this.formaPagamentoRepository.save(formaPagamento);
		return "Forma de Pagamento Atualizada com Sucesso";
	}



	public List<FormaPagamento> findAll(){
		List<FormaPagamento> lista = this.formaPagamentoRepository.findAll();
		return lista;
	}



	public FormaPagamento findById(long idFormaPagto) {
		FormaPagamento formaPagamento = this.formaPagamentoRepository.findById(idFormaPagto).get();
		return formaPagamento;
	}


	public List<FormaPagamento> findByNmFormaPagto(String nmFormaPagto){
		return this.formaPagamentoRepository.findByNmFormaPagto(nmFormaPagto);
	}


}