package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLog;
	
	private String vlAntigo;
	
	private String vlNovo;
	
	@NotBlank(message = "Informe a tabela do registro")
	private String dsTabela;
	
	@NotBlank(message = "Informe a coluna do registro")
	private String dsColuna;
	
	@NotBlank(message = "Informe a data de alteração do registro")
	private String dtAlteracao;
	
	@NotBlank(message = "Informe o e-mail do usuário que fez a alteração!")
	private String dsEmailUsuario;

	public Long getIdLog() {
		return idLog;
	}

	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}

	public String getVlAntigo() {
		return vlAntigo;
	}

	public void setVlAntigo(String vlAntigo) {
		this.vlAntigo = vlAntigo;
	}

	public String getVlNovo() {
		return vlNovo;
	}

	public void setVlNovo(String vlNovo) {
		this.vlNovo = vlNovo;
	}

	public String getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(String dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getDsEmailUsuario() {
		return dsEmailUsuario;
	}

	public void setDsEmailUsuario(String dsEmailUsuario) {
		this.dsEmailUsuario = dsEmailUsuario;
	}

	public String getDsTabela() {
		return dsTabela;
	}

	public void setDsTabela(String dsTabela) {
		this.dsTabela = dsTabela;
	}

	public String getDsColuna() {
		return dsColuna;
	}

	public void setDsColuna(String dsColuna) {
		this.dsColuna = dsColuna;
	}
	
	
	
}