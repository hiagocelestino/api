package com.basico.api.dto;

import java.util.List;

import com.basico.api.model.Cliente;
import com.basico.api.model.Endereco;

public class ClienteDTO {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String celular;
	
	private List<Endereco> enderecos;
	
	public ClienteDTO() {
		
	}
	
	
	
	public ClienteDTO(Long id, String nome, String cpf, String celular, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.enderecos = enderecos;
	}



	public Cliente toCliente() {
		return new Cliente(nome, cpf, celular);
	}
	
	public static ClienteDTO toDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(), cliente.getEnderecos());
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
