package br.itb.projeto.KitFit.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assinatura")
public class Assinatura {
	 @Id
	  @GeneratedValue
		(strategy = GenerationType.IDENTITY)
	  private 		long 			id;
	  private 		String 			nome;
	  private 		LocalDateTime	dataAssinatura;
	  private 		String 			usuario_id;
	  private 		String 			kit_id;
	  private 		String 			statusAssinatura;
	  
	  @OneToMany
	  @JoinColumn(name = "assinatura_id")
	  private Assinatura assinatura;
	  
	
	public String getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getKit_id() {
		return kit_id;
	}
	public void setKit_id(String kit_id) {
		this.kit_id = kit_id;
	}
	public String getStatusAssinatura() {
		return statusAssinatura;
	}
	public void setStatusAssinatura(String statusAssinatura) {
		this.statusAssinatura = statusAssinatura;
	}
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
		


}
