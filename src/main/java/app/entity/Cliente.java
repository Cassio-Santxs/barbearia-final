package app.entity;

import java.util.ArrayList;
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
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;

	@NotBlank(message = "Informe o nome do Cliente!")
	private String nmCliente;

	@NotBlank(message = "Informe o CPF do Cliente!")
	private String dsCpf;

	@NotBlank(message = "Informe o Login do Cliente!")
	private String dsEmail;

	@NotBlank(message = "Informe a senha do Cliente!")
	private String dsSenha;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Horario> horarios;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getDsCpf() {
		return dsCpf;
	}

	public void setDsCpf(String dsCpf) {
		this.dsCpf = dsCpf;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	
	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
}