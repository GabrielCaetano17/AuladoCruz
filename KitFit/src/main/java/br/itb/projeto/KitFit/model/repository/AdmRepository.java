package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class AdmRepository {

	public interface ad extends 
	JpaRepository<Usuario, Long> {

Adm findByEmail(String emial);



}
}


