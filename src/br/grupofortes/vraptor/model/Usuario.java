package br.grupofortes.vraptor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private String login;
	private String senha;
	private String nome;
	private Date nasc;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNasc() {
		return nasc;
	}
	
	
	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}
	public void setNasc(long nasc) {
		this.nasc = new Date(nasc);
	}
	
	
	
	
	
	
	
	
}
