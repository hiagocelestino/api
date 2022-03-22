package com.basico.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.basico.api.model.Cliente;
import com.basico.api.repository.ClienteRepository;
import com.basico.api.service.ClienteService;

@Component("ClienteController")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> obterTodosClientes() throws Exception{
		return (List<Cliente>) clienteRepository.findAll();
	}
	public Optional<Cliente> obterClientePeloId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		try {
			Optional<Cliente> retorno = obterClientePeloId(cliente.getId());
			if (retorno.isPresent()){
				clienteRepository.save(cliente);
				return cliente;
			} else {
				throw new IllegalArgumentException("Cliente não foi encontrado.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha na alteração do cliente.");
		}
	}
	
	public void deletarCliente(Long id) {
		Optional<Cliente> retorno = obterClientePeloId(id);
		if(retorno.isPresent()) {
			Cliente cliente = retorno.get();
			cliente.setStatus(false);
			clienteRepository.save(cliente);
		} else {
		 throw new IllegalArgumentException("Cliente não encontrado!");
		}
	}
	
}
