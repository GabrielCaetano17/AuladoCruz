package br.itb.projeto.KitFit.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Mensalidade")
public class Mensalidade {
	
	 @Id
	 @GeneratedValue
	 			(strategy = GenerationType.IDENTITY)
	  private long id;
	  private String mesRef;
	  private LocalDateTime dataVcto;
	  private LocalDateTime dataPgto;
	  private double valor;
	  private int assinatura_id;
	  private String statusMensalidade;

	  
		  public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getMesRef() {
			return mesRef;
		}
		public void setMesRef(String mesRef) {
			this.mesRef = mesRef;
		}
		
		public LocalDateTime getDataVcto() {
			return dataVcto;
		}
		public void setDataVcto(LocalDateTime dataVcto) {
			this.dataVcto = dataVcto;
		}
		public LocalDateTime getDataPgto() {
			return dataPgto;
		}
		public void setDataPgto(LocalDateTime dataPgto) {
			this.dataPgto = dataPgto;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		public int getAssinatura_id() {
			return assinatura_id;
		}
		public void setAssinatura_id(int assinatura_id) {
			this.assinatura_id = assinatura_id;
		}
		public String getStatusMensalidade() {
			return statusMensalidade;
		}
		public void setStatusMensalidade(String statusMensalidade) {
			this.statusMensalidade = statusMensalidade;
		}


}
