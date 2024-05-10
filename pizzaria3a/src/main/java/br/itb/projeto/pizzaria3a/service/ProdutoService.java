package br.itb.projeto.pizzaria3a.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.itb.projeto.pizzaria3a.model.entity.Produto;
import br.itb.projeto.pizzaria3a.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	public List<Produto> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	  }
}
