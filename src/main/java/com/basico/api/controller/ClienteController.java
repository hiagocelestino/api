package com.basico.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.dto.ClienteDTO;
import com.basico.api.model.Cliente;
import com.basico.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/todos")
	public List<ClienteDTO> obterTodosClientes() throws Exception{
		List<Cliente> clientes = clienteService.obterTodosClientes();
		List<ClienteDTO> clientesDTO = clientes.stream().map(cliente -> ClienteDTO.toDTO(cliente)).collect(Collectors.toList());
		return clientesDTO;
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> obterClientePeloId(@PathVariable Long id){
		Optional<Cliente> cliente = clienteService.obterClientePeloId(id);
		return cliente;
	}
	
	@PostMapping
	public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteDTO.toCliente();
		clienteService.cadastrarCliente(cliente);
		return ClienteDTO.toDTO(cliente);
	}
	
	@PutMapping
	public ClienteDTO alterarCliente(@RequestBody Cliente cliente){
		return ClienteDTO.toDTO(clienteService.alterarCliente(cliente));
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}

}
