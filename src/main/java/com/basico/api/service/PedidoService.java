package com.basico.api.service;

import java.util.Optional;

import com.basico.api.model.Pedido;

public interface PedidoService{
	
	public Iterable<Pedido> obterTodosPedidos();
	
	public Optional<Pedido> ObterPedidoPeloId(Long id);
	
	public Pedido cadastrarPedido(Long cliente_id, Long produto_id, Double desconto, int quantidade);
	
	public Pedido editarPedido(Pedido pedido);
	
	public void deletarPedido(Long id);
	

}
