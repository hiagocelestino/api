package com.basico.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itens_pedido")
	private Long id;
	
	@Column(name = "preco_un")
	@Min(0)
	private Double precoUn;
	
	@Column(name = "quantidade")
	@Min(0)
	private int quantidade;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Pedido pedido;
	
	public ItemPedido() {
		
	}

	public ItemPedido(int quantidade, Produto produto, Pedido pedido) {
		super();
		this.precoUn = produto.getPreco();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecoUn() {
		return precoUn;
	}

	public void setPrecoUn(Double preco_un) {
		this.precoUn = preco_un;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
