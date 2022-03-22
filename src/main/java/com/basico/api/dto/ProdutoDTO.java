package com.basico.api.dto;

import com.basico.api.model.Produto;

public class ProdutoDTO {
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	public ProdutoDTO(Long id, String nome, String descricao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public static ProdutoDTO toDTO(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
	}
	
	public Produto toProduto() {
		return new Produto(nome, descricao, preco); 
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
