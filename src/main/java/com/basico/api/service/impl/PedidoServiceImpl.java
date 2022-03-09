package com.basico.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.basico.api.model.Pedido;
import com.basico.api.repository.PedidoRepository;
import com.basico.api.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Iterable<Pedido> obterTodosPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> ObterPedidoPeloId(Long id) {
		return pedidoRepository.findById(id);
	}
	
	public Pedido cadastrarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido editarPedido(Pedido pedido) {
		Optional<Pedido> retorno = ObterPedidoPeloId(pedido.getId());
		if(retorno.isPresent()) {
			return pedidoRepository.save(pedido);
		}
		else {
			throw new IllegalArgumentException("Não foi possível encontrar o pedido.");
		}
	}
	
	public void deletarPedido(Long id) {
		Optional<Pedido> retorno = ObterPedidoPeloId(id);
		if(retorno.isPresent()) {
			pedidoRepository.deleteById(id);
		} 
		else {
			throw new IllegalArgumentException("Pedido não encontrado.");
		}
	}

}
