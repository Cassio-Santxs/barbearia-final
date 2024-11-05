package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class FormaPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormaPagto;

	@NotBlank(message = "Informe o nome da forma de pagamento!")
	private String nmFormaPagto;

	@OneToMany(mappedBy = "formaPagamento", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Pagamento> pagamentos;


	public long getIdFormaPagto() {
		return idFormaPagto;
	}

	public void setIdFormaPagto(long idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	public String getNmFormaPagto() {
		return nmFormaPagto;
	}

	public void setNmFormaPagto(String nmFormaPagto) {
		this.nmFormaPagto = nmFormaPagto;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}


}