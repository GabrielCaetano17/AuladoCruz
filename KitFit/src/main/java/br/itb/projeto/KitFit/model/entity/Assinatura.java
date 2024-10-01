package br.itb.projeto.KitFit.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assinatura")
public class Assinatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	long 			id;
	private 	String			nome;
	private 	LocalDateTime 	dataAssinatura;
	private 	String 			statusAssinatura;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "kit_id")
	private Kit kit;
	
	

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

	public LocalDateTime getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(LocalDateTime dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public String getStatusAssinatura() {
		return statusAssinatura;
	}

	public void setStatusAssinatura(String statusAssinatura) {
		this.statusAssinatura = statusAssinatura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

}
