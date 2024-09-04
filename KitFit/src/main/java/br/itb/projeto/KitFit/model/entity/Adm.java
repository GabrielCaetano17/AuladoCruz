package br.itb.projeto.KitFit.model.entity;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Adm")
public class Adm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String nome;
	private String email;
	private String senha;
	private String StatusAdm;
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getStatusAdm() {
		return StatusAdm;
	}
	public void setStatusAdm(String statusAdm) {
		StatusAdm = statusAdm;
	}
	
	
<<<<<<< HEAD
	//Obs
	public void setDataCadastro(LocalDateTime now) {
		// TODO Auto-generated method stub
	}
	
	
=======
>>>>>>> 320ab0badb12f87bfce2ed550ebf3109c328a682
	public List<Adm> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
=======
	public void setDataCadastro(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> 320ab0badb12f87bfce2ed550ebf3109c328a682
}
