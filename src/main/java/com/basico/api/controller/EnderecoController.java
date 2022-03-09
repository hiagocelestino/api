package com.basico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.model.Endereco;
import com.basico.api.service.impl.EnderecoServiceImpl;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoServiceImpl enderecoServiceImpl;
	
	@GetMapping("/{id_cliente}")
	public Iterable<Endereco> obterEnderecosCliente(@PathVariable Long id_cliente){
		return enderecoServiceImpl.obterTodosEnderecos(id_cliente);	
	}
	
	@PostMapping
	public Endereco cadastrarEndereco(Endereco endereco) {
		return enderecoServiceImpl.cadastrarEndereco(endereco);
	}
	
	@PutMapping
	public Endereco alterarEndereco(Endereco endereco) {
		return enderecoServiceImpl.alterarEndereco(endereco);
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereco(@PathVariable Long id) {
		enderecoServiceImpl.deletarEndereco(id);
	}
}
