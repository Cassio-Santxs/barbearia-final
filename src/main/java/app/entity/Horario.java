package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    private String dtHorario;
    
    private String vlHorario;

    public String getVlHorario() {
		return vlHorario;
	}

	public void setVlHorario(String vlHorario) {
		this.vlHorario = vlHorario;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCliente")
	@JsonIgnoreProperties("horarios")
	private Cliente cliente;

    // Getters e setters

    public Long getId() {
        return idHorario;
    }

    public void setId(Long id) {
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
}