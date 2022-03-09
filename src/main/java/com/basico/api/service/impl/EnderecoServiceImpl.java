package com.basico.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.basico.api.model.Endereco;
import com.basico.api.repository.EnderecoRepository;
import com.basico.api.service.EnderecoService;

@Component("EnderecoController")
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Iterable<Endereco> obterTodosEnderecos(Long id_cliente){
		return enderecoRepository.findByIdCliente(id_cliente);
	}
	
	public Optional<Endereco> obterEnderecoPeloId(Long id) {
		return enderecoRepository.findById(id);
	}
	
	public Endereco cadastrarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco alterarEndereco(Endereco endereco) {
		try {
			Optional<Endereco> retorno = obterEnderecoPeloId(endereco.getId());
			if (retorno.isPresent()){
				return enderecoRepository.save(endereco);
			} else {
				throw new IllegalArgumentException("Endereco não foi encontrado.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha na alteração do Endereco.");
		}
	}
	
	public void deletarEndereco(Long id) {
		Optional<Endereco> retorno = obterEnderecoPeloId(id);
		if(retorno.isPresent()) {
			enderecoRepository.deleteById(id);
		} else {
		 throw new IllegalArgumentException("Cliente não encontrado!");
		}
	}

}
