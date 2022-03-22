package com.basico.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.dto.ProdutoDTO;
import com.basico.api.model.Produto;
import com.basico.api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService; 
	
	@GetMapping("/todos")
	public Iterable<Produto> obterTodosProdutos(){
		return produtoService.obterTodosProdutos();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterProdutoPeloId(@PathVariable Long id) {
		return produtoService.obterProdutoPeloId(id);
	}
	
	@PostMapping
	public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
		Produto produto = produtoDTO.toProduto();
		return ProdutoDTO.toDTO(produtoService.cadastrarProduto(produto));
	}
	
	@PutMapping
	public ProdutoDTO alterarProduto(@RequestBody Produto produto) {
		return ProdutoDTO.toDTO(produtoService.alterarProduto(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
	}
}
