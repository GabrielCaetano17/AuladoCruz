package br.itb.projeto.KitFit.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kit")
public class Kit {
	
	@Id
	  @GeneratedValue
	  (strategy = GenerationType.IDENTITY)
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Assinatura assinatura;
	private String 	statusProd;
	
	
	private long id;
	private String nome;
	private String descricao;
	private String produtos;
	private byte[] foto; 
	private String urlFoto;
	private double preco;
	private String StatusKit;
	
	public String getProdutos() {
		return produtos;
	}
	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	public String getStatusKit() {
		return StatusKit;
	}
	public void setStatusKit(String statusKit) {
		StatusKit = statusKit;
	}
	
	public Assinatura getCategoria() {
		return assinatura;
	}
	public void setCategoria(Assinatura assinatura) {
		this.assinatura = assinatura;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigoBarras() {
		return produtos;
	}
	public void setCodigoBarras(String produtos) {
		this.produtos = produtos;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getStatusProd() {
		return statusProd;
	}
	public void setStatusProd(String statusProd) {
		this.statusProd = statusProd;
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
}
