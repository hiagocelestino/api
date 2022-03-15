package com.basico.api.controller;

import java.util.Map;
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

import com.basico.api.model.Pedido;
import com.basico.api.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/todos/{id}")
	public Optional<Iterable<Pedido>> buscarTodosPedidos(@PathVariable Long id){
		return pedidoService.obterTodosPedidos(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Pedido> buscarPedidoPeloId(@PathVariable Long id){
		return pedidoService.ObterPedidoPeloId(id);
	}
	
	@PostMapping
	public Pedido cadastrarPedido(@RequestBody Map<String, String> parametros) {
		Long clienteId = Long.parseLong(parametros.get("clienteId"));
		Long produtoId = Long.parseLong(parametros.get("produtoId"));
		Double desconto   = Double.parseDouble(parametros.get("desconto")); 
		int quantidade = Integer.parseInt(parametros.get("quantidade"));
		return pedidoService.cadastrarPedido(clienteId, produtoId, desconto, quantidade);
	}
	
	@PutMapping
	public Pedido alterarPedido(@RequestBody Pedido pedido) {
		return pedidoService.editarPedido(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPedido(@PathVariable Long id) {
		pedidoService.deletarPedido(id);
	}
		
}
