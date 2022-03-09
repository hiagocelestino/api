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

import com.basico.api.model.Cliente;
import com.basico.api.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public Iterable<Cliente> obterTodosClientes() {
		return clienteService.obterTodosClientes();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Cliente> obterClientePeloId(@PathVariable Long id){
		return clienteService.obterClientePeloId(id);
	}
	
	@PostMapping
	public Cliente cadastrarCliente(Cliente cliente) {
		clienteService.cadastrarCliente(cliente);
		return cliente;
	}
	
	@PutMapping
	public Cliente alterarCliente(Cliente cliente) {
		return clienteService.alterarCliente(cliente);
	}
	
	@DeleteMapping(path="/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}

}
