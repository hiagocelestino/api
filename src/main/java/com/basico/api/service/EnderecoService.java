package com.basico.api.service;

import java.util.Optional;

import com.basico.api.model.Endereco;

public interface EnderecoService {
	
	public Iterable<Endereco> obterTodosEnderecos(Long id_cliente);
	
	public Optional<Endereco> obterEnderecoPeloId(Long id);
	
	public Endereco cadastrarEndereco(Endereco endereco);
			
	public Endereco alterarEndereco(Endereco endereco);
	
	public void deletarEndereco(Long id);

}
