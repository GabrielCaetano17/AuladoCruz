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
	private 	LocalDateTime 	dataAssinatura;
	private 	String			codigo;
	private 	String 			statusAssinatura;
	private     float         	valor;   
	
	@ManyToOne
	@JoinColumn(name = "emailUsu")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "kit_id")
	
	private Kit kit;

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
