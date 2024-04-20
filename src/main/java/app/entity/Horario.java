package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @NotBlank(message = "Informe o Horário!")
    private String dtHorario;
    
    @NotNull(message = "Informe o valor do Horário!")
    private double vlHorario;

    public double getVlHorario() {
		return vlHorario;
	}

	public void setVlHorario(double vlHorario) {
		this.vlHorario = vlHorario;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCliente")
	@JsonIgnoreProperties("horarios")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idFuncionario")
	@JsonIgnoreProperties("horarios")
	@NotNull(message = "Informe um barbeiro para o horário")
	private Funcionario funcionario;

    // Getters e setters

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long id) {
        this.idHorario = id;
    }

    public String getDtHorario() {
        return dtHorario;
    }

    public void setDtHorario(String dtHorario) {
        this.dtHorario = dtHorario;
    }

	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
    
    
}