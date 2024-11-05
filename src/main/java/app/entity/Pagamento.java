package app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPagamento;
	
	@NotNull(message = "Digite a Data de pagamento!")
	private LocalDate dtPagamento;
	
	@NotNull(message = "Informe o horário do pagamento!")
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
	@JsonIgnoreProperties("pagamento")
	private Horario horario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFormaPagto")
	@JsonIgnoreProperties("pagamentos")
	@NotNull(message = "Informe a forma de pagamento!")
	private FormaPagamento formaPagamento;
	
	@NotBlank(message = "Informe a situação do paganento!")
	private String dsSituacao;

	private double valor;

	
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	
	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public LocalDate getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(LocalDate dtPagamento) {
		this.dtPagamento = dtPagamento;
	}


	public String getDsSituacao() {
		return dsSituacao;
	}

	public void setDsSituacao(String dsSituacao) {
		this.dsSituacao = dsSituacao;
	}

	public Object getId() {
		return idPagamento;
	}

	 public double getValor() {
	        return valor;
	    }

	 public void setValor(double valor) {
	        this.valor = valor;
	    }
}