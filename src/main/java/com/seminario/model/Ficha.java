package com.seminario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ficha implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Preechimento do campo Nome é obrigatório.")
	private String nome;

	@NotBlank(message = "Preenchimento do campo Data de Nascimento é obrigatório.")
	@Size(min=10, message = "Tamanho do campo Data de Nascimento inválido")
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	private String dataNascimento;
	
	@NotBlank(message = "Preechimento do campo Paróquia é obrigatório.")
	private String paroquia;
	
	@NotBlank(message = "Preechimento do campo Endereço é obrigatório.")
	private String endereco;
	
	@NotBlank(message = "Preechimento do campo Telefone é obrigatório.")
	@Size(min = 14, message = "Tamanho do campo Telefone inválido")
	private String telefone;
	
	@NotBlank(message = "Preechimento do campo Valor Mensal de Contribuição é obrigatório.")
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