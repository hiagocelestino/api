package com.basico.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.model.Produto;
import com.basico.api.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoServiceImpl produtoServiceImpl; 
	
	@GetMapping
	public Iterable<Produto> obterTodosProdutos(){
		return produtoServiceImpl.obterTodosProdutos();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterProdutoPeloId(@PathVariable Long id) {
		return produtoServiceImpl.obterProdutoPeloId(id);
	}
	
	@PostMapping
	public Produto cadastrarProduto(Produto produto) {
		return produtoServiceImpl.cadastrarProduto(produto);
	}
	
	@PutMapping
	public Produto alterarProduto(Produto produto) {
		return produtoServiceImpl.alterarProduto(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoServiceImpl.deletarProduto(id);
	}
}
