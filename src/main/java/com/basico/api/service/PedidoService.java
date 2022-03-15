package com.basico.api.service;

import java.util.Optional;

import com.basico.api.model.Pedido;

public interface PedidoService{
	
	public Optional<Iterable<Pedido>> obterTodosPedidos(Long clienteId);
	
	public Optional<Pedido> ObterPedidoPeloId(Long id);
	
	public Pedido cadastrarPedido(Long clienteId, Long produtoId, Double desconto, int quantidade);
	
	public Pedido editarPedido(Pedido pedido);
	
	public void deletarPedido(Long id);
	

}
