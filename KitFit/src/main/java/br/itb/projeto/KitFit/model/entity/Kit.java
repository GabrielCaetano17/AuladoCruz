package br.itb.projeto.KitFit.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kit")
public class Kit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	long 	id;
	private 	String 	nome;
	private 	String 	descricao;
	private 	String 	produtos;
	private 	byte[] 	foto;
	private 	double 	preco;
	private 	String 	statusKit;
	
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getProdutos() {
		return produtos;
	}
	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getStatusKit() {
		return statusKit;
	}
	public void setStatusKit(String statusKit) {
		this.statusKit = statusKit;
	}

}
