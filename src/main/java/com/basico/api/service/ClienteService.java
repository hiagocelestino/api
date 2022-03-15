package com.basico.api.service;

import java.util.Optional;

import com.basico.api.model.Cliente;

public interface ClienteService {
	
	public Optional<Cliente> obterClientePeloId(Long id);
	
	public Cliente cadastrarCliente(Cliente cliente);
			
	public Cliente alterarCliente(Cliente cliente);
	
	public void deletarCliente(Long id);

}
