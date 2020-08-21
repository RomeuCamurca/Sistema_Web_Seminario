package com.seminario.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Usuario implements UserDetails, Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String login;
	
	private String nomecompleto;
	
	private String telefone;
	
	private String email;
	
	private String senha;
	
	private String permissao;
	

	public Usuario() {
		
	}
	
	public Usuario(long id, String login, String nomecompleto, String telefone, String email, String senha, String permissao) {
		this.id = id;
		this.login = login;
		this.nomecompleto = nomecompleto;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.permissao = permissao;
	}

	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable( 
	        name = "usuario_roles", 
	        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	@JsonManagedReference
	private List<Role> roles;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>)this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
