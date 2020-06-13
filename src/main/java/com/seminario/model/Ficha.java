package com.seminario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Ficha implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Preechimento do campo Nome é obrigatório.")
	@Pattern(regexp = "^([\\'\\.\\^\\~\\´\\`\\\\áÁ\\\\àÀ\\\\ãÃ\\\\âÂ"
			+ "\\\\éÉ\\\\èÈ\\\\êÊ\\\\íÍ\\\\ìÌ\\\\óÓ\\\\òÒ\\\\õÕ\\\\ôÔ"
			+ "\\\\úÚ\\\\ùÙ\\\\çÇaA-zZ]+)+((\\s[\\'\\.\\^\\~\\´\\`\\\\áÁ"
			+ "\\\\àÀ\\\\ãÃ\\\\âÂ\\\\éÉ\\\\èÈ\\\\êÊ\\\\íÍ\\\\ìÌ\\\\óÓ\\\\òÒ"
			+ "\\\\õÕ\\\\ôÔ\\\\úÚ\\\\ùÙ\\\\çÇaA-zZ]+)+)?$", message ="Nome inválido")
	@Size(min=5, max=200, message = "Digite um Nome entre {min} e {max} caracteres")
	private String nome;

	@NotBlank(message = "Preenchimento do campo Data de Nascimento é obrigatório.")
	@Size(min=10, message = "Tamanho do campo Data de Nascimento inválido")
	@Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}" , message = "Data inválida") 
	private String dataNascimento;
	
	@NotBlank(message = "Preechimento do campo Paróquia é obrigatório.")
	private String paroquia;
	
	@NotBlank(message = "Preechimento do campo Endereço é obrigatório.")
	@Size(min=10, max=200, message = "Digite um Endereço entre {min} e {max} caracteres")
	private String endereco;
	
	@NotBlank(message = "Preechimento do campo Telefone é obrigatório.")
	@Size(min = 14, message = "Tamanho do campo Telefone inválido")
	private String telefone;
	
	@NotBlank(message = "Preechimento do campo Valor Mensal de Contribuição é obrigatório.")
	@Size(min=8, max=30, message = "Digite um ValorMensal entre {min} e {max} caracteres")
	private String valorMensal;
	
	@NotBlank(message = "Preechimento do campo Forma de Pagamento é obrigatório.")
	private String formaPagamento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {	
		this.dataNascimento = dataNascimento;
	}
	public String getParoquia() {
		return paroquia;
	}
	public void setParoquia(String paroquia) {
		this.paroquia = paroquia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(String valorMensal) {
		this.valorMensal = valorMensal;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}