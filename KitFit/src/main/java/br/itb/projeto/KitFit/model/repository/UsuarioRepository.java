package br.itb.projeto.KitFit.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.KitFit.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends 
						JpaRepository<Usuario, Long> {
	
	 Usuario findByEmail(String email);
	 
	 Usuario findAllById(long id);

	List<Usuario> findByStatusUsuario(String status);
	
}
