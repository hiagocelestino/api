package com.basico.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.basico.api.model.Produto;
import com.basico.api.repository.ProdutoRepository;
import com.basico.api.service.ProdutoService;

@Component("ProdutoController")
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Iterable<Produto> obterTodosProdutos(){
		return produtoRepository.findAll();
		
	}
	
	public Optional<Produto> obterProdutoPeloId(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto alterarProduto(Produto produto) {
		try {
			System.out.println(produto.getId());
			System.out.println(produto.getNome());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getPreco());
			Optional<Produto> retorno = obterProdutoPeloId(produto.getId());
			if(retorno.isPresent()) {
				produtoRepository.save(produto);
				return produto;
			}
			else {
				throw new IllegalArgumentException("Não foi possível encontrar o produto.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível alterar o produto!");
		}
		
	}
	
	public void deletarProduto(Long id) {
		try {
			Optional<Produto> retorno = obterProdutoPeloId(id);
			if(retorno.isPresent()) {
				produtoRepository.deleteById(id);
			}
			else {
				throw new IllegalArgumentException("Não foi possível encontrar o produto.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível deletar o produto"); 
		}
	}

}
