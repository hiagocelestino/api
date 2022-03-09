package com.basico.api.service;

import java.util.Optional;

import com.basico.api.model.Pedido;

public interface PedidoService{
	
	public Iterable<Pedido> obterTodosPedidos();
	
	public Optional<Pedido> ObterPedidoPeloId(Long id);
	
	public Pedido cadastrarPedido(Pedido pedido);
	
	public Pedido editarPedido(Pedido pedido);
	
	public void deletarPedido(Long id);
	

}
