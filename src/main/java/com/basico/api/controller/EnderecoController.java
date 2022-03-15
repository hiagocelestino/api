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
import com.basico.api.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping("/{id}")
	public Iterable<Endereco> obterEnderecosCliente(@PathVariable Long id){
		return enderecoService.obterTodosEnderecos(id);	
	}
	
	@PostMapping
	public Endereco cadastrarEndereco(Endereco endereco) {
		return enderecoService.cadastrarEndereco(endereco);
	}
	
	@PutMapping
	public Endereco alterarEndereco(Endereco endereco) {
		return enderecoService.alterarEndereco(endereco);
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereco(@PathVariable Long id) {
		enderecoService.deletarEndereco(id);
	}
}
