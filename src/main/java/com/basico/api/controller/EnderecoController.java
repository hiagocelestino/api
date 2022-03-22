package com.basico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basico.api.dto.EnderecoDTO;
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
	public EnderecoDTO cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		Endereco endereco = enderecoDTO.toEndereco();
		enderecoService.cadastrarEndereco(endereco);
		return EnderecoDTO.toDTO(endereco);
	}
	
	@PutMapping
	public EnderecoDTO alterarEndereco(@RequestBody Endereco endereco) {
		return EnderecoDTO.toDTO(enderecoService.alterarEndereco(endereco));
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereco(@PathVariable Long id) {
		enderecoService.deletarEndereco(id);
	}
}
