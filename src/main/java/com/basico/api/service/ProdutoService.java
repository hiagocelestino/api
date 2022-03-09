package com.basico.api.service;

import java.util.Optional;


import com.basico.api.model.Produto;

public interface ProdutoService {
	
	public Iterable<Produto> obterTodosProdutos();
	
	public Optional<Produto> obterProdutoPeloId(Long id);
	
	public Produto cadastrarProduto(Produto produto);
	
	public Produto alterarProduto(Produto produto);
	
	public void deletarProduto(Long id);
}
