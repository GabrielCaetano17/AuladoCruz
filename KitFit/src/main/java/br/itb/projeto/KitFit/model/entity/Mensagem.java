package br.itb.projeto.KitFit.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mensagem")
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	long 			id;
	private 	LocalDateTime 	dataMensagem;
	private 	String 			emissorMensagem;
	private 	String 			Nome;
	private 	String 			email ;
	private 	String 			telefone;
	private 	String 			texto;
	private 	String 			statusMensagem;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getDataMensagem() {
		return dataMensagem;
	}
	public void setDataMensagem(LocalDateTime dataMensagem) {
		this.dataMensagem = dataMensagem;
	}
	public String getEmissorMensagem() {
		return emissorMensagem;
	}
	public void setEmissorMensagem(String emissorMensagem) {
		this.emissorMensagem = emissorMensagem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getStatusMensagem() {
		return statusMensagem;
	}
	public void setStatusMensagem(String statusMensagem) {
		this.statusMensagem = statusMensagem;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}
