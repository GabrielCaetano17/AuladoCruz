package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.itb.projeto.KitFit.model.entity.Assinatura;
import br.itb.projeto.KitFit.model.entity.Mensalidade;

@Repository

public interface MensalidadeRepository 

				extends JpaRepository<Mensalidade, Long> {
					
		Mensalidade findByAssinatura(Assinatura assinatura);
	

		}
