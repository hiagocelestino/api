package com.basico.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.model.Pedido;
import com.basico.api.service.impl.PedidoServiceImpl;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoServiceImpl pedidoServiceImpl;
	
	@PostMapping
	public Pedido cadastrarPedido(@RequestBody Map<String, String> parametros) {
		Long cliente_id = Long.parseLong(parametros.get("cliente_id"));
		Long produto_id = Long.parseLong(parametros.get("produto_id"));
		Double desconto   = Double.parseDouble(parametros.get("desconto")); 
		int quantidade = Integer.parseInt(parametros.get("quantidade"));
		return pedidoServiceImpl.cadastrarPedido(cliente_id, produto_id, desconto, quantidade);
	}

}
