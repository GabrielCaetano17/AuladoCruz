package br.itb.projeto.KitFit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.itb.projeto.KitFit.model.entity.Produto;
import br.itb.projeto.KitFit.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;



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
	
	public Produto findById(long id) {
		Produto produto = produtoRepository
				.findById(id).orElseThrow();
		
		return produto;
	}
	
	@Transactional
	public Produto create(Produto produto) {
		
		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto inativa(long id) {
		
		Optional<Produto> _produto = produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			produtoAtualizado.setStatusProd("INATIVA");
			
			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	

	@Transactional
	public Produto alterar(long id, Produto produto) {
		
		Optional<Produto> _produto = produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			
			produtoAtualizado.setPreco(produto.getPreco());
			
			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	
	
}
