package br.itb.projeto.KitFit.model.repository;
import br.itb.projeto.KitFit.model.entity.Adm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class AdmRepository {

	public interface adm extends 
	JpaRepository<Adm, Long> {

		Adm findByEmail(String emial);



}

	public Adm findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Adm save(Adm adm) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Adm> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
		Object findById(long id) {
=======
	public Object findById(long id) {
>>>>>>> 320ab0badb12f87bfce2ed550ebf3109c328a682
		// TODO Auto-generated method stub
		return null;
	}
}


