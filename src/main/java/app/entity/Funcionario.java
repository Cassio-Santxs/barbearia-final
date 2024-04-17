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
import jakarta.validation.constraints.NotNull;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@NotBlank(message = "informe o nome do funcionário. ")
	private String nmFuncionario;
	
	@NotNull(message = "informe se o usuario é adm ou não")
	private Boolean flFuncionario;
	
	@NotBlank(message = "informe o cpf do usuário")
	private String dsCpf;
	
	@NotBlank(message = "informe o email cadastrado. ")
	private String dsEmail;
	
	@NotBlank(message = "insira uma senha válida. ")
	private String dsSenha;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Horario> horarios;
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNmFuncionario() {
		return nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}

	public Boolean getFlFuncionario() {
		return flFuncionario;
	}

	public void setFlFuncionario(Boolean flFuncionario) {
		this.flFuncionario = flFuncionario;
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

	
	
	
	
}